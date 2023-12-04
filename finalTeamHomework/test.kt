package test
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.io.*
import java.util.Arrays

data class Event(val title : String, val date: Date, val dessciption : String)


object EventManager
{
    val EventList = mutableListOf<Event>()
    val EventDates = mutableSetOf<Date>()

    fun AddEvent()
    {
        println("이벤트 시작 시간을 입력하시오(yyyy/MM/dd hh:mm:ss)")
        val startDateTimeString = readLine() // 시작 시간 입력
        val startFormatter = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        val startDate: Date = startFormatter.parse(startDateTimeString) // 시작 시간 문자열을 Date로 변환

        println("이벤트 종료 시간을 입력하시오(yyyy/MM/dd hh:mm:ss)")
        val endDateTimeString = readLine() // 종료 시간 입력
        val endFormatter = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        val endDate: Date = endFormatter.parse(endDateTimeString) // 종료 시간 문자열을 Date로 변환
        
        val startCalendar = Calendar.getInstance()
        startCalendar.time = startDate // 시작 시간 Date 객체를 Calendar에 설정

        val endCalendar = Calendar.getInstance()
        endCalendar.time = endDate // 종료 시간 Date 객체를 Calendar에 설정

        val startYear = startCalendar.get(Calendar.YEAR) // 시작 시간의 연도 추출
        val startMonth = startCalendar.get(Calendar.MONTH) + 1 // 시작 시간의 월 추출 (0부터 시작하므로 +1 해줘야 함)
        val startDay = startCalendar.get(Calendar.DAY_OF_MONTH)
        val endYear = endCalendar.get(Calendar.YEAR) // 종료 시간의 연도 추출
        val endMonth = endCalendar.get(Calendar.MONTH) + 1 // 종료 시간의 월 추출 (0부터 시작하므로 +1 해줘야 함)
        val endDay = startCalendar.get(Calendar.DAY_OF_MONTH)

        println("입력한 시작 시간의 연도는: $startYear")
        println("입력한 시작 시간의 월은: $startMonth")
        println("입력한 시작 시간의 일은: $startDay")

        println("입력한 종료 시간의 연도는: $endYear")
        println("입력한 종료 시간의 월은: $endMonth")
        println("입력한 시작 시간의 일은: $endDay")
    }

}

object CalendarManager
{

    fun printCalendar(year: Int, month: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month - 1,1)

        val maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        println("${year}년 ${month}월 달력")
        println("   Sun   Mon   Tue   Wed   Thu   Fri   Sat")

        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)//요일 얻기
        var count = 1
        var weekcount = 1

        for (i in 1 until dayOfWeek) {
            print("      ")
            count++
        }

        while (calendar.get(Calendar.DAY_OF_MONTH) <= maxDayOfMonth) {
            print("%6d".format(calendar.get(Calendar.DAY_OF_MONTH)))
            if (count % 7 == 0) {
                weekcount++
                println()
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            count++

            if (calendar.get(Calendar.DAY_OF_MONTH) == 1 && count != 1) {
                // 달이 바뀌었을 때 반복 종료
                println("\n")
                break
            }
        }
    }
    fun printCalendarWeek(year : Int, month : Int, weekNumber : Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month - 1) // 월은 0부터 시작하므로 1을 빼줍니다.
        calendar.set(Calendar.DAY_OF_MONTH, 1) // 해당 월의 1일로 설정합니다.

        val formatter = "%5d"
        val firstDayOfWeek = (weekNumber - 1) * 7 + 1 // 주의 첫째 날의 날짜 계산

        while (calendar.get(Calendar.WEEK_OF_MONTH) < weekNumber) {
            calendar.add(Calendar.DAY_OF_MONTH, 7) // 다음 주로 이동
        }

        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -1) // 주의 첫째 일요일로 이동
        }

        println("${year}년 ${month}월 ${weekNumber}주차 달력")
        println("   Sun   Mon   Tue   Wed   Thu   Fri   Sat")

        var count = 1

        while (count <= 7) {
            if (calendar.get(Calendar.MONTH) + 1 != month) {
                print("     ") // 해당 월의 날짜가 아니면 공백 출력
            } else {
                print(formatter.format(calendar.get(Calendar.DAY_OF_MONTH)))
            }
            print(" ")
            calendar.add(Calendar.DAY_OF_MONTH, 1) // 다음 날짜로 이동
            count++

            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                println() // 일요일마다 줄바꿈
            }
        }
    }

    fun GetDay()
    {

        println("조회할 달력의 연도를 입력하시오")
        var year = readln().toInt()
        println("조회할 달력의 월을 입력하시오")
        var month = readln().toInt()
        printCalendar(year, month)
    }

    fun GetWeek() //weekcount를 증가시키다가 weekcount가 입력된 값과 같을 때 출력
    {
        println("조회할 달력의 연도를 입력하시오")
        var year = readln().toInt()
        println("조회할 달력의 월을 입력하시오")
        var month = readln().toInt()
        println("몇번째 주차를 출력하시겠습니까? : (1 ~ 5)")
        var week = readln().toInt()
        printCalendarWeek(year, month, week)
    }
}

fun main() {

    while(true)
    {

        println("메뉴 번호를 선택하시오 (1:종료, 2:달력조회, 3:이벤트 추가, 4:이벤트 조회, 5:달력의 주간별로 보기, 6:이벤트 변경)")
        var num = readln().toInt()

        when (num) {
            1 -> {
                println("종료되었습니다")
                break
            }
            2 -> {

                CalendarManager.GetDay()

            }
            3 -> {

                EventManager.AddEvent()

            }
            4 -> {

            }
            5 -> {
                CalendarManager.GetWeek()
            }
            else -> println("잘못된 값을 입력하였습니다.")
        }

    }

}
