package test
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.io.*

data class Event(var title : String, var date: Date, var description : String)
var path="eventFile.txt"//이벤트를 저장할 파일

object EventManager
{
    val EventList = mutableListOf<Event>()
    val EventDates = mutableSetOf<Date>()

    // 파일 내 이미 존재하는 이벤트를 로드하기
    init {
        loadEventsFromFile()
    }

    // 파일 내 이벤트를 로드하는 함수
    private fun loadEventsFromFile() {
        val file = File(path)
        if (file.exists()) {
            val br: BufferedReader
            try {
                br = file.bufferedReader()
            } catch (e: Exception) {
                return
            }

            br.useLines { lines ->
                lines.forEach { line ->
                    val event = parseEvent(line)
                    if (event != null) {
                        EventList.add(event)
                        EventDates.add(event.date)
                    }
                }
            }
        }
    }

    // line을 분석하고 이벤트 객체를 생성하는 함수
    private fun parseEvent(line: String): Event? {

        val parts = line.split("\n")
        if (parts.size == 4) {
            val startDateString = parts[0].substringAfter(":").trim()
            val endDateString = parts[1].substringAfter(":").trim()
            val eventName = parts[2].substringAfter(":").trim()
            val eventDetails = parts[3].substringAfter(":").trim()

            val startFormatter = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
            val startDate = startFormatter.parse(startDateString)

            return Event(eventName, startDate, eventDetails)
        }

        return null
    }

    // 파일을 저장하는 함수
    private fun saveEventsToFile() {
        val file = File(path)
        val bw = BufferedWriter(
            OutputStreamWriter(FileOutputStream(file))
        )

        for (event in EventList) {
            val outString = "입력날짜: ${event.date}\n종료날짜: ${event.date}\n이름: ${event.title}\n세부사항: ${event.description}"
            bw.write(outString)
            bw.newLine()
        }

        bw.close()

    }


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

        println("이벤트 이름을 입력하시오:")
        val eventName = readLine() ?: ""//이벤트 이름 입력

        println("이벤트 세부사항을 입력하시오: ")
        val eventDetails=readln()?:""

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

        println("이벤트가 저장되었습니다.")

        //이벤트입력 받음-> 이벤트 저장
        val outString="입력날짜: $startYear/$startMonth/$startDay\n종료날짜: $endYear:$endMonth:$endDay\n이름: $eventName\n세부사항: $eventDetails"
        val file=File(path)
        val bw=BufferedWriter(
            OutputStreamWriter(FileOutputStream(file)))
        bw.write(outString)
        bw.close()

        val event = Event(eventName, startDate, eventDetails)
        EventList.add(event)
        EventDates.add(startDate)

        // Save events to the file
        saveEventsToFile()
    }

    //이벤트 조회
    fun ViewEvent(path: String){
        val br: BufferedReader
        try{
            br=File(path).bufferedReader()
        }catch(e: Exception){return}

        val inputString=br.use{it.readText()}
        println(inputString)
    }

    //이벤트를 날짜로 검색하는 함수
    private fun findEventByDate(date: Date): Event?{
        for(event in EventList){
            if(event.date==date){
                return event
            }
        }
        return null
    }
    //이벤트 변경 함수
    fun ChangeEvent() {
        println("변경할 이벤트 시작 시간을 입력하시오(yyyy/MM/dd hh:mm:ss)")
        val startDateTimeString = readLine() // 변경할 이벤트 시작 시간 입력
        val startFormatter = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        val startDate: Date = startFormatter.parse(startDateTimeString) // 시작 시간 문자열을 Date로 변환

        println("변경할 이벤트 종료 시간을 입력하시오(yyyy/MM/dd hh:mm:ss)")
        val endDateTimeString = readLine() // 변경할 이벤트 종료 시간 입력
        val endFormatter = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        val endDate: Date = endFormatter.parse(endDateTimeString) // 종료 시간 문자열을 Date로 변환

        println("변경할 이벤트 이름을 입력하시오:")
        val eventName = readLine() ?: ""// 변경할 이벤트 이름 입력

        println("변경할 이벤트 세부사항을 입력하시오: ")
        val eventDetails = readLine() ?: ""

        val startCalendar = Calendar.getInstance()
        startCalendar.time = startDate // 변경할 이벤트 시작 시간 Date 객체를 Calendar에 설정

        val endCalendar = Calendar.getInstance()
        endCalendar.time = endDate // 변경할 이벤트 종료 시간 Date 객체를 Calendar에 설정

        val startYear = startCalendar.get(Calendar.YEAR) // 시작 시간의 연도 추출
        val startMonth = startCalendar.get(Calendar.MONTH) + 1 // 시작 시간의 월 추출 (0부터 시작하므로 +1 해줘야 함)
        val startDay = startCalendar.get(Calendar.DAY_OF_MONTH)
        val endYear = endCalendar.get(Calendar.YEAR) // 종료 시간의 연도 추출
        val endMonth = endCalendar.get(Calendar.MONTH) + 1 // 종료 시간의 월 추출 (0부터 시작하므로 +1 해줘야 함)
        val endDay = startCalendar.get(Calendar.DAY_OF_MONTH)

        println("변경한 시작 시간의 연도는: $startYear")
        println("변경한 시작 시간의 월은: $startMonth")
        println("변경한 시작 시간의 일은: $startDay")

        println("변경한 종료 시간의 연도는: $endYear")
        println("변경한 종료 시간의 월은: $endMonth")
        println("변경한 시작 시간의 일은: $endDay")

        println("변경한 이벤트 이름은: $eventName")
        println("변경한 이벤트의 세부사항: $eventDetails")

        // Find and update the existing event
        val existingEvent = findEventByDate(startDate)
        if (existingEvent != null) {
            // Update the existing event with new information
            existingEvent.title = eventName
            existingEvent.date = startDate
            existingEvent.description = eventDetails

            println("이벤트가 성공적으로 변경되었습니다.")
        } else {
            println("변경할 이벤트를 찾을 수 없습니다.")
        }

        // Save events to the file
        saveEventsToFile()
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
                EventManager.ViewEvent(path)
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

