package Test

import problem1.getDaysInMonth

fun main()
{
    val year: Int
    val month: Int
    val day: Int

    do{
        println("연도를 입력하세요: ")
        val year=readln().toInt()
    }while (year>0)

    do{
        println("월을 입력학세요: ")
        val month=readln().toInt()
    }while (month>=1 && month<=12)

    do{
        println("날짜를 입력해주세요: ")
        val day=readln().toInt()
    }while(day>=1 && day<=31)
}

fun LeapYear(year: Int): Boolean{
    return (year%400==0 || (year%4==0 && year%100!=0))
}

