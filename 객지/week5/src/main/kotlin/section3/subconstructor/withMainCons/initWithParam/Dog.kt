package section3.subconstructor.withMainCons.initWithParam

class Dog (type:String, name:String?, age:Int) {
    var type: String = type
    var name: String? = name
    var age: Int = age


    constructor(type:String, age:Int): this(type, "noName", age)
    constructor(type:String): this(type, "noName", 0)
    constructor(): this("Dog",  "noName",0)

    fun bark() {
        println("$name(이/가)  짖고 있습니다.")
    }

    fun eat() {
        println("$name(이/가) 식사 중입니다.")
    }
}

fun main() {
    println("객체생성 요청: Dog(\"진도개\",\"화랑\",3)")
    val aDog = Dog("진도개","화랑",3)
    println("종류= ${aDog.type}")
    println("이름= ${aDog.name}")
    println("나이= ${aDog.age}")

    println("\n객체생성 요청: Dog(\"진도개2\",null,100,)")
    val bDog = Dog("진도개2",null,100)
    println("종류= ${bDog.type}")
    println("이름= ${bDog.name}")
    println("나이= ${bDog.age}")
}