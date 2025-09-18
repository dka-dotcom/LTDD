package com.example.ltdd

fun main() {
    // --- TẬP HỢP (SET) ---
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    val setOfNumbers = numbers.toSet()
    println("Set of numbers: $setOfNumbers")

    val set1 = setOf(1, 2, 3)
    val set2 = mutableSetOf(3, 4, 5)
    println("Giao nhau: ${set1.intersect(set2)}")
    println("Hợp: ${set1.union(set2)}")

    // --- MAP (SƠ ĐỒ) ---
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51

    // Lặp
    peopleAges.forEach { print("${it.key} is ${it.value}, ") }
    println()

    // Chuyển đổi từng mục
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", "))

    // Lọc
    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println("Tên ngắn: $filteredNames")

    // Các phép toán khác trên tập hợp
    val words = listOf("about", "acute", "balloon", "best", "brief", "class")
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
        .sorted()
    println("Filtered words: $filteredWords")

    // --- HÀM PHẠM VI & KHÁC ---
    val arguments: Map<String, String>? = mapOf("LETTER" to "A")
    arguments?.let {
        val letterId = it["LETTER"]
        println("Letter id from let: $letterId")
    }

    // In thuộc tính top-level
    println("Current scrambled word: $currentScrambledWord")

    // Lệnh gọi an toàn
    val intent: Map<String, String>? = null
    val letterId = intent?.get("letter").toString()
    println("Safe call result: $letterId")

    // Hàm Lambda
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println("Triple of 5: ${triple(5)}")

    // Toán tử Elvis
    var quantity: Int? = null
    println(quantity ?: 0)  // in 0
    quantity = 4
    println(quantity ?: 0)  // in 4
}

// --- Đối tượng companion (ví dụ) ---
class DetailActivity {
    companion object {
        const val LETTER = "letter"
    }
}
private var _currentScrambledWord = "test"
val currentScrambledWord: String
    get() = _currentScrambledWord