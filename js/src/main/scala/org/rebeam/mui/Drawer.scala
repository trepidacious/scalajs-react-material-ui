
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Drawer {
  
  sealed trait Anchor{ val value: String }

  object Anchor {
    case object Left extends Anchor { val value: String = "left" }
    case object Top extends Anchor { val value: String = "top" }
    case object Right extends Anchor { val value: String = "right" }
    case object Bottom extends Anchor { val value: String = "bottom" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Permanent extends Variant { val value: String = "permanent" }
    case object Persistent extends Variant { val value: String = "persistent" }
    case object Temporary extends Variant { val value: String = "temporary" }
  }
          
  @js.native
  trait Props extends js.Object {
    var ModalProps: js.UndefOr[js.Any] = js.native
    var PaperProps: js.UndefOr[js.Any] = js.native
    var SlideProps: js.UndefOr[js.Any] = js.native
    var anchor: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Any] = js.native
    var elevation: js.UndefOr[Double] = js.native
    var onClose: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var open: js.UndefOr[Boolean] = js.native
    var theme: js.Any = js.native
    var transitionDuration: js.UndefOr[js.Any] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/Drawer", JSImport.Default)
  @js.native
  object DrawerJS extends js.Object

  val jsFnComponent = JsFnComponent[Props, Children.Varargs](DrawerJS)
  
  /**
   * The properties of the [Modal](/api/modal) component are available
   * when `variant="temporary"` is set.
   * @param ModalProps
   *        Properties applied to the [`Modal`](/api/modal) element.
   * @param PaperProps
   *        Properties applied to the [`Paper`](/api/paper) element.
   * @param SlideProps
   *        Properties applied to the [`Slide`](/api/slide) element.
   * @param anchor
   *        Side from which the drawer will appear.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param elevation
   *        The elevation of the drawer.
   * @param onClose
   *        Callback fired when the component requests to be closed.
   *        
   *        parameter {object} event The event source of the callback
   * @param open
   *        If `true`, the drawer is open.
   * @param theme
   *        Property spread to root element
   * @param transitionDuration
   *        The duration for the transition, in milliseconds.
   *        You may specify a single timeout for all transitions, or individually with an object.
   * @param variant
   *        The variant to use.
   */
  def apply(
    ModalProps: js.UndefOr[js.Any] = js.undefined,
    PaperProps: js.UndefOr[js.Any] = js.undefined,
    SlideProps: js.UndefOr[js.Any] = js.undefined,
    anchor: js.UndefOr[Anchor] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Any] = js.undefined,
    elevation: js.UndefOr[Double] = js.undefined,
    onClose: js.UndefOr[Callback] = js.undefined,
    open: js.UndefOr[Boolean] = js.undefined,
    theme: js.Any,
    transitionDuration: js.UndefOr[js.Any] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    p.ModalProps = ModalProps
    p.PaperProps = PaperProps
    p.SlideProps = SlideProps
    p.anchor = anchor.map(v => v.value)
    p.className = className
    p.classes = classes
    p.elevation = elevation
    p.onClose = onClose.map(v => v.toJsFn)
    p.open = open
    p.theme = theme
    p.transitionDuration = transitionDuration
    p.variant = variant.map(v => v.value)

    jsFnComponent(p)(children: _*)
  }

}
        