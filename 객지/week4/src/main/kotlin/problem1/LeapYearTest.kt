package problem1

fun main() {
    println("연도를 입력해주세요: ")
    var year = readln().toInt()
    if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
        println("$year 은 윤년입니다.")
    } else {
        println("$year 은 평년입니다.")
    }
}

fun isLeapYear(year: Int)=(year%400==0)||(year%4==0 && year%100!=0)
