
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object TablePagination {
  
  sealed trait Padding{ val value: String }

  object Padding {
    case object Default extends Padding { val value: String = "default" }
    case object Checkbox extends Padding { val value: String = "checkbox" }
    case object Dense extends Padding { val value: String = "dense" }
    case object None extends Padding { val value: String = "none" }
  }
            
  sealed trait SortDirection{ val value: String }

  object SortDirection {
    case object Asc extends SortDirection { val value: String = "asc" }
    case object Desc extends SortDirection { val value: String = "desc" }
    case object False extends SortDirection { val value: String = "false" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Head extends Variant { val value: String = "head" }
    case object Body extends Variant { val value: String = "body" }
    case object Footer extends Variant { val value: String = "footer" }
  }
          
  @js.native
  trait Props extends js.Object {
    var ActionsComponent: js.UndefOr[js.Any] = js.native
    var SelectProps: js.UndefOr[js.Any] = js.native
    var backIconButtonProps: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Any] = js.native
    var colSpan: js.UndefOr[Double] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var count: Double = js.native
    var labelDisplayedRows: js.UndefOr[js.Any] = js.native
    var labelRowsPerPage: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var nextIconButtonProps: js.UndefOr[js.Any] = js.native
    var numeric: js.UndefOr[Boolean] = js.native
    var onChangePage: scalajs.js.Function0[Unit] = js.native
    var onChangeRowsPerPage: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var padding: js.UndefOr[String] = js.native
    var page: Double = js.native
    var rowsPerPage: Double = js.native
    var rowsPerPageOptions: js.UndefOr[List[js.Any]] = js.native
    var scope: js.UndefOr[String] = js.native
    var sortDirection: js.UndefOr[String] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/TablePagination", JSImport.Default)
  @js.native
  object TablePaginationJS extends js.Object

  val jsFnComponent = JsFnComponent[Props, Children.None](TablePaginationJS)
  
  /**
   * A `TableCell` based component for placing inside `TableFooter` for pagination.
   * @param ActionsComponent
   *        The component used for displaying the actions.
   *        Either a string to use a DOM element or a component.
   * @param SelectProps
   *        Properties applied to the rows per page [`Select`](/api/select) element.
   * @param backIconButtonProps
   *        Properties applied to the back arrow [`IconButton`](/api/icon-button) component.
   * @param className
   *        Property spread to root element
   *        Passed to TableCell
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param colSpan
   *        Property spread to root element
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param count
   *        The total number of rows.
   * @param labelDisplayedRows
   *        Customize the displayed rows label.
   * @param labelRowsPerPage
   *        Customize the rows per page label. Invoked with a `{ from, to, count, page }`
   *        object.
   * @param nextIconButtonProps
   *        Properties applied to the next arrow [`IconButton`](/api/icon-button) element.
   * @param numeric
   *        If `true`, content will align to the right.
   *        Passed to TableCell
   * @param onChangePage
   *        Callback fired when the page is changed.
   *        
   *        parameter {object} event The event source of the callback
   *        parameter {number} page The page selected
   * @param onChangeRowsPerPage
   *        Callback fired when the number of rows per page is changed.
   *        
   *        parameter {object} event The event source of the callback
   * @param padding
   *        Sets the padding applied to the cell.
   *        By default, the Table parent component set the value.
   *        Passed to TableCell
   * @param page
   *        The zero-based index of the current page.
   * @param rowsPerPage
   *        The number of rows per page.
   * @param rowsPerPageOptions
   *        Customizes the options of the rows per page select field. If less than two options are
   *        available, no select field will be displayed.
   * @param scope
   *        Set scope attribute.
   *        Passed to TableCell
   * @param sortDirection
   *        Set aria-sort direction.
   *        Passed to TableCell
   * @param variant
   *        Specify the cell type.
   *        By default, the TableHead, TableBody or TableFooter parent component set the value.
   *        Passed to TableCell
   */
  def apply(
    ActionsComponent: js.UndefOr[js.Any] = js.undefined,
    SelectProps: js.UndefOr[js.Any] = js.undefined,
    backIconButtonProps: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Any] = js.undefined,
    colSpan: js.UndefOr[Double] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    count: Double,
    labelDisplayedRows: js.UndefOr[js.Any] = js.undefined,
    labelRowsPerPage: js.UndefOr[VdomNode] = js.undefined,
    nextIconButtonProps: js.UndefOr[js.Any] = js.undefined,
    numeric: js.UndefOr[Boolean] = js.undefined,
    onChangePage: Callback,
    onChangeRowsPerPage: js.UndefOr[Callback] = js.undefined,
    padding: js.UndefOr[Padding] = js.undefined,
    page: Double,
    rowsPerPage: Double,
    rowsPerPageOptions: js.UndefOr[List[js.Any]] = js.undefined,
    scope: js.UndefOr[String] = js.undefined,
    sortDirection: js.UndefOr[SortDirection] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    p.ActionsComponent = ActionsComponent
    p.SelectProps = SelectProps
    p.backIconButtonProps = backIconButtonProps
    p.className = className
    p.classes = classes
    p.colSpan = colSpan
    p.component = component
    p.count = count
    p.labelDisplayedRows = labelDisplayedRows
    p.labelRowsPerPage = labelRowsPerPage.map(v => v.rawNode)
    p.nextIconButtonProps = nextIconButtonProps
    p.numeric = numeric
    p.onChangePage = onChangePage.toJsFn
    p.onChangeRowsPerPage = onChangeRowsPerPage.map(v => v.toJsFn)
    p.padding = padding.map(v => v.value)
    p.page = page
    p.rowsPerPage = rowsPerPage
    p.rowsPerPageOptions = rowsPerPageOptions
    p.scope = scope
    p.sortDirection = sortDirection.map(v => v.value)
    p.variant = variant.map(v => v.value)

    jsFnComponent(p)()
  }

}
        