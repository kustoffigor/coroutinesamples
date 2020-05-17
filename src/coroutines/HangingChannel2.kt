package coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlin.random.Random

fun CoroutineScope.barProducer() : ReceiveChannel<String> = produce {
    send("string1")
    send("string2")
    send("string3")
}

suspend fun notHanging() : String = coroutineScope {
    val values = this.barProducer()
    for (value in values) println(value)
    "not hanging"
}

suspend fun main() {
    notHanging()
}