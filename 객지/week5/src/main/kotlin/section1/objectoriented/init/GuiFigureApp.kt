package section1.objectoriented.init

import java.util.*

fun main() {
    val rectangle = Rectangle()
    val circle = Circle()
    val triangle = Triangle()
    while (true) {
        val select = getUserInput()
        when (select) {
            1 -> {
                rectangle.rotate()
                rectangle.playSound()
            }

            2 -> {
                circle.rotate()
                circle.playSound()
            }

            3 -> {
                triangle.rotate()
                triangle.playSound()
            }

            4 -> return
        }
    }
}

fun getUserInput(): Int {
    val scanner = Scanner(System.`in`)
    println("다음 중 하나의 행동을 선택하세요 ")
    println("1. 사각형클릭, 2.원클릭, 3.삼각형클릭, 4.종료")
    print(">>")
    return scanner.nextInt()
}