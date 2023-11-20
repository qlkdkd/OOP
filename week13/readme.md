# 입출력 스트림 개요

## 입출력 스트림
* 입력 장치: 키보드(System.in), 파일, 네트워크 디바이스 등
* 출력 장치: 화면(System.out), 파일, 네트워크 디바이스, 프린터,
* 입력 스트림: 입력 장치로부터 브로그램으로 데이터를 전달하는 객체
* 출력 스트림: 프로그램에서 출력 장치로 데이터를 보내는 객체

* 응용 프로그램은 직접 입력 장치에서 읽지 않고 입력 스트림을 통해 읽으며, 스크린 등 출력 장치에 직접 출력하지 않고 출력 스트림에 출력하면 된다.
![image](https://github.com/qlkdkd/OOP/assets/71871927/5a1a130e-8f44-402d-b293-de5f77f9e4f7)

## 입출력 스트림의 종류

### 문자 스트림
* **문자만 입출력하는 스트림**
* 바이너리 데이터는 스트림에서 처리하지 못함
    * 문자가 아닌 바이너리 데이터를 문자 스트림으로 출력하면 깨진 기호가 출력
    * 바이너리 파일을 문자 스트림으로 읽으면 읽을 수 없는 바이트가 생겨서 오류 발생
 
### 바이트 스트림
* 입출력 데이터를 **단순 바이트의 흐름으로 처리**
* 문자 데이터든 바이너리 데이터든 상관없이 처리 가능
* 예)바이너리 파일을 읽는 입력 스트림

## JDK의 바이트 스트림 클래스 계층 구조
![image](https://github.com/qlkdkd/OOP/assets/71871927/710e4967-55e7-4c9a-a601-0c1a6fcd41b8)

## JDK의 문자 스트림 클래스 계층 구조
![image](https://github.com/qlkdkd/OOP/assets/71871927/814405ab-c351-4361-be43-2daf09c5463f)

## 스트림 연결
* 여러 개의 스트림을 연결하여 사용할 수 있음
    * 예) 키보드에서 문자를 입력받기 위해 System.in과 InputStreamReader를 연결한 코드

```kotlin
val rd=InputStreamReader(System.'in')

while(true){
    val c=rd.read()//입력 스트림으로부터 키 입력.c는 입력된 키 문자 값
    print(c.toChar())//입력된 키문자 c를 출력
} 
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/ca479aec-b6f4-4837-a2be-a70cf86cc985)

## Kotlin의 표준 입출력
* 표준 출력: print(), println()
    * 내부적으로는 표준 출력 라이브러리인 자바의 System.out.println()을 호출
* 표준 입력: readln()
    * 내부적으로는 표준 입력인 System.in을 사용
 
```kotlin
fun main(){
    //기본 코틀린의 readln()
    print("Enter: ")
    val input=readln()
    println("You entered: $input")

    //자바의 Scanner를 통한 입력
    val reder=Scanner(System.'in')
    val integer:Int=reader.nextInt()
    println("You entered: $integer")
}
```

## Kotlin 입출력 API
* Kotlin.io 패키지는 다음과 같은 자바 라이브러리를 확장

처리 목적|관련 자바 라이브러리
---|---
**파일에 대한 처리**|**java.io.File**
바이트 단위의 입력 처리|java.io.InputStream
바이트 단위의 출력 처리|java.io.OutputStream
문자 기반 읽기 처리|java.io.Reader
문자 기반 쓰기 처리|java.io.Writer
버퍼를 가지 문자 기반 읽기 처리|java.io.BufferedReader
버퍼를 가진 바이트 기반 읽기 처리|java.io.BufferedInputSteram

## Kotlin 입출력 API: java.io.Flie의 확장
* [API 문서 URL](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/java.io.-file/)

![image](https://github.com/qlkdkd/OOP/assets/71871927/bb4e4907-5234-42fa-9d94-bea337a82578)
