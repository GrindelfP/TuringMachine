package to.grindelf.turingmachine

data class Operation(
    val initialState: String,
    val intendedState: String,
    val initialValue: Char,
    val finalValue: Char,
    val movement: Movement
)

enum class Movement (val value: String) {
    RIGHT("r"),
    LEFT("l"),
    STAY("s")
}
