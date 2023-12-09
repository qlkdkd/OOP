package prac2

import com.google.gson.Gson
import prac1.Student
import java.io.File

data class Student (
    val id: String,
    val name: String,
    val dept: String,
    val age: Int
)

fun main() {
    val student = Student("100", "Lee", "사물인터넷", 21)

    val jsonString = Gson().toJson(student)
    println(jsonString)
    File("output.txt").writeText(jsonString)

    val resultString = File("output.txt").readText()
    println("output = $resultString")
    val resultObject = Gson().fromJson(resultString,Student::class.java)
    println(resultObject)
}