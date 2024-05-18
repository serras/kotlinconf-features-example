enum class Problem {
    CONNECTION,
    AUTHENTICATION,
    UNKNOWN;
}

sealed interface Status {
    data object Loading: Status
    data class Error(val problem: Problem): Status
    data class Ok(val data: List<String>): Status
}

fun Status.render(): String = when (this) {
    is Status.Loading -> "loading"
    is Status.Ok if data.isEmpty() -> "no data"
    is Status.Ok -> data.joinToString()
    is Status.Error if problem == Problem.AUTHENTICATION -> "wrong credentials"
    is Status.Error -> "error"
}
