package io.github.rubenquadros.gameweekscout.server.ai.persistence

import com.google.api.core.ApiFuture
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.concurrent.Executors
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

internal suspend fun <T>ApiFuture<T>.await(): T {
    val result = suspendCancellableCoroutine { cancellableContinuation ->
        val executor = Executors.newSingleThreadExecutor()

        cancellableContinuation.invokeOnCancellation {
            this.cancel(true)
            executor.shutdown()
        }

        this.addListener({
            try {
                val writeResult = this.get()
                cancellableContinuation.resume(writeResult)
            } catch (e: Exception) {
                cancellableContinuation.resumeWithException(e)
            } finally {
                executor.shutdown()
            }
        }, executor)
    }

    return result
}