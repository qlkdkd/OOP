package section2

class Dog { // ① 클래스의 정의
    // ② 프로퍼티들(속성)
    var type: String = "Unknown"
    var name: String? = null
    var age: Int = 0

    // ③ 메서드들(함수)
    fun bark() {
        println("$name(이/가)  짖고 있습니다.")
    }

    fun eat() {
        println("$name(이/가) 식사 중입니다.")
    }
}

fun main() {
    val aDog = Dog()  // ④ 클래스의 생성자를 통한 객체의 생성

    aDog.type = "진도개"  // ⑤ 객체의 프로퍼티에 값 할당
    aDog.name = "화랑"
    aDog.age = 3

    // ⑥ 객체의 멤버 프로퍼티 읽기
    println("종류= ${aDog.type}")
    println("이름= ${aDog.name}")
    println("나이= ${aDog.age}")
    aDog.bark() // ⑦ 객체의 멤버 메서드의 사용
    aDog.eat()
}