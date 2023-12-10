package test

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import test.EventManager.getEventCounts
import java.util.Calendar
import java.util.Date
import java.io.*

data class Event(var title : String, var sDate: Date, var eDate: Date, var description : String)

object EventManager
{
    private const val path = "eventFile.json" // 이벤트를 저장할 파일

    val eventList = mutableListOf<Event>()

    // 파일 내 이미 존재하는 이벤트를 로드하기
    init {
        loadEventsFromFile()
    }

    // 파일 내 이벤트를 로드하는 함수
    private fun loadEventsFromFile() {
        val file = File(path)
        if (file.exists()) {
            val jsonString = file.readText()
            val eventType = object : TypeToken<List<Event>>() {}.type
            val events: List<Event> = Gson().fromJson(jsonString, eventType)

            eventList.addAll(events)
        }
    }

    // 파일을 저장하는 함수
    private fun saveEventsToFile() {
        val jsonString = Gson().toJson(eventList)
        val file = File(path)
        file.writeText(jsonString)
    }

    //이벤트 추가
    fun AddEvent() {
        println("이벤트 시작 시간을 입력하시오(yyyy/MM/dd hh:mm:ss)")
        val startDateTimeString = readLine() // 시작 시간 입력
        val startFormatter = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        val startDate: Date = startFormatter.parse(startDateTimeString) // 시작 시간 문자열을 Date로 변환

        println("이벤트 종료 시간을 입력하시오(yyyy/MM/dd hh:mm:ss)")
        val endDateTimeString = readLine() // 종료 시간 입력
        val endFormatter = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        val endDate: Date = endFormatter.parse(endDateTimeString) // 종료 시간 문자열을 Date로 변환

        println("이벤트 이름을 입력하시오:")
        val eventName = readLine() ?: ""//이벤트 이름 입력

        println("이벤트 세부사항을 입력하시오: ")
        val eventDetails = readLine() ?: ""

        val event = Event(eventName, startDate, endDate, eventDetails)//이벤트 내 값을 데이터 클래스에 저장
        eventList.add(event)//이벤트들을 리스트에 저장

        println("이벤트가 성공적으로 저장되었습니다.")

        // Save events to the file
        saveEventsToFile()//이벤트를 파일 내에 저장
    }

    // 이벤트 조회
    fun ViewEvent() {
        println("이벤트 날짜를 입력하시오(yyyy/MM/dd):")
        val eventDateString = readLine()//이벤트 조회 날짜 입력
        val edFormatter = SimpleDateFormat("yyyy/MM/dd")
        val eventDate: Date = edFormatter.parse(eventDateString)//이벤트 조회 날짜를 Date타입으로 분석/변환

        val matchingEvents = eventList.filter {
            val calendar = Calendar.getInstance()
            calendar.time = it.sDate
            val eventCalendar = Calendar.getInstance()
            eventCalendar.time = eventDate

            calendar.get(Calendar.YEAR) == eventCalendar.get(Calendar.YEAR) &&
                    calendar.get(Calendar.MONTH) == eventCalendar.get(Calendar.MONTH) &&
                    calendar.get(Calendar.DAY_OF_MONTH) == eventCalendar.get(Calendar.DAY_OF_MONTH)
        }

        if (matchingEvents.isNotEmpty()) {
            println("검색한 이벤트를 찾았습니다:")
            for (event in matchingEvents) {
                println("이벤트 이름: ${event.title}")
                println("이벤트 시작 시간: ${event.sDate}")
                println("이벤트 종료 시간: ${event.eDate}")
                println("이벤트 세부사항: ${event.description}")
                println()
            }
        } else {
            println("검색한 이벤트를 찾을 수 없습니다.")
        }
    }


    // 이벤트 변경 함수
    fun ChangeEvent() {
        println("변경할 이벤트 날짜을 입력하시오(yyyy/MM/dd hh:mm:ss):")
        val eventNameString = readLine() ?: ""//변경할 이벤트 날짜 조회
        val enFormatter=SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        val eventNameToChange: Date=enFormatter.parse(eventNameString)

        // Find the event to be changed
        val eventToChange = eventList.find { it.sDate == eventNameToChange}

        if (eventToChange != null) {
            // Display the existing event details
            println("현재 이벤트 정보:")
            println("이벤트 이름: ${eventToChange.title}")
            println("이벤트 시작 시간: ${eventToChange.sDate}")
            println("이벤트 세부사항: ${eventToChange.description}")

            // Collect new event information
            println("변경할 이벤트 시작 시간을 입력하시오(yyyy/MM/dd hh:mm:ss): ")
            val startDateTimeString = readLine() // 변경할 이벤트 시작 시간 입력
            val startFormatter = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
            val startDate: Date = startFormatter.parse(startDateTimeString) // 시작 시간 문자열을 Date로 변환

            println("변경할 이벤트 종료 시간을 입력하시오(yyyy/MM/dd hh:mm:ss): ")
            val endDateTimeString=readLine()
            val endFormatter=SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
            val endDate: Date=endFormatter.parse(endDateTimeString)
            println("변경할 이벤트 이름을 입력하시오: ")
            val eventName=readLine() ?: ""

            println("변경할 이벤트 세부사항을 입력하시오: ")
            val eventDetails = readLine() ?: ""

            // Update the existing event with new information
            eventToChange.sDate = startDate
            eventToChange.eDate=endDate
            eventToChange.title=eventName
            eventToChange.description = eventDetails

            println("이벤트가 성공적으로 변경되었습니다.")
        } else {
            println("변경할 이벤트를 찾을 수 없습니다.")
        }

        // Save events to the file
        saveEventsToFile()
    }

    fun getEventCounts(year: Int, month: Int): Map<Int, Int>
    {
        val counts = mutableMapOf<Int, Int>()

        // 해당 연도와 월에 해당하는 이벤트만 필터링하여 개수 세기
        val filteredEvents = eventList.filter {
            val calendar = Calendar.getInstance()
            calendar.time = it.sDate
            calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) + 1 == month
        }

        // 날짜별 이벤트 개수 세기
        for (event in filteredEvents) {
            val calendar = Calendar.getInstance()
            calendar.time = event.sDate
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            counts[dayOfMonth] = counts.getOrDefault(dayOfMonth, 0) + 1
        }

        return counts
    }

}

object CalendarManager
{
    private val printCalendar = PrintCalendar()
    private val printCalendarWeek = PrintCalendarWeek()

    fun GetDay()
    {

        println("조회할 달력의 연도를 입력하시오")
        var year = readln().toInt()
        println("조회할 달력의 월을 입력하시오")
        var month = readln().toInt()
        printCalendar.printCalendar(year, month)
    }

    fun GetWeek() //weekcount를 증가시키다가 weekcount가 입력된 값과 같을 때 출력
    {
        println("조회할 달력의 연도를 입력하시오")
        var year = readln().toInt()
        println("조회할 달력의 월을 입력하시오")
        var month = readln().toInt()
        println("몇번째 주차를 출력하시겠습니까? : (1 ~ 5)")
        var week = readln().toInt()
        printCalendarWeek.printCalendarWeek(year, month, week)
    }

}

class PrintCalendar
{
    fun printCalendar(year: Int, month: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month - 1, 1)

        val maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        println("${year}년 ${month}월 달력")
        println(" Sun   Mon   Tue   Wed   Thu   Fri   Sat")

        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) // 시작 요일 구하기
        var count = 1

        val eventCounts = getEventCounts(year, month) // 해당 월의 이벤트 개수 가져오기

        // 시작 요일까지 공백으로 출력
        for (i in 1 until dayOfWeek) {
            print("%6s".format(" "))
            count++
        }

        while (calendar.get(Calendar.DAY_OF_MONTH) <= maxDayOfMonth) {
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            val eventCount = eventCounts[dayOfMonth] ?: 0

            // 날짜와 이벤트 카운트 출력 포맷 지정
            val formattedDate = "%02d".format(dayOfMonth)
            val formattedEventCount = if (eventCount > 0) "($eventCount)" else "  "

            val formattedItem = "%3s%3s".format(formattedDate, formattedEventCount)

            if (count % 7 == 0) {
                println(formattedItem)
            } else {
                print("$formattedItem")
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
}

class PrintCalendarWeek
{
    fun printCalendarWeek(year: Int, month: Int, weekNumber: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month - 1, 1)

        while (calendar.get(Calendar.WEEK_OF_MONTH) < weekNumber) {
            calendar.add(Calendar.DAY_OF_MONTH, 7)
        }

        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -1)
        }

        println("${year}년 ${month}월 ${weekNumber}주차 달력")
        println(" Sun   Mon   Tue   Wed   Thu   Fri   Sat")

        var count = 1

        val eventCounts = getEventCounts(year, month)

        while (count <= 7) {
            val currentMonth = calendar.get(Calendar.MONTH) + 1
            val formattedDay = if (currentMonth != month) {
                "     "
            } else {
                val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
                val eventCount = eventCounts[dayOfMonth] ?: 0
                val formattedEventCount = if (eventCount > 0) "($eventCount)" else "   "
                "%02d$formattedEventCount".format(dayOfMonth)
            }
            print(" $formattedDay")
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            count++

            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                println()
            }
        }
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
                EventManager.ViewEvent()
            }
            5 -> {
                CalendarManager.GetWeek()
            }
            6->{
                EventManager.ChangeEvent()
            }
            else -> println("잘못된 값을 입력하였습니다.")
        }

    }

}