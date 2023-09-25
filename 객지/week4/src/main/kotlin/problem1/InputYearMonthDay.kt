package problem1

fun main() {
    var year: Int
    var month: Int
    var day: Int

    // 연도 입력
    do {
        print("연도를 입력하시오: ")
        year = readLine()?.toIntOrNull() ?: 0
    } while (year <= 0)

    // 월 입력
    do {
        print("월을 입력하시오: ")
        month = readLine()?.toIntOrNull() ?: 0
    } while (month < 1 || month > 12)

    // 월에 따른 일 입력
    do {
        print("일을 입력하시오: ")
        day = readLine()?.toIntOrNull() ?: 0
    } while (day < 1 || day > getDaysInMonth(year, month))

    println("입력받은 년월일은 $year 년 $month 월 $day 일입니다.")
}

// 해당 월의 일수를 반환하는 함수
fun getDaysInMonth(year: Int, month: Int): Int {
    return when (month) {
        4, 6, 9, 11 -> 30
        2 -> if (isLeapYear_(year)) 29 else 28
        else -> 31
    }
}

// 윤년 여부를 판단하는 함수
fun isLeapYear_(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}
