# scalajs-react-material-ui

Facade for [material-ui](https://material-ui.com/) 1.5.0 in [scalajs-react](https://github.com/japgolly/scalajs-react).

Contains code to generate a facade for each material-ui component, based on the json API description generated by [react-docgen](https://github.com/reactjs/react-docgen) from material-ui itself, and the results of that generation.

This uses a few heuristics to assign more detailed types (mostly for functions), and to include props from base classes (e.g. `Button` includes `ButtonBase` props). Hopefully this will allow for relatively easy updates to new material-ui versions.

Project is in a very early state:

1. Only a few components have been tested, incompletely.
2. Some types are approximate, in particular `PropTypes.oneOfType` is just presented as `js.Any`.
3. Common React events are presented with correct event types, other event props just expect a Callback and will therefore discard event parameters (if any).
4. See **Todo** below for more...

## Building

Until this is published properly, you will need to clone the project, run `sbt`, then `publishLocal`. The generated facade is checked in so you don't need to run the code generation unless you want to work on the generator itself.

Code generation is not done the right way - .scala files are just generated directly into the js src folder, under package `org.rebeam.mui`, by running `scalajsReactMaterialUIJVM/run` from sbt.

To regenerate the `muiapi.json` data describing the components, check out the material-ui project, then in the mateerial-ui project root, run react-docgen:

```
npx react-docgen .\packages\material-ui\src\ -o muiapi.json --pretty
```

You may need to trim some non-component data, for 1.5.0 this was just a `reactHelpers.js` at the end of the file.

Then copy the `muiapi.json` file to resources. 

## Notes

Material-ui of the correct version (see above) must be available for import - each component is imported individually, e.g.:
```scala
@JSImport("@material-ui/core/Snackbar", JSImport.Default)
```

For icons, see [scalajs-react-material-icons](https://github.com/trepidacious/scalajs-react-material-icons).

Some component props are PascalCase, for example `TextField` has a `InputProps` prop. These have been left in PascalCase for now - they generally accept a `js.Object` containing props that will be passed through to a sub-element of the component.

All components provide an optional extra prop, `additionalProps` that is not found in the original material-ui component API. This can be passed a `js.Object`, and each field of that object will be passed as a prop to the underlying material-ui JS component. Any fields with names matching actual documented props of the component will only be used if those props are not specified already. This emulates the spread operator in JS.

When using event props like `onClick`, be careful to retrieve any required data from the event _outside_ the `Callback` itself - otherwise the event may have been reused before the `Callback` runs, leading to errors. For example we might want to set some state to remember the anchor for a menu when a button is clicked:

```scala
mui.IconButton(
  onClick = (e: ReactMouseEvent) => {
    // Get the target here, outside the Callback
    val anchor = e.currentTarget
    
    // Now we can use the anchor value in the modState callback
    scope.modState(_.copy(menuAnchor = Some(anchor)))
  }
)(
  icons.AccountCircle()
)
```

## Todo

1. Support `PropTypes.oneOfType`
2. Better support and testing of array props
3. Colors
4. Icons
5. More testing/demos
6. Check all components are included
7. ExpansionPanel onChange parameters
8. Any other missing events from native elements? E.g. onClick on MenuItem is not documented.
9. Aria properties
10. id, ref, etc.
11. Detect `classes` prop and accept a Map[String, String]?
12. Consider changing PascalCase prop names to camelCase to be more idiomatic. Consider typing these based on a map from prop names to the Component name of the sub element. This would still allow use of a `js.Object` containing props, in an `additionalProps` field.
13. Support component methods