
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object StepContent {
  
  sealed trait Orientation{ val value: String }

  object Orientation {
    case object Horizontal extends Orientation { val value: String = "horizontal" }
    case object Vertical extends Orientation { val value: String = "vertical" }
  }
          
  @js.native
  trait Props extends js.Object {
    var TransitionComponent: js.UndefOr[js.Any] = js.native
    var TransitionProps: js.UndefOr[js.Any] = js.native
    var active: js.UndefOr[Boolean] = js.native
    var alternativeLabel: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Any] = js.native
    var completed: js.UndefOr[Boolean] = js.native
    var last: js.UndefOr[Boolean] = js.native
    var optional: js.UndefOr[Boolean] = js.native
    var orientation: js.UndefOr[String] = js.native
    var transitionDuration: js.UndefOr[js.Any] = js.native
  }

  @JSImport("@material-ui/core/StepContent", JSImport.Default)
  @js.native
  object StepContentJS extends js.Object

  val jsFnComponent = JsFnComponent[Props, Children.Varargs](StepContentJS)
  
  /**
   * 
   * @param TransitionComponent
   *        Collapse component.
   * @param TransitionProps
   *        Properties applied to the `Transition` element.
   * @param active
   *        Property spread to root element
   *        Expands the content.
   * @param alternativeLabel
   *        Property spread to root element
   *        Set internally by Step when it's supplied with the alternativeLabel property.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param completed
   *        Property spread to root element
   * @param last
   *        Property spread to root element
   * @param optional
   *        Property spread to root element
   *        Set internally by Step when it's supplied with the optional property.
   * @param orientation
   *        Property spread to root element
   * @param transitionDuration
   *        Adjust the duration of the content expand transition.
   *        Passed as a property to the transition component.
   *        
   *        Set to 'auto' to automatically calculate transition time based on height.
   */
  def apply(
    TransitionComponent: js.UndefOr[js.Any] = js.undefined,
    TransitionProps: js.UndefOr[js.Any] = js.undefined,
    active: js.UndefOr[Boolean] = js.undefined,
    alternativeLabel: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Any] = js.undefined,
    completed: js.UndefOr[Boolean] = js.undefined,
    last: js.UndefOr[Boolean] = js.undefined,
    optional: js.UndefOr[Boolean] = js.undefined,
    orientation: js.UndefOr[Orientation] = js.undefined,
    transitionDuration: js.UndefOr[js.Any] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    p.TransitionComponent = TransitionComponent
    p.TransitionProps = TransitionProps
    p.active = active
    p.alternativeLabel = alternativeLabel
    p.className = className
    p.classes = classes
    p.completed = completed
    p.last = last
    p.optional = optional
    p.orientation = orientation.map(v => v.value)
    p.transitionDuration = transitionDuration

    jsFnComponent(p)(children: _*)
  }

}
        