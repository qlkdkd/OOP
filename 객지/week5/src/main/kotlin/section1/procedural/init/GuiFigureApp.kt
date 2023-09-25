package week5.section1.procedural.init.section1.procedural.init

import java.util.*

var shapes = arrayOf("RECTANGLE", "CIRCLE", "TRIANGLE")
var shapes_sound = arrayOf("rectangle.aif", "circle.aif", "triangle.aif")

fun main() {
    while (true) {
        val select = getUserInput()
        if (select == 4) break
        rotate(select)
        playSound(select)
    }
}

fun getUserInput(): Int {
    val scanner = Scanner(System.`in`)
    println("다음 중 하나의 행동을 선택하세요 ")
    println("1. 사각형클릭, 2.원클릭, 3.삼각형클릭, 4.종료")
    print(">>")
    return scanner.nextInt()
}

fun rotate(shapeNum: Int) {
    println("도형 360도 회전:" + shapes[shapeNum - 1])
}

fun playSound(shapeNum: Int) {
    println("AIF 사운드 재생:" + shapes_sound[shapeNum - 1])
}