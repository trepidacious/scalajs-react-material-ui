
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object SnackbarContent {
  
  @js.native
  trait Props extends js.Object {
    var action: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Any] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var elevation: js.UndefOr[Double] = js.native
    var message: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var square: js.UndefOr[Boolean] = js.native
  }

  @JSImport("@material-ui/core/SnackbarContent", JSImport.Default)
  @js.native
  object SnackbarContentJS extends js.Object

  val jsFnComponent = JsFnComponent[Props, Children.None](SnackbarContentJS)
  
  /**
   * 
   * @param action
   *        The action to display.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   *        Passed to Paper
   * @param elevation
   *        Shadow depth, corresponds to `dp` in the spec.
   *        It's accepting values between 0 and 24 inclusive.
   *        Passed to Paper
   * @param message
   *        The message to display.
   * @param square
   *        If `true`, rounded corners are disabled.
   *        Passed to Paper
   */
  def apply(
    action: js.UndefOr[VdomNode] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Any] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    elevation: js.UndefOr[Double] = js.undefined,
    message: js.UndefOr[VdomNode] = js.undefined,
    square: js.UndefOr[Boolean] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    p.action = action.map(v => v.rawNode)
    p.className = className
    p.classes = classes
    p.component = component
    p.elevation = elevation
    p.message = message.map(v => v.rawNode)
    p.square = square

    jsFnComponent(p)()
  }

}
        