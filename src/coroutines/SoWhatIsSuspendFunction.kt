package coroutines

import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


// taken from https://stackoverflow.com/questions/47871868/what-does-suspend-function-mean-in-kotlin-coroutine

var continuation: Continuation<Int>? = null

fun main() = runBlocking {
    launch(Unconfined) {
        val a = a()
        println("Result is $a")
    }
    10.downTo(0).forEach {
        continuation!!.resume(it)
    }
}

suspend fun a(): Int {
    return b()
}

suspend fun b(): Int {
    while (true) {
        val i = suspendCoroutine<Int> { cont -> continuation = cont }
        if (i == 0) {
            return 0
        }
    }
}

