# 클래스 상속

## 클래스 상속과 생성자

### Animal Simulator
![image](https://github.com/qlkdkd/OOP/assets/71871927/2c77b706-4a89-4c75-bd8e-f4f55d9b386f)
### 상속 계층
![image](https://github.com/qlkdkd/OOP/assets/71871927/89bc8362-bf8f-4790-80ec-7d891005d17b)
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
open class Base(var x: Int)

class Derived: Base{
    constructor(p: Int): super(p)
}

class Derived(p: Int): Base(p)
```
