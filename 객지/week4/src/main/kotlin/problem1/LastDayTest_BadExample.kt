package problem1

fun main()
{
    println("연도를 입력해주세요: ")
    val year=readln().toInt()

    println("월을 입력해주세요: ")
    var month=readln().toInt()
    val lastDay=getLastDay(year, month)
    println("$year 년 $month 월의 마지막 날은 $lastDay 입니다")
}

fun getLastDay(year: Int, month: Int): Int {
    if (month == 1) {
        return 31
    } else if (month == 3) {
        return 31
    } else if (month == 5) {
        return 31
    } else if (month == 7) {
        return 31
    } else if (month == 8) {
        return 31
    } else if (month == 10) {
        return 31
    } else if (month == 12) {
        return 31
    } else if (month == 4) {
        return 30
    } else if (month == 6) {
        return 30
    } else if (month == 9) {
        return 30
    } else if (month == 11) {
        return 30
    } else if ((month == 2) && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
        return 29
    } else {
        return 28
    }
}