package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// runBlocking won't track GlobalScope coroutines. Since they are kind of global

// This code prints nothing
fun main() {
    runBlocking {
        for (i in 1..2) {
            GlobalScope.launch {
                Thread.sleep(1000)
                println("work $i done")
            }
        }
    }
}