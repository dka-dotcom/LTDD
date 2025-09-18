package com.example.ltdd

import kotlinx.coroutines.*

// Khai báo hàm tạm ngưng
suspend fun getValue(): Double {
    // long running work or calls to other suspend functions
    delay(500) // ví dụ giả lập tác vụ lâu
    return 42.0
}

// Gọi hàm tạm ngưng từ một hàm tạm ngưng khác
suspend fun processValue() {
    val value = getValue()
    println("Processed value: $value")
}

// Đối tượng singleton
object DataProviderManager {
    // Có thể khai báo thêm dữ liệu hoặc hàm ở đây
}

// Enum class
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

fun main() = runBlocking {
    // Chạy một hàm tạm ngưng trong GlobalScope
    GlobalScope.launch {
        val output = getValue()
        println("GlobalScope launch output: $output")
    }

    // Truy cập và hủy một coroutine job
    val job: Job = GlobalScope.launch {
        val output = getValue()
        println("Job output: $output")
    }
    job.cancel() // Hủy job

    // Chạy hàm tạm ngưng và chặn luồng hiện tại
    val blockingOutput = getValue()
    println("RunBlocking output: $blockingOutput")

    // Sử dụng async/await cho phép trì hoãn
    val deferred = async { getValue() }
    println("Async/Await output: ${deferred.await()}")

    // Phát hiện ngoại lệ
    try {
        println("Direction check")
        val direction = Direction.NORTH
        when (direction) {
            Direction.NORTH -> println("Go north")
            Direction.SOUTH -> println("Go south")
            Direction.WEST -> println("Go west")
            Direction.EAST -> println("Go east")
        }
    } catch (exception: Exception) {
        println("Caught exception: ${exception.message}")
    }
}
