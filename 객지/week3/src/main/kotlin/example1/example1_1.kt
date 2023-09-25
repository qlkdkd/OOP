package example1

fun printStudentInfo(nameOfCollege: String,
                     nameOfMajor: String,
                     id: String,
                     name: String){
    println("$nameOfCollege")
    println("$nameOfMajor")
    println("$id")
    println("$name")
}

fun main()
{
    printStudentInfo(
        "IT공과대학",
        "전자트랙",
        "21",
        "신대한"
    )
}

