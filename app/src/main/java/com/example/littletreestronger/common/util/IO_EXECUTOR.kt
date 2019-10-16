package com.example.littletreestronger.common.util

import java.util.concurrent.Executors







private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

/**
 * Utility method to run blocks on TestAnnotation dedicated background thread, used for io/database work.
 */
fun runOnIoThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}