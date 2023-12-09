package homework

import java.io.*

data class Student(val id: String, val name: String, val major: String, val age: Int)

fun saveDataToFile(students: Array<Student>, path: String) {
    try {
        BufferedWriter(FileWriter(path)).use { writer ->
            students.forEach { student ->
                writer.write("${student.id},${student.name},${student.major},${student.age}\n")
            }
        }
        println("Data saved to $path")
    } catch (e: IOException) {}
}

fun loadDataFromFile(path: String): Array<Student> {
    val studentList = mutableListOf<Student>()
    try {
        BufferedReader(FileReader(path)).use { reader ->
            reader.forEachLine { line ->
                val parts = line.split(",")
                if (parts.size == 4) {
                    val student = Student(parts[0], parts[1], parts[2], parts[3].toInt())
                    studentList.add(student)
                }
            }
        }
    } catch (e: IOException) {}
    return studentList.toTypedArray()
}

fun saveObjectToFile(students: Array<Student>, path: String) {
    try {
        ObjectOutputStream(FileOutputStream(path)).use { oos ->
            oos.writeObject(students)
        }
        println("Object saved to $path")
    } catch (e: IOException) {}
}

fun loadObjectFromFile(path: String): Array<Student> {
    var students = emptyArray<Student>()
    try {
        ObjectInputStream(FileInputStream(path)).use { ois ->
            students = ois.readObject() as Array<Student>
        }
    } catch (e: IOException) {}
    catch (e: ClassNotFoundException) {}
    return students
}

fun main() {
    var students = arrayOf(
        Student("100", "Lee", "사물인터넷", 21),
        Student("101", "Kim", "지능시스템", 21),
        Student("102", "Park", "사이버보안", 24),
        Student("111", "Kwon", "AI응용", 21)
    )

    saveDataToFile(students, "output.txt")
    students = loadDataFromFile("output.txt")
    students.forEach { println("$it") }

    saveObjectToFile(students, "output.dat")
    students = loadObjectFromFile("output.dat")
    students.forEach { println("$it") }
}
