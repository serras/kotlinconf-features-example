import kotlinx.datetime.Clock

interface Logger {
    fun log(message: String)
}

data class User(val id: Long, val name: String, val age: Int)

// old style with context receivers

context(Logger) fun logWithTime(message: String) =
    log("[${Clock.System.now()}] $message")

context(Logger) fun User.save() {
    logWithTime("start saving user $id")
    // do something
    logWithTime("end saving user $id")
}

// translation with context parameters
/*
// context parameters are accessed as parameters
context(logger: Logger) fun logWithTime(message: String) =
    logger.log("[${LocalTime.now()}] $message")

// context parameters are automatically resolved
context(_: Logger) fun User.save() {
    logWithTime("start saving user $id")
    // do something
    logWithTime("end saving user $id")
}
*/
