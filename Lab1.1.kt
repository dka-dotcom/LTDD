package com.example.ltdd

fun main() {
    // In văn bản
    println("Hello, world!")
    println("This is the text to print!")

    // Nhận xét trong code
    // This is a comment line.
    // This is another comment.

    // Biến
    val age = "5"           // Không thể thay đổi
    val name = "Rover"
    var roll = 6            // Có thể thay đổi
    var rolledValue: Int = 4

    // In biến với mẫu chuỗi
    println("You are already ${age}!")
    println("You are already ${age} days old, ${name}!")

    // Gọi hàm không có đối số
    printHello()

    // Gọi hàm có đối số
    printBorder("*", 10)

    // Gọi hàm trả về giá trị
    val rolledNumber = rollDice()
    println("You rolled a $rolledNumber")

    // Kiểm soát luồng - if/else
    val num = 4
    if (num > 4) {
        println("The variable is greater than 4")
    } else if (num == 4) {
        println("The variable is equal to 4")
    } else {
        println("The variable is less than 4")
    }

    // Lặp repeat
    printBorder()

    // Lặp lồng nhau
    printCakeBottom(age = 3, layers = 2)

    // when statement
    val luckyNumber = 4
    val rollResult = (1..6).random()
    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        4 -> println("No luck! You rolled a 4. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
    }

    // Tạo đối tượng từ lớp Dice
    val myFirstDice = Dice(6)
    println("My first dice roll: ${myFirstDice.roll()}")
}

// Hàm không có đối số
fun printHello() {
    println("Hello Kotlin")
}

// Hàm có đối số
fun printBorder(border: String, timesToRepeat: Int) {
    repeat(timesToRepeat) {
        print(border)
    }
    println()
}

// Hàm trả về một giá trị
fun rollDice(): Int {
    val randomNumber = (1..6).random()
    return randomNumber
}

// Hàm lặp repeat
fun printBorder() {
    repeat(23) {
        print("=")
    }
    println()
}

// Hàm lặp lồng nhau
fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }
}

// Lớp đơn giản
class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
