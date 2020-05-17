package coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlin.random.Random

// https://medium.com/@elizarov/cold-flows-hot-channels-d74769805f9

fun CoroutineScope.fooProducer() : ReceiveChannel<String> = produce {
    while (true) {
        send("str${Random.nextInt()}" )
    }
}

suspend fun hangs() : String = coroutineScope {
    val values = this.fooProducer()
   "hangs"
}

suspend fun main() {
    hangs()
}