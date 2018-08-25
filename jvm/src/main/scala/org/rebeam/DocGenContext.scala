package org.rebeam

import ComponentModel._

trait DocGenContext {
  def processComponent(all: Map[String, Component], c: Component): Option[Component]
}

object DocGenContext {

  val callbackFuncType = KnownFuncType("Callback", "scalajs.js.Function0[Unit]", (n: String) => s"$n.toJsFn")

  def eventFuncType(event: String) = KnownFuncType(
    s"$event => Callback", 
    s"scalajs.js.Function1[$event, Unit]", 
    (n: String) => s"(e: $event) => $n(e).runNow()")

  case class FuncData(scalaType: String, jsType: String, assignment: String)

  object MaterialUI extends DocGenContext {

    def processComponent(all: Map[String, Component], c: Component): Option[Component] =
      if(c.description.contains("@ignore")) {
        println("Ignoring " + c.displayName)
        None
      } else {
        Some(
          c.copy(
            props = propsIncludingInheritance(all, c)
              .map {
                case (name, prop) => transformProp(c, name, prop)
              }.map {
                case (name, prop) => sanitiseProp(c, name, prop)
              }.filter {
                case (name, prop) => useProp(c, name, prop)
              }
          )
        )
      }

    def propsIncludingInheritance(all: Map[String, Component], c: Component): List[(String, Prop)] = {

      def additionalPropsFrom(components: String *): List[(String, Prop)] = {
        val existingProps = Map(c.props: _*)

        val additionalProps = components.toList.flatMap(component => all.values.find(_.displayName == component).map(_.props.map{case (n, p) => (component, n, p)}).getOrElse(Nil))

        val updatedProps = additionalProps
          .foldLeft(existingProps){
            case (props, (component, name, additionalProp)) => 
              if (props.isDefinedAt(name)) {
                props
              } else {
                props.updated(name, additionalProp.copy(description = additionalProp.description + "\nPassed to " + component))
              } 
          }

        updatedProps.toList.sortBy(_._1)
      }

      c match {
      
        case Component(_, "Button", _) => additionalPropsFrom("ButtonBase")
        case Component(_, "BottomNavigationAction", _) => additionalPropsFrom("ButtonBase")
        case Component(_, "IconButton", _) => additionalPropsFrom("ButtonBase")
        case Component(_, "StepButton", _) => additionalPropsFrom("ButtonBase")
        case Component(_, "ExpansionPanelSummary", _) => additionalPropsFrom("ButtonBase")
        case Component(_, "Tab", _) => additionalPropsFrom("ButtonBase")
        case Component(_, "TableSortLabel", _) => additionalPropsFrom("ButtonBase")

        case Component(_, "AppBar", _) => additionalPropsFrom("Paper")
        case Component(_, "Card", _) => additionalPropsFrom("Paper")
        case Component(_, "ExpansionPanel", _) => additionalPropsFrom("Paper")
        case Component(_, "MobileStepper", _) => additionalPropsFrom("Paper")
        case Component(_, "SnackbarContent", _) => additionalPropsFrom("Paper")
        case Component(_, "Stepper", _) => additionalPropsFrom("Paper")

        case Component(_, "InputLabel", _) => additionalPropsFrom("FormLabel")

        //Note that this is transitive - Menu is only described as inheriting from
        //Popover, but Popover inerits from Modal
        case Component(_, "Menu", _) => additionalPropsFrom("Popover", "Modal")

        case Component(_, "MenuItem", _) => additionalPropsFrom("ListItem")

        case Component(_, "MenuList", _) => additionalPropsFrom("List")

        case Component(_, "NativeSelect", _) => additionalPropsFrom("Input")
        case Component(_, "Select", _) => additionalPropsFrom("Input")

        //TODO from react-event-listener
        // case Component(_, "ClickAwayListener", _) => additionalPropsFrom("EventListener")

        //TODO from react-transition-group
        // case Component(_, "Collapse", _) => additionalPropsFrom("Transition")
        // case Component(_, "Fade", _) => additionalPropsFrom("Transition")
        // case Component(_, "Grow", _) => additionalPropsFrom("Transition")
        // case Component(_, "Slide", _) => additionalPropsFrom("Transition")
        // case Component(_, "Zoom", _) => additionalPropsFrom("Transition")

        case Component(_, "Dialog", _) => additionalPropsFrom("Modal")
        case Component(_, "Popover", _) => additionalPropsFrom("Modal")

        case Component(_, "DialogContentText", _) => additionalPropsFrom("Typography")

        case Component(_, "RadioGroup", _) => additionalPropsFrom("FormGroup")

        case Component(_, "SwipeableDrawer", _) => additionalPropsFrom("Drawer")

        case Component(_, "TablePagination", _) => additionalPropsFrom("TableCell")

        case Component(_, "TextField", _) => additionalPropsFrom("FormControl")

        case Component(_, _, props) => props
      } 
    }

    def useProp(c: Component, name: String, prop: Prop): Boolean =
      if (name == "children") {
        false
      //TODO have a closer look at this - assuming that these are not meant to be used, but some of them look useful...  
      //     In fact, it looks a lot like these are real properties that are passed through to underlying elements
      //     but that material-ui doesn't want to document (confusingly), and so we should use these properties.
      //     I think the only exception may be for children, where we probably want to treat this as not having children.
      // } else if (prop.required == false && prop.description.trim.toLowerCase == "@ignore") {
      //   false
      } else {
        true
      }

    val mouseEventNames: Set[String] = Set(
      "onClick", "onContextMenu", "onDoubleClick", "onDrag", "onDragEnd", "onDragEnter", "onDragExit",
      "onDragLeave", "onDragOver", "onDragStart", "onDrop", "onMouseDown", "onMouseEnter", "onMouseLeave",
      "onMouseMove", "onMouseOut", "onMouseOver", "onMouseUp",
    )

    val touchEventNames: Set[String] = Set(
      "onTouchCancel", "onTouchEnd", "onTouchMove", "onTouchStart"
    )

    val keyboardEventNames: Set[String] = Set(
      "onKeyDown", "onKeyPress", "onKeyUp"
    )

    val clipboardEventNames: Set[String] = Set(
      "onCopy", "onCut", "onPaste"
    )

    val compositionEventNames: Set[String] = Set(
      "onCompositionEnd", "onCompositionStart", "onCompositionUpdate"
    )

    def sanitiseDescription(s: String): String = s
      .replaceAllLiterally("@ignore", "Property spread to root element")
      .replaceAllLiterally("@param", "parameter")
      .replaceAllLiterally("@returns", "returns")

    def sanitiseProp(c: Component, name: String, prop: Prop): (String, Prop) = {
      name -> prop.copy(description = sanitiseDescription(prop.description))
    }

    def transformProp(c: Component, name: String, prop: Prop): (String, Prop) = {

      def namedFunc(s: String): Boolean = name == s && prop.propType == FuncType
      def eventProp(s: String): (String, Prop) = name -> prop.copy(propType = eventFuncType(s))
      def funcInSet(s: Set[String]): Boolean = s.contains(name) && prop.propType == FuncType

      if (c.displayName == "TextField" && name == "value") {
        name -> prop.copy(propType = StringType)
      
      //These two are only needed to add a description
      } else if (c.displayName == "TextField" && name == "onBlur") {
        name -> eventProp("ReactFocusEvent")._2.copy(description = "Passed to underlying input element")
      } else if (c.displayName == "TextField" && name == "onFocus") {
        name -> eventProp("ReactFocusEvent")._2.copy(description = "Passed to underlying input element")


      // Type events according to 
      // https://reactjs.org/docs/events.html and 
      // https://github.com/japgolly/scalajs-react/blob/master/doc/TYPES.md#events

      // Focus Events
      } else if (namedFunc("onFocus")) {
        eventProp("ReactFocusEvent")
      } else if (namedFunc("onBlur")) {
        eventProp("ReactFocusEvent")


      // Clipboard Events
      } else if (funcInSet(clipboardEventNames)) {
        eventProp("ReactClipboardEvent")


      // Composition Events
      } else if (funcInSet(compositionEventNames)) {
        eventProp("ReactCompositionEvent")
      

      // Keyboard Events
      } else if (funcInSet(keyboardEventNames)) {
        eventProp("ReactKeyboardEvent")


      // Touch Events
      } else if (funcInSet(touchEventNames)) {
        eventProp("ReactTouchEvent")


      // Special case Touch Tap Event
      } else if (namedFunc("onTouchTap")) {
        eventProp("TouchTapEvent")  


      // Mouse Events
      } else if (funcInSet(mouseEventNames)) {
        eventProp("ReactMouseEvent")


      // UI Events
      } else if (namedFunc("onScroll")) {
        eventProp("ReactUIEvent")


      // Wheel Events
      } else if (namedFunc("onWheel")) {
        eventProp("ReactWheelEvent")


      // General "on" handler func - ignore parameters
      } else if (name.startsWith("on") && prop.propType == FuncType) {
        name -> prop.copy(propType = callbackFuncType)

      // For some reason all the "classes" props are marked required, but they're not
      } else if (name == "classes" && prop.propType == ObjectType) {
        name -> prop.copy(required = false)

      // type is not a legal name in Scala
      } else if (name == "type") {
        "`type`" -> prop      
      
      } else {
        name -> prop
      }
    }

    
  }

}