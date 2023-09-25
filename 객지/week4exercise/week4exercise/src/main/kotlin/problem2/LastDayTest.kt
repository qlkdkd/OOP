package problem2

import problem1.isLeapYear

fun main() {
    print("연도를 입력하시오>")
    val year = readln().toInt()

    print("월을 입력하시오>")
    val month = readln().toInt()

    val lastDay = getLastDay(year, month)
    println("$year 년 $month 월의 마지막 날은 $lastDay 입니다")
}

fun getLastDay(year: Int, month: Int): Int {
    return when(month) {
        1,3,5,7,8,10,12 ->  31
        4,6,9,11 ->  30
        2 -> {
            if (isLeapYear(year))  29
            else  28
        }
        else -> {
            println("월이 올바른 값이 아닙니다.")
            0
        }
    }
/*
    if (month==1 || month==3)
        return 31
    else if (month==4 || month==6 || month==9)
        return 30
    else if (month==2) {
        if (isLeapYear(year))
            return 29
        else return 28
    } else {
        println("월이 올바른 값이 아닙니다.")
        return 0
    }

 */
//    when(month) {
//        1 -> return 31
//        3 -> return 31
//        4 -> return 30
//        2 -> {
//            if (isLeapYear(year))
//                return 29
//            else
//                return 28
//        }
//    }
//    when(month) {
//        1,3,5,7,8,10,12 -> return 31
//        4,6,9,11 -> return 30
//        2 -> {
//            if (isLeapYear(year)) return 29
//            else return 28
//        }
//        else -> return 0
//    }



}
