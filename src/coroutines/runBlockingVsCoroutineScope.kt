package coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// runBlocking - starts a coroutine and blocks calling thread. not a suspend function
// coroutineScope - suspend function. suspends until all childs are complete

suspend fun main() {
    val elapsedTime = measureTimeMillis {
        withContext(newSingleThreadContext("single")) {
            launch { delay(1000); println("child 0 is finished")}
            coroutineScope {
                launch { delay(1000); println("child 1 is finihed") }
                launch { delay(1000); println("child 2 is finished") }
            }
        }
    }

    println("With coroutineScope completed in $elapsedTime")

    val elapsedTimeRunBlocking = measureTimeMillis {
        withContext(newSingleThreadContext("single")) {
            launch { delay(1000); println("child 0 is finished")}
            runBlocking {
                launch { delay(1000); println("child 1 is finihed") }
                launch { delay(1000); println("child 2 is finished") }
            }
        }
    }

    println("With runBlocking completed in $elapsedTimeRunBlocking")
}