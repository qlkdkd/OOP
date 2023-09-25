package problem3

fun main() {
    var year= inputValidYear()
    println("입력받은 연도는 $year 입니다")
    var month= inputValidMonth()
    println("입력받은 월은 $month 입니다")
    var day = inputValidDay(year,month)
    println("입력받은 일은 $day 입니다")
}

fun inputValidDay(year: Int, month: Int): Int {
    return 0
}

fun inputValidMonth(): Int {
    return 0
}

fun inputValidYear() : Int {
    var year=1
    do {
        print("연도를 입력하시오>")
        year = readln().toInt()
    } while (year <= 0)
    return year
}