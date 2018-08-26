
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Paper {
  
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Any] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var elevation: js.UndefOr[Double] = js.native
    var key: js.UndefOr[String] = js.native
    var square: js.UndefOr[Boolean] = js.native
  }

  @JSImport("@material-ui/core/Paper", JSImport.Default)
  @js.native
  object PaperJS extends js.Object

  val jsFnComponent = JsFnComponent[Props, Children.Varargs](PaperJS)
  
  /**
   * 
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param elevation
   *        Shadow depth, corresponds to `dp` in the spec.
   *        It's accepting values between 0 and 24 inclusive.
   * @param key
   *        React key
   * @param square
   *        If `true`, rounded corners are disabled.
   */
  def apply(
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Any] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    elevation: js.UndefOr[Double] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    square: js.UndefOr[Boolean] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (elevation.isDefined) {p.elevation = elevation}
    if (key.isDefined) {p.key = key}
    if (square.isDefined) {p.square = square}

    jsFnComponent(p)(children: _*)
  }

}
        