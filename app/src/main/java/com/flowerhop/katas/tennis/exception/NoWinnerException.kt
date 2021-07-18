package com.flowerhop.katas.tennis.exception

class NoWinnerException : Exception {
    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable):  super(message, cause)
    constructor(cause: Throwable): super(cause)
}
