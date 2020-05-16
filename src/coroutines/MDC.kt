package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.slf4j.MDCContext
import kotlinx.coroutines.withContext
import org.slf4j.MDC
import kotlin.math.log

// here is how to do MDC-logging with coroutines
// https://medium.com/@elizarov/phantom-of-the-coroutine-afc63b03a131

suspend fun doSomeWork() {
    delay(1000)
}

suspend fun main() {
    MDC.put("key", "value")
    val newContextMap = MDC.getCopyOfContextMap()
    newContextMap.put("login", "user")
    val data = withContext(MDCContext(newContextMap)) {
        doSomeWork()
    }

}