package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


suspend fun action1() {
    delay(1000)
    println("Action 1 is finished")
}

suspend fun action2() {
    delay(10000)
    println("Action 2 is finished")
}

// this way runInParallel suspends until both actions are finished
suspend fun runInParallel() = coroutineScope {
    action1()
    this.launch { action2() }
}

suspend fun main()  {
    runInParallel()
}