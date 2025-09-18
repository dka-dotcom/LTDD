package com.example.ltdd

import kotlin.math.PI

// ----- Lớp trừu tượng -----
abstract class Dwelling() {
    abstract val buildingMaterial: String
    abstract fun floorArea(): Double
}

// ----- Đánh dấu lớp open để có thể kế thừa -----
open class RoundHut(residents: Int) {
}

// ----- Tạo lớp con mở rộng lớp mẹ -----
class SquareCabin : Dwelling() {
    override val buildingMaterial: String
        get() = "Wood"

    // Ghi đè hàm từ lớp cha
    override fun floorArea(): Double {
        return TODO("Provide the return value")
    }
}

fun main() {
    // ----- Danh sách -----
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println(numbers.size)           // Lấy kích thước
    println(numbers[0])             // Lấy mục đầu tiên
    println(listOf("red", "blue", "green").reversed())

    val entrees = mutableListOf<String>()
    entrees.add("spaghetti")
    entrees[0] = "lasagna"
    entrees.remove("lasagna")

    // ----- Vòng lặp -----
    val myList = listOf("A", "B", "C")
    for (element in myList) {
        println(element)
    }

    var index = 0
    while (index < myList.size) {
        println(myList[index])
        index++
    }

    // ----- Chuỗi -----
    val name = "Android"
    println(name.length)

    val number = 10
    println("$number people")

    val groups = 5
    println("${number * groups} people")

    // ----- Toán tử gán tăng cường -----
    var a = 5
    var b = 3
    a += b
    a -= b
    a *= b
    a /= b

    // ----- with -----
    val squareCabin = SquareCabin()
    with(squareCabin) {
//        with(squareCabin) {
//            println("Capacity: ${capacity}")
              println("Material: ${buildingMaterial}")
//            println("Has room? ${hasRoom()}")
//        }
    }

    val radius = 2.0
    println(kotlin.math.PI * radius * radius)

    fun addToppings(vararg toppings: String) {
        println("Toppings: ${toppings.joinToString()}")
    }
    addToppings("Cheese", "Tomato")
}
