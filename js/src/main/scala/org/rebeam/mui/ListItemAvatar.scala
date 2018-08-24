
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object ListItemAvatar {
  
  @js.native
  trait Props extends js.Object {
    
  }

  @JSImport("@material-ui/core/ListItemAvatar", JSImport.Default)
  @js.native
  object ListItemAvatarJS extends js.Object

  val jsFnComponent = JsFnComponent[Props, Children.Varargs](ListItemAvatarJS)
  
  /**
   * This is a simple wrapper to apply the `dense` mode styles to `Avatar`.
   */
  def apply(
    
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    

    jsFnComponent(p)(children: _*)
  }

}
        