package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

// coroutineScope == withContext(this.coroutineContext)

// Following code are identical, but using coroutineScope is preferred way

suspend fun withContextAction() {
    withContext(coroutineContext) {
        delay(1000)
        println("Finished with context action")
    }
}

suspend fun coroutineScopeAction() = coroutineScope {
    delay(1000)
    println("println finished coroutineScope action")
}
