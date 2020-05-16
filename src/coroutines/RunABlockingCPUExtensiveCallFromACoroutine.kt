package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.math.BigInteger
import java.util.Random

// Ok, we got this

fun findBigPrime() : BigInteger =
    BigInteger.probablePrime(4096, Random())

// So how to call this out of the coroutine?
// Here is the way

suspend fun bigPrime() =
    withContext(Dispatchers.Default) {
        findBigPrime()
    }

suspend fun main() {
    bigPrime()
}