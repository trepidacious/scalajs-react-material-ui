
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Typography {
  
  sealed trait Align{ val value: String }

  object Align {
    case object Center extends Align { val value: String = "center" }
    case object Left extends Align { val value: String = "left" }
    case object Justify extends Align { val value: String = "justify" }
    case object Right extends Align { val value: String = "right" }
    case object Inherit extends Align { val value: String = "inherit" }
  }
            
  sealed trait Color{ val value: String }

  object Color {
    case object Secondary extends Color { val value: String = "secondary" }
    case object TextPrimary extends Color { val value: String = "textPrimary" }
    case object Primary extends Color { val value: String = "primary" }
    case object Default extends Color { val value: String = "default" }
    case object Error extends Color { val value: String = "error" }
    case object Inherit extends Color { val value: String = "inherit" }
    case object TextSecondary extends Color { val value: String = "textSecondary" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Button extends Variant { val value: String = "button" }
    case object Display2 extends Variant { val value: String = "display2" }
    case object Display3 extends Variant { val value: String = "display3" }
    case object Display1 extends Variant { val value: String = "display1" }
    case object Title extends Variant { val value: String = "title" }
    case object Body1 extends Variant { val value: String = "body1" }
    case object Subheading extends Variant { val value: String = "subheading" }
    case object Headline extends Variant { val value: String = "headline" }
    case object Display4 extends Variant { val value: String = "display4" }
    case object Body2 extends Variant { val value: String = "body2" }
    case object Caption extends Variant { val value: String = "caption" }
  }
          
  @js.native
  trait Props extends js.Object {
    var align: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Any] = js.native
    var color: js.UndefOr[String] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var gutterBottom: js.UndefOr[Boolean] = js.native
    var headlineMapping: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var noWrap: js.UndefOr[Boolean] = js.native
    var paragraph: js.UndefOr[Boolean] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/Typography", JSImport.Default)
  @js.native
  object TypographyJS extends js.Object

  val jsFnComponent = JsFnComponent[Props, Children.Varargs](TypographyJS)
  
  /**
   * 
   * @param align
   *        Set the text-align on the component.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param color
   *        The color of the component. It supports those theme colors that make sense for this component.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   *        By default, it maps the variant to a good default headline component.
   * @param gutterBottom
   *        If `true`, the text will have a bottom margin.
   * @param headlineMapping
   *        We are empirically mapping the variant property to a range of different DOM element types.
   *        For instance, h1 to h6. If you wish to change that mapping, you can provide your own.
   *        Alternatively, you can use the `component` property.
   * @param key
   *        React key
   * @param noWrap
   *        If `true`, the text will not wrap, but instead will truncate with an ellipsis.
   * @param paragraph
   *        If `true`, the text will have a bottom margin.
   * @param variant
   *        Applies the theme typography styles.
   */
  def apply(
    align: js.UndefOr[Align] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Any] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    gutterBottom: js.UndefOr[Boolean] = js.undefined,
    headlineMapping: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    noWrap: js.UndefOr[Boolean] = js.undefined,
    paragraph: js.UndefOr[Boolean] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (align.isDefined) {p.align = align.map(v => v.value)}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (component.isDefined) {p.component = component}
    if (gutterBottom.isDefined) {p.gutterBottom = gutterBottom}
    if (headlineMapping.isDefined) {p.headlineMapping = headlineMapping}
    if (key.isDefined) {p.key = key}
    if (noWrap.isDefined) {p.noWrap = noWrap}
    if (paragraph.isDefined) {p.paragraph = paragraph}
    if (variant.isDefined) {p.variant = variant.map(v => v.value)}

    jsFnComponent(p)(children: _*)
  }

}
        