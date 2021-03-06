
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object StepIcon {
  
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var completed: js.UndefOr[Boolean] = js.native
    var error: js.UndefOr[Boolean] = js.native
    var icon: japgolly.scalajs.react.raw.React.Node = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/StepIcon", JSImport.Default)
  @js.native
  object StepIconJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.None](StepIconJS)
  
  /**
   * 
   * @param active
   *        Whether this step is active.
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param completed
   *        Mark the step as completed. Is passed to child components.
   * @param error
   *        Mark the step as failed.
   * @param icon
   *        The icon displayed by the step label.
   * @param key
   *        React key
   * @param style
   *        React element CSS style
   * @param additionalProps
   *        Optional parameter - if specified, this must be a js.Object containing additional props
   *        to pass to the underlying JS component. Each field of additionalProps will be added to the
   *        JS props object, if a field with the same name is not already present (from one of the other
   *        parameters of this function). This functions like `...additionalProps` at the beginning of the
   *        component in JS. Used for e.g. Downshift integration, where Downshift will provide properties
   *        in this format to be added to rendered components.
   *        Since this is untyped, use with care - e.g. make sure props are in the correct format for JS components
   */
  def apply(
    active: js.UndefOr[Boolean] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    completed: js.UndefOr[Boolean] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    icon: VdomNode,
    key: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (classes.isDefined) {p.classes = classes}
    if (completed.isDefined) {p.completed = completed}
    if (error.isDefined) {p.error = error}
    p.icon = icon.rawNode
    if (key.isDefined) {p.key = key}
    if (style.isDefined) {p.style = style.map(v => v.o)}

    additionalProps.foreach {
      a => {
        val dict = a.asInstanceOf[js.Dictionary[js.Any]]
        val pDict = p.asInstanceOf[js.Dictionary[js.Any]]
        for ((prop, value) <- dict) {
          if (!p.hasOwnProperty(prop)) pDict(prop) = value
        }
      }
    }
    
    jsComponent(p)
  }

}
        