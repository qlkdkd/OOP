package practice2

class Rectangle {
    var width: Double=0.0
    var height: Double=0.0

    fun calcArea()=width*height
}

fun main(){
    val rect=Rectangle()//객체 생성
    println("사각형의 폭을 입력하세요: ")
    rect.width=readln().toDouble()//객체 프로터티 접근
    println("사각형의 높이를 입력하세요: ")
    rect.height=readln().toDouble()

    println("사각형의 넓이: ${rect.calcArea()}")
}