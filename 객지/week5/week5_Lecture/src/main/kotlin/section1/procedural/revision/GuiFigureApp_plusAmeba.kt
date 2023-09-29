package section1.procedural.revision

import java.util.*

var shapes = arrayOf("RECTANGLE", "CIRCLE", "TRIANGLE", "AMEBA") // 아메바 추가
var shapes_sound = arrayOf("rectangle.aif", "circle.aif", "triangle.aif", "ameba.hif") // ameba.hif 추가


fun main() {
    while (true) {
        val select = getUserInput()
        if (select == 5) // 종료번호 변경
            break
        rotate(select)
        playSound(select)
    }
}

fun getUserInput(): Int {
    val scanner = Scanner(System.`in`)
    println("다음 중 하나의 행동을 선택하세요 ")
    println("1. 사각형클릭, 2.원클릭, 3.삼각형클릭, 4.아메바, 5.종료") // 아메바 추가
    print(">>")
    return scanner.nextInt()
}

fun rotate(shapeNum: Int) {
    if (shapes[shapeNum - 1] == "AMEBA") // 추가
        println("도형의 한쪽 끝을 기준으로 360도 회전:" + shapes[shapeNum - 1]) // 추가
    else println("도형의 중심을 기준으로 360도 회전:" + shapes[shapeNum - 1])
}

fun playSound(shapeNum: Int) {
    if (shapes[shapeNum - 1] == "AMEBA") // 추가
        println("HIF 사운드 재생:" + shapes_sound[shapeNum - 1]) // 추가
    else println("AIF 사운드 재생:" + shapes_sound[shapeNum - 1])
}