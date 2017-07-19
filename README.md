# Arcania Flux
Arcania Flux is a WIP 2D platformer with physics and magic as its core gameplay
themes.

## To Do
* UI
    * Create more full widgets.
        * Dialog box
        * Scrolling box (with text/images)
        * Ticker box
        * Check button
        * Radio button
        * Slider
        * Input box (accepts numbers, characters, or both)
        * Label (alphanumeric string)
    * Create widget containers.
        * List container (contains buttons with labels, padding between fields)
    * Create widget factories.
    * Decouple widget logic code from state input processors.
    * Add accessors and mutators.
* State
    * Find a cleaner way to initialize state and its member fields.
    * Refactor terminology from "gamestate" to "state".
    * Consider creating input and audio singleton classes.
* Actor
    * Begin creating rudimentary actor hierarchy.
    * Avoid duplicating code between actors and widgets.
        * Consider creating common interfaces between the two.