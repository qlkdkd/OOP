package problem1

fun main()
{
    println("연도를 입력해주세요: ")
    val year=readln().toInt()

    println("월을 입력해주세요: ")
    var month=readln().toInt()
    val lastDay=getLastDay_2(year, month)
    println("$year 년 $month 월의 마지막 날은 $lastDay 입니다")
}

fun getLastDay_2(year: Int, month: Int) {
    when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> {
            if (isLeapYear(year)) 29
            else 28
        }

        else -> println("월이 올바른 값이 아닙니다.")
    }
}

