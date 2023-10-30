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

---

# 2. 추상 클래스와 인터페이스

## 추상 클래스(

* 추상 메소드(abstract method)
   * abstract으로 선언된 메소드로서, 메소드의 구현이 없고 함수 원형(prototype)만 정의
* 추상 프로퍼티(abstract property)
   * abstract으로 선언된 프로퍼티로서, 이름과 타입만 선언

* 추상 클래스(abstract class)
   * 추상 메소드나 추상 프로퍼티를 가진 클래스
      *주의: 추상 메소드나 추상 프로퍼티를 가진 클래스는 반드시 추상 클래스로 선언되어야 함
   * 추상 메소드나 추상 프로퍼티 없이 abstract으로 선언한 클래스
   * open키워드를 사용하지 않고도 파생 클래스 작성 가능
   * 추상 클래스는 인스턴스를 생성할 수 없음
        * val animal=Animal() (X)

![image](https://github.com/qlkdkd/OOP/assets/71871927/5a6716b9-5afd-4fbd-b450-97f57f773407)

## 추상 클래스의 상속
* 추상 클래스 상속
   * 추상 클래스를 상속받고 추상 메소드와 추상 프로퍼티를 구현하지 않으면 해당 클래스는 추상 클래스가 됨
* 추상 프로퍼티의 구현
   * 추상 클래스의 추상 프로퍼티 구현은 서브클래스에서 추상 프로퍼티를 초기화하거나 getter/setter를 구현
* 추상 메소드의 구현
   * 추상 메소드를 오버라이딩하여 정의
   * 주의: 추상 메소드나 추상 프로퍼티가 없는 클래스는 abstract로 선언되지 않고서는 더이상 추상 클래스가 아니다.
 
![image](https://github.com/qlkdkd/OOP/assets/71871927/710837e8-08b6-486b-bacf-680858c49326)

![image](https://github.com/qlkdkd/OOP/assets/71871927/ea3c1b53-3997-4d78-a2a2-04f54120622b)

## AnimalSimulator의 추가 확장(추상클래스 방식)
```kotlin
package week8.section2.abstractClass


abstract class Animal(
    protected var name: String,
    protected val age: Int
) {
    abstract protected val type: String

    fun eat() = println("${age}세의 ${type}인 ${name} (이/가) 식사 중입니다")
    fun sleep() = println("${age}세의 ${type}인 ${name} (이/가) 잠자는 중입니다")
    open fun move() = println("${age}세의 ${type}인 ${name} (이/가) 이동 중입니다")

    abstract fun speak()
}

class Dog(override val type: String, name: String, age: Int) : Animal(name, age) {
    override fun speak() = println("${age}세의 ${type}인 ${name} (이/가) 짖고 있습니다")
}

class Cat(override val type: String, name: String, age: Int) : Animal(name, age) {
    override fun speak() = println("${age}세의 ${type}인 ${name} (이/가) 야옹하고 있습니다")
}

class Duck(override val type: String, name: String, age: Int) : Animal(name, age) {
    override fun speak() = println("${age}세의 ${type}인 ${name} (이/가) 꽥꽥하고 있습니다")
    fun swim() = println("${age}세의 ${type}인 ${name}  (이/가) 수영하고 있습니다")
}

class Fish(override val type: String, name: String, age: Int) : Animal(name, age) {


    override fun speak() {} // Fish는 말을 하지 못하므로, 아무것도 안하도록 재정의
    override fun move() {} // Fish는 육상에서 이동하지 못하므로, 아무것도 안하도록 재정의

    // swim() 구현이 Duck의 swim() 구현과 중복됨
    fun swim() = println("${age}세의 ${type}인 ${name} (이/가) 수영하고 있습니다")
}

fun main() {
    val aDog = Dog("진도개", "화랑", 3)
    val bDog = Dog("삼살개", "레오", 2)
    val aCat = Cat("페르시안 고양이", "네로", 3)
    val bCat = Cat("샴 고양이", "나비", 5)
    val aDuck = Duck("집오리", "도널드", 2)
    val bDuck = Duck("청둥오리", "하늘", 2)
    val aFish = Fish("금붕어", "다솔", 4)

    for (i in 1..10) {
        val animalChoice = (Math.random() * 7 + 1).toInt()
        val animal = when (animalChoice) { // upcasting
            1 -> aDog
            2 -> bDog
            3 -> aCat
            4 -> bCat
            5 -> aDuck
            6 -> bDuck
            else -> aFish
        }
        val animalAction = (Math.random() * 5 + 1).toInt()

        when (animalAction) {
            1 -> animal.speak()
            2 -> animal.eat()
            3 -> animal.sleep()
            4 -> animal.move()
            5 -> if (animal is Fish)
                    animal.swim()
                 else if (animal is Duck)
                     animal.swim()
        }
    }
}
```

## Kotlin의 인터페이스
* interface 키워드를 사용해 정의
   * 추상 프로퍼티, 추상 메소드 포함(abstract 키워드 생략 가능)
   * 구현부가 있는일반 메소드는 포함 가능
   * 상태를 저장할 수 있는 일반 프로퍼티는 포함할 수 없음
![image](https://github.com/qlkdkd/OOP/assets/71871927/e258f7ee-eeba-49aa-ae67-23b933e6ef6f)

* 하나의 인터페이스는 다른 인터페이스를 구현할 수 있음(일종의 상속)

```kotlin
package week8.section2.interface2

interface Animal {
    val type: String
    val name: String
    val age: Int

    fun eat() = println("${age}세의 ${type}인 ${name} (이/가) 식사 중입니다")
    fun sleep() = println("${age}세의 ${type}인 ${name} (이/가) 잠자는 중입니다")

}

interface Movable : Animal {
    fun move() = println("${age}세의 ${type}인 ${name} (이/가) 이동 중입니다")
}

interface Swimmable : Animal {
    fun swim() = println("${age}세의 ${type}인 ${name} (이/가) 수영 중입니다.")
}

interface Speakable {
    fun speak()
}

class Dog(
    override val type: String,
    override var name: String,
    override val age: Int
) : Movable, Speakable {
    override fun speak() = println("${age}세의 ${type}인 ${name} (이/가) 짖고 있습니다")
}

class Cat(
    override val type: String,
    override var name: String,
    override val age: Int
) : Movable, Speakable {
    override fun speak() = println("${age}세의 ${type}인 ${name} (이/가) 야옹하고 있습니다")
}

class Duck(
    override val type: String,
    override var name: String,
    override val age: Int
) : Movable, Speakable, Swimmable {
    override fun speak() = println("${age}세의 ${type}인 ${name} (이/가) 꽥꽥하고 있습니다")
}

class Fish(
    override val type: String,
    override var name: String,
    override val age: Int
) : Swimmable


fun main() {
    val aDog = Dog("진도개", "화랑", 3)
    val bDog = Dog("삼살개", "레오", 2)
    val aCat = Cat("페르시안 고양이", "네로", 3)
    val bCat = Cat("샴 고양이", "나비", 5)
    val aDuck = Duck("집오리", "도널드", 2)
    val bDuck = Duck("청둥오리", "하늘", 2)
    val aFish = Fish("금붕어", "다솔", 4)
    for (i in 1..10) {
        val animalChoice = (Math.random() * 7 + 1).toInt()
        val animal = when (animalChoice) { // upcasting
            1 -> aDog
            2 -> bDog
            3 -> aCat
            4 -> bCat
            5 -> aDuck
            6 -> bDuck
            else -> aFish
        }
        val animalAction = (Math.random() * 5 + 1).toInt()

        when (animalAction) {
            1 -> if (animal is Speakable) animal.speak()
            2 -> animal.eat()
            3 -> animal.sleep()
            4 -> if (animal is Movable) animal.move()
            5 -> if (animal is Swimmable) animal.swim()
        }
    }
}
```

## 인터페이스 구현
* 인터페이스를 구현하는 클래스는 인터페이스에 정의된 추상 프로퍼티, 추상 메소드, 일반 메소드를 override 키워드를 사용하여 해당 프로퍼티와 메소드를 재정의
* 클래스는 여러 인터페이스를 구현할 수 있음

![image](https://github.com/qlkdkd/OOP/assets/71871927/3769e6b6-3929-45d8-aad3-4694666dd9d9)

## AnimalSimulator의 추가 확장(인터페이스 방식)
![image](https://github.com/qlkdkd/OOP/assets/71871927/d3bf14f2-8a1c-482a-88e1-b984ca646aba)

## 인터페이스 구현(fish)
* Fish 클래스는 Animal 인터페이스를 상속한 Swimmable 인터페이스를 상속하도록 구현
   * Animal의 공통 구현(sleep(). eat()) 상속, Swimable이 구현(swim())의 상속
 
![image](https://github.com/qlkdkd/OOP/assets/71871927/d33306f5-1f77-492f-a542-2581c848a47c)

## 추상 클래스와 인터페이스 비교
비교요소|추상클래스|인터페이스
---|---|---
일반 메서드|가능|가능
일반 프로퍼티|가능|불가능
추상 메서드|가능|가능
추상 프로퍼티|가능|가능
다중상속|단일상속만 가능|지원
생성자|생성자를 가질 수 있음|가질 수 없음
사용 목적|관련 클래스들 간의 공통 동작에 대한 코드 재사용을 촉진하고, 서브클래스에서 필요에 따라서 확장 및 수정할 부분을 추상 메서드와 추상 프로퍼티로 정의할 때 사용됨|관련 클래스들 간에 동작의 다양성이 존재할 때, 특정 동작을 수행할 수 있는 계약을 인터페이스로 정의하고, 클래스별로 필요한 인터페이스를 구현할 때 사용됨됨
