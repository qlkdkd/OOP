# 클래스 상속

## 클래스 상속과 생성자

### Animal Simulator
![image](https://github.com/qlkdkd/OOP/assets/71871927/2c77b706-4a89-4c75-bd8e-f4f55d9b386f)
### 상속 계층
![image](https://github.com/qlkdkd/OOP/assets/71871927/89bc8362-bf8f-4790-80ec-7d891005d17b)
* 상위 클래스(슈퍼 클래스): Animal
* 하위 클래스(서브 클래스 = 자식 클래스 = 파생 클래스): Dog, Cat, Duck
### 클래스 상속(Kotlin)
* Any
    * 모든 Kotlin 클래스의 공통 슈퍼클래스
    * equals(), hashCode(), toString() 메소드 포함
* Open
    * 상속 가능한 클래스로 선언하는 키워드
    * Kotlin 클래스의 기본값은 **final** - 상속할 수 없음
* :
    * 콜론(:) 뒤에 **슈퍼클래스명**
         * **서브클래스에 주생성자가 없고 부생성자만 있으면, 각 부생성자에서 super키워드 사용하여 초기화**
    * 콜론(:) 뒤에 **슈퍼클래스 생성자**
         * **서브클래스에 주생성자가 있으면, 슈퍼클래스 생성자를 사용하여 초기화**
```kotlin
package week7.section1.derivedWithNoMainCons

open class Point (val x:Int, val y:Int) {//수퍼 클래스를 생성할 때 앞에 open을 붙여준다.
    fun showPoint() = println("($x,$y)")
}

class ColorPoint : Point {//: Point를 표기함으로써 ColorPoint가 Point를 상속 받는다는 것을 의미
    val color:String
    constructor(x:Int, y:Int, color:String) : super(x,y) {
        this.color = color
    }
    fun showColorPoint()  {
        showPoint()
        println("Color:$color")
    }
}

fun main() {
    val cp = ColorPoint(2,3,"RED")
    cp.showColorPoint()
}
```

## 상속 계층 내의 생성자 호출 및 실행 순서
![image](https://github.com/qlkdkd/OOP/assets/71871927/37351596-8461-44a0-a3b7-fed0520a6c1c)

### 서브 클래스 객체가 생성될 떄
* 슈퍼 클래스 생성자와 서브 클래스 생성자 모두 실행
* 호출 순서
   * 서브클래스의 생성자 먼저 호출
   * 서브 클래스의 생성자는 실행 전 슈퍼 클래스 생성자 호출
* 실행 순서
   * 슈퍼 클래스의 생성자가 먼저 실행된 후 서브 클래스의 생성자 실행

## 상속 예제: Point와 ColorPoint(생성자 호출 및 수행 순서)
![image](https://github.com/qlkdkd/OOP/assets/71871927/2c48d4b2-e149-409c-bd0d-ea165ee53875)

## 슈퍼 클래스 생성자의 묵시적 호출
![image](https://github.com/qlkdkd/OOP/assets/71871927/f73ebde0-d698-4e96-8731-bdecfd9bacf3)
![image](https://github.com/qlkdkd/OOP/assets/71871927/bf3a134e-2a5f-400b-b10d-8eace08fc7d4)
![image](https://github.com/qlkdkd/OOP/assets/71871927/6852f010-2635-4887-b186-68cabbaaef8b)
![image](https://github.com/qlkdkd/OOP/assets/71871927/baae4c11-e844-41c0-9d27-1c365ffae724)


## DogSimulator 예제
### 슈퍼클래스(protected 멤버)
```kotin
package week7.section1.derivedWithMainCons

//슈퍼클래스(protected 멤버)
open class Animal (var type: String, val name: String, val age: Int){
    fun eat() = println("${age}세의 ${type}인 ${name} (이/가) 식사 중입니다")
    fun sleep() = println("${age}세의 ${type}인 ${name} (이/가) 잠자는 중입니다")
    fun move() = println("${age}세의 ${type}인 ${name} (이/가) 이동 중입니다")
}

//주생성자를 가진 서브클래스
class Dog(type: String, name: String, age: Int) : Animal(type,name,age) {

    constructor(type:String, age:Int) : this (type,"noName",age)
    fun bark() = println("${age}세의 ${type}인 ${name} (이/가) 짖고 있습니다")
}

//주생성자가 없고 부생성자를 가진 서브클래스
/*
class Dog : Animal {
    constructor(type:String, age:Int) : this (type,"noName",age)
    constructor(type: String, name: String, age: Int) : super(type,name,age)
    fun bark() = println("${age}세의 ${type}인 ${name} (이/가) 짖고 있습니다")
}
*/

fun main() {
    val aDog = Dog("진도개","화랑",3)
    val bDog = Dog("삼살개","레오",2)

    for (i in 1..10) {
        val dogChoice = (Math.random() * 2 + 1).toInt()
        val dog = if (dogChoice == 1) aDog else bDog
        val dogAction = (Math.random() * 4 + 1).toInt()
        when (dogAction) {
            1 -> dog.bark()
            2 -> dog.eat()
            3 -> dog.sleep()
            4 -> dog.move()
        }
    }
}
```

결
```
3세의 진도개인 화랑 (이/가) 이동 중입니다
3세의 진도개인 화랑 (이/가) 잠자는 중입니다
2세의 삼살개인 레오 (이/가) 식사 중입니다
2세의 삼살개인 레오 (이/가) 식사 중입니다
2세의 삼살개인 레오 (이/가) 식사 중입니다
3세의 진도개인 화랑 (이/가) 짖고 있습니다
2세의 삼살개인 레오 (이/가) 짖고 있습니다
3세의 진도개인 화랑 (이/가) 식사 중입니다
2세의 삼살개인 레오 (이/가) 짖고 있습니다
3세의 진도개인 화랑 (이/가) 이동 중입니다
```

## 참고: this(), super(), this, super
* this(): 같은 클래스의 다른 생성자 호출
* super(): 상위 클래스의 생성자 호출
* this: 객체 자신의 대한 레퍼런스(this.멤버 형태로 멤버를 접근할 때 사용)
* super: 슈퍼 클래스의 메소드나 필드를 접근할 때 사용(super.멤버 형태로 접근)

---

# 업캐스팅과 다운캐스팅

## DogSimulator를 AminalSimulator로 확장
```kotlin
package week7.section2

open class Animal (protected var type: String,
                   protected var name: String,
                   protected val age: Int){

    fun eat() = println("${age}세의 ${type}인 ${name} (이/가) 식사 중입니다")
    fun sleep() = println("${age}세의 ${type}인 ${name} (이/가) 잠자는 중입니다")
    fun move() = println("${age}세의 ${type}인 ${name} (이/가) 이동 중입니다")
}

class Dog(type: String, name: String, age: Int) : Animal(type,name,age) {
    fun bark() = println("${age}세의 ${type}인 ${name} (이/가) 짖고 있습니다")
}

class Cat(type: String, name: String, age: Int) : Animal(type,name,age) {
    fun meow() = println("${age}세의 ${type}인 ${name} (이/가) 야옹하고 있습니다")
}

class Duck(type: String, name: String, age: Int) : Animal(type,name,age) {
    fun quack() = println("${age}세의 ${type}인 ${name} (이/가) 꽥꽥하고 있습니다")
    fun swim() = println("${age}세의 ${type}인 ${name} (이/가) 수영하고 있습니다")
}

fun main() {
    val aDog = Dog("진도개","화랑",3)
    val bDog = Dog("삼살개","레오",2)

    for (i in 1..5) {
        val dogChoice = (Math.random() * 2 + 1).toInt()
        val dog:Dog = if (dogChoice == 1) aDog else bDog
        val dogAction = (Math.random() * 4 + 1).toInt()
        when (dogAction) {
            1 -> dog.bark()
            2 -> dog.eat()
            3 -> dog.sleep()
            4 -> dog.move()
        }
    }

    val aCat = Cat("페르시안 고양이", "네로", 3)
    val bCat = Cat("샴 고양이", "나비", 5)

    for (i in 1..5) {
        val catChoice = (Math.random() * 2 + 1).toInt()
        val cat:Cat = if (catChoice == 1) aCat else bCat
        val catAction = (Math.random() * 4 + 1).toInt()
        when (catAction) {
            1 -> cat.meow()
            2 -> cat.eat()
            3 -> cat.sleep()
            4 -> cat.move()
        }
    }

    val aDuck = Duck("집오리", "도널드",2)
    val bDuck = Duck("청둥오리", "하늘",2)

    for (i in 1..5) {
        val duckChoice = (Math.random() * 2 + 1).toInt()
        val duck:Duck = if (duckChoice == 1) aDuck else bDuck
        val duckAction = (Math.random() * 5 + 1).toInt()
        when (duckAction) {
            1 -> duck.quack()
            2 -> duck.eat()
            3 -> duck.sleep()
            4 -> duck.move()
            5 -> duck.swim()
        }
    }
}
```

![image](https://github.com/qlkdkd/OOP/assets/71871927/f2dc33cb-47f0-48be-833b-87cc3af33d1e)

## 업캐스팅
* 하위 클래스의 객체 레퍼런스를 상위 클래스의 객체 변수에 대입
```kotlin
val aAnimal=Dog("진돗개", "화랑", 3)
val aCat=Cat("페르시안 고양이", "네로", 3)
aAnimal=Cat
```

* 상위 클래스의 객체변수(aAnimal)로는 오직 상위클래스의 멤버만 접근 가능, 하위 클래스의 멤버는 접근 불가
```kotlin
var aAnimal: Animai=Dog("진돗개", "화랑", 3)
aAnimal.eat()//O
aAnimal.bark()//Error
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/f9443c25-b35a-498f-910a-9a3d9d3d0a65)

## 다운캐스팅
* 상위클래스의 인스턴스를 하위 클래스 타입으로 변환: 업캐스팅된 것을 다시 원래 형식으로 되돌리는 것
* is 연산자: 변수의 타입을 검사한 후, 변수를 해당 타입으로 자동 변환
```kotlin
var aAnimal: Animal=Dog("진돗개", "화랑", 3)
if(aAnimal is Dog) //잠시 후 다운캐스팅
   aAnimal.bark()//Ok
```
* as 연산자: 형변환에 사용되거나 import에 대한 별칭을 지칭
```kotlin
val aAnimal: Animal=Dog("진돗개", "화랑", 3)
aAnimal.eat()
aAnimal as Dog//다운캐스팅
aAnimal.bark()
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/774a71f5-fa6b-44fb-ac42-9f5829d447f0)

## AnimalSimulator에서 업캐스팅이 사용된 사례
![image](https://github.com/qlkdkd/OOP/assets/71871927/3e2a31e4-6412-4538-a595-5771d557ae40)
## AnimalSimulator에서 다운캐스팅이 사용된 사례
![image](https://github.com/qlkdkd/OOP/assets/71871927/7e983574-4cf8-419a-bc91-91d3e2123e38)

## AnimalSimulator
```kotlin
package week7.section2.updowncasting

open class Animal(
    protected var type: String,
    protected var name: String,
    protected val age: Int
) {

    fun eat() = println("${age}세의 ${type}인 ${name} (이/가) 식사 중입니다")
    fun sleep() = println("${age}세의 ${type}인 ${name} (이/가) 잠자는 중입니다")
    fun move() = println("${age}세의 ${type}인 ${name} (이/가) 이동 중입니다")
}

class Dog(type: String, name: String, age: Int) : Animal(type, name, age) {
    fun bark() = println("${age}세의 ${type}인 ${name} (이/가) 짖고 있습니다")
}

class Cat(type: String, name: String, age: Int) : Animal(type, name, age) {
    fun meow() = println("${age}세의 ${type}인 ${name}  (이/가) 야옹하고 있습니다")
}

class Duck(type: String, name: String, age: Int) : Animal(type,name,age) {
    fun quack() = println("${age}세의 ${type}인 ${name} (이/가) 꽥꽥하고 있습니다")
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
            1 -> if (animal is Dog)     // downcasting
                    animal.bark()
                else if (animal is Cat)
                    animal.meow()
                else if (animal is Duck)
                    animal.quack()
            2 -> animal.eat()
            3 -> animal.sleep()
            4 -> animal.move()
            5 -> if (animal is Duck)
                    animal.swim()
        }
    }
}
```
