package coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// So the contract here - launch in background and immediately return

fun CoroutineScope.launchFoo() = launch {
    delay(1000)
    println("foo")
}