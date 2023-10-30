# 인터페이스와 다형성

# 1. 다형성

## 다형성(Polymorphism)이란?
* 같은 이름을 사용하지만 구현 내용이 다른거나 매개변수가 달라서 하나의 이름으로 다양한 기능을 수행할 수 있는 개념
    * Poly(다(多), 많다)+morph(형(形), 모양)

* 오버라이딩(oerriding): 하위 클래스에서 새로 만들어지는 메서드가 이름이나 매개변수, 반환값이 이전 메서드와 똑같지만 새로 작성되는 것. 하위의 새로운 메서드는 상위 클래스의 메서드의 내용을 완전히 새로 만들어 다른 기능을 하도록 정의함
    * 메서드 오버라이딩: 동일한 형식의 메소드가 하위 클래스에서 재정의됨
    * 프로퍼티 오버라이딩: 동일한 타입의 프로퍼티에 대한 접근자가 하위 클래스에서 재정의됨

* 오버로딩(overloading): 동일한 클래스 안에서 같은 이름의 메서드가 매개변수만 달리해서 여러 번 정의될 수 있는 개념으로, 반환값은 동일하거나 달라질 수 있다.
   * 예: print("Hello"), print(100), print(3.14)
 

## 메소드 오버라이딩
* 서브 클래스에서 슈퍼클래스의 메소드 구현을 재정의 및 확장
   * 오버라이딩하기 위해 부모클래스의 메소드에서는 open 키워드, 자식클래스의 메소드에서는 override 키워드를 각각 이용
   * 슈퍼클래스 메소드의 원형(메소드 이름, 인자 타입 및 개수, 리턴 타입)과 동일하게 작성하되, 내용은 다르게 구현

![image](https://github.com/qlkdkd/OOP/assets/71871927/8fcf8c14-11f7-4517-b4af-1c5e76381be1)

## 프로퍼티 오버라이딩
* 서브클래스에서 슈퍼클래스의 프로퍼티를 재정의
   * 오버라이딩하기 위해 부모 클래스의 프로퍼티에서는 open 키워드, 자식 클래스의 프로퍼티에서는 override키워드를 각각 이용
   * 슈퍼 클래스 프로퍼티의 이름과 타입을 동일하게 작성하되, 게터나 세터를 재정의함
   * 슈퍼 클래스에 프로퍼티를 val로 정의한 경우에는 하위클래스에서 var로 변경 가능하지만, 반대는 안됨
 
![image](https://github.com/qlkdkd/OOP/assets/71871927/12729aa2-1bc9-44a0-b319-0522e219ad92)


## 메서드 오버로딩
* 한 클래스 내에서 두 개 이상의 이름이 같은 메소드 작성
   * 메소드 이름이 동일하여야 함
   * 매개변수의 개수가 서로 다르거나, 타입이 서로 달라야 함
   * 리턴 타입은 오버로딩과 관련 없음
   * 생성자 중복정의도 일종의 메소드 오버로딩임
 
![image](https://github.com/qlkdkd/OOP/assets/71871927/cdad728e-eb8a-4d3a-af39-e58bcdce6ee4)


## 메서드 오버라이딩과 동적 바인딩
![image](https://github.com/qlkdkd/OOP/assets/71871927/75d4a35e-8323-46c1-b358-96d067becaf7)

## AnimalSimulator에서 다형성이 사용된 사례
```kotlin
open class Animal(
    protected val type: String,
    protected var name: String,
    protected val age: Int
) {

    fun eat() = println("${age}세의 ${type}인 ${name} (이/가) 식사 중입니다")
    fun sleep() = println("${age}세의 ${type}인 ${name} (이/가) 잠자는 중입니다")
    fun move() = println("${age}세의 ${type}인 ${name} (이/가) 이동 중입니다")

    open fun speak() = println("${age}세의 ${type}인 ${name} +(이/가) 말하는 중입니다")
}

class Dog(type: String, name: String, age: Int) : Animal(type, name, age) {
    override fun speak()
        = println("${age}세의 ${type}인 ${name} + (이/가) 짖고 있습니다")
}

class Cat(type: String, name: String, age: Int) : Animal(type, name, age) {
    override fun speak()
        = println("${age}세의 ${type}인 ${name} (이/가) 야옹하고 있습니다")
}

class Duck(type: String, name: String, age: Int) : Animal(type,name,age) {
    override fun speak()
            = println("${age}세의 ${type}인 ${name} (이/가) 꽥꽥하고 있습니다")
    fun swim() = println("${age}세의 ${type}인 ${name} (이/가) 수영하고 있습니다")
}


fun main() {
    val aDog = Dog("진도개", "화랑", 3)
    val bDog = Dog("삼살개", "레오", 2)
    val aCat = Cat("페르시안 고양이", "네로", 3)
    val bCat = Cat("샴 고양이", "나비", 5)
    val aDuck = Duck("집오리", "도널드",2)
    val bDuck = Duck("청둥오리", "하늘",2)

    for (i in 1..5) {
        val animalChoice = (Math.random() * 6 + 1).toInt()
        val animal = when (animalChoice) { // upcasting
            1 -> aDog
            2 -> bDog
            3 -> aCat
            4 -> bCat
            5 -> aDuck
            else -> bDuck
        }
        val animalAction = (Math.random() * 5 + 1).toInt()

        when (animalAction) {
            1 -> animal.speak()
            2 -> animal.eat()
            3 -> animal.sleep()
            4 -> animal.move()
            5 -> if (animal is Duck)
                animal.swim()
        }
    }
}
```

## 메서드 오버로딩과 메서드 오버라이딩의 비교
비교요소|메소드 오버로딩|메소드 오버라이딩
---|---|---
선언|같은 클래스나 상속 관계에서 동일한 이름의 메소드 중복 작성|서브클래스에서 슈퍼클래스에 있는 메소드와 동일한 이름의 메소드 작성
관계|동일한 클래스 내 혹은 상속 관계|상속관계
목적|이름이 같은 여러 개의 메소드를 중복 선언하여 사용의 편리성 향상|슈퍼클래스에 구현된 메소드를 무시하고 서브클래스에서 새로운 기능의 메소드를 재정의하고자 함
조건|메소드 이름은 반드시 통일함. 메소드의 인자의 개수나 인자의 타입이 달라야 성립|메소드의 이름, 인자의 타입, 인자의 개수, 인자의 리턴 타입 등이 모두 동일하여야 성립
바인딩|정적 바인딩, 컴파일 시에 중복된 메소드 중 호출되는 메소드 결정|동적 바인딩, 실행 시간에 오버라이딩된 메소드 찾아 호출
