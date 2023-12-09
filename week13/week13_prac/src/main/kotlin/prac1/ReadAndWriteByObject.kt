package prac1

import java.io.File
import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.Serializable
import java.io.ObjectInputStream

class Student(
    val id: String,
    val name: String,
    val dept: String,
    val age: Int
): Serializable{
    override fun toString(): String{
        return "id=$id, name=$name, dept=$dept, age=$age"
    }
}

fun main(){
    val student=Student("100", "Lee", "사물인터넷", 21)

    /*java style
    //val fout=FileOutputStream("output.dat")
    val fout=File("output.dat").outputStream()
    val oos=ObjectOutputStream(fout)
    oos.writeObject(student)
    oos.close()
`   */

    //kotlin style
    ObjectOutputStream(File("output.dat").outputStream()).use{
        it.writeObject(student)
    }

    ObjectInputStream(File("output.dat").inputStream()).use{
        it.readObject()
    }

    val resultObject=ObjectInputStream(File("output.dat").inputStream())
    println(resultObject)
}