package section3.mainconstructor.initBlock.propertyAsParam

class Dog(var type: String = "Dog", var name: String?, var age: Int = 0) {
    init {
        if (type!="삽살개" && type!="진도개" && type!="Dog") {
            println("${type} is an invalid type!!: Dog 로 초기화")
            type = "Dog"
        }
        this.name = name ?: "noName"
        if (age !in 0..30) {
            println("${age} is an invalid age!!: 0으로 초기화")
            age = 0
        }
    }

    fun bark() {
        println("$name(이/가)  짖고 있습니다.")
    }

    fun eat() {
        println("$name(이/가) 식사 중입니다.")
    }
}

fun main() {
    println("객체생성 요청: Dog(\"진도개\",\"화랑\",3)")
    val aDog = Dog("진도개", "화랑", 3)
    println("종류= ${aDog.type}")
    println("이름= ${aDog.name}")
    println("나이= ${aDog.age}")

    println("\n객체생성 요청: Dog(\"진도개2\",null,100)")
    val bDog = Dog("진도개2", null, 100)
    println("종류= ${bDog.type}")
    println("이름= ${bDog.name}")
    println("나이= ${bDog.age}")

    println("\n객체생성: Dog(name=\"해피\")")
    val cDog = Dog(name = "해피")
    println("종류= ${cDog.type}")
    println("이름= ${cDog.name}")
    println("나이= ${cDog.age}")
}