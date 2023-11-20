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

* 이러한 라이브러리는 파일이나 콘솔과 같은 스트림(Stream)에서 읽거나 쓸 수 있는 API 제공
   * Stream: 데이터가 강물에 띄운 것처럼 흘러간다는 의미로 데이터가 머물러있지 않고 전달되는 개념

## Kotlin 입출력 API: java.io.Flie의 확장
* [API 문서 URL](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/java.io.-file/)

![image](https://github.com/qlkdkd/OOP/assets/71871927/bb4e4907-5234-42fa-9d94-bea337a82578)

---

# 파일에 쓰기

## 파일에 쓰기: FileWriter 사용하기
* Files클래스는 java.nio.file에 속해있으며 파일 조작을 위한 각종 static 메서드로 구성됨

```kotlin
package section2

import java.io.FileWriter
import java.io.IOException

fun main(){
    val path="textfile.txt"
    val outString="안녕하세요!\r\n FileWriter\t테스트입니다!\n"

    try{
        val writer=FileWriter(path,true)//파일을 생성하는 함수 FileWriter를 사용하여 path에 저장된 파일명대로 txt파일 생성
        writer.write(outString)//writer.write를 사용하여 textfile.txt에 outString에 저장된 내용 쓰기
        writer.close()
    }catch(e:IOException){}
}
```
![image](https://github.com/qlkdkd/OOP/assets/71871927/859f215a-f368-4a0f-90a2-8533f070c309)

## 파일에 쓰기(코드 간략화)
* 예외처리 생략 가능: kotlin에서는 java와는 달리 예외가 모두 비검사 예외로 취급되기 떄문에, 명시적 예외 선언 불필요
```kotlin
try{
        val writer=FileWriter(path,true)
        writer.write(outString)
        writer.close()
    }catch(e:IOException){}
```
->
```kotlin
val writer=FileWriter(path,true)
writer.write(outString)
writer.close()
```

* use 확장함수 사용: T리소스에 대해서 block 함수를 수행하고, 예외가 발생 여부와 상관없이 T 리소스를 닫는다.(단, T리소스는 닫을 수 있는 스트림이나 채널이어야 함.

```kotlin
fun <T: CLoseable?, R>T.use(block: (T)->R)
```

```kotlin
val writer=FileWriter(path, true)
writer.write(outString)
writer.close
```
->
```kotlin
FileWriter(path, true).use{
   writer -> writer.write(outString)}
```
->
```kotlin
FileWriter(path, true).use{it.write(outString)}
```

## 파일에 쓰기: BufferedWriter 사용하기
![image](https://github.com/qlkdkd/OOP/assets/71871927/637c7930-9af2-415d-9cf6-72086d4d5de4)
* 버퍼를 사용하여 쓸 내용을 미리 저장한 뒤에 한꺼번에 파일에 쓰기 때문에 잦은 입출력 오버헤드를 줄일 수 있음

```kotlin
fun main(){
   val path="textfile.txt"
   val outString="안녕하세요!\r\n FileWriter\t테스트입니다!\n"

   val file=File(path)
   val bw=BufferedWriter(
      OutputStreamWriter(FileOutputStream(file)))
   bw.writer(outString)
   bw.close()
}
```

## 파일에 쓰기: PrintWriter 사용하기
![image](https://github.com/qlkdkd/OOP/assets/71871927/f584f804-7e6f-48a7-ae80-f5b034c132a3)
* print(), println(), printf()등 콘솔에서 출력하듯이 바이트 단위로 파일에 쓸 수 있음

```kotlin
fun main(){
   val path="textfile.txt"
   val outString="안녕하세요!\r\n FileWriter\t테스트입니다!\n"

   val file=File(path)

   val pw=PrintWriter(BufferedWriter(
      OutputStreamWriter(FileOUtputStream(file)))
   pw.println(outString)
   pw.close()
}
```

## 파일에 쓰기: File의 writeText() 사용하기
![image](https://github.com/qlkdkd/OOP/assets/71871927/b23121f7-a5bc-4ab6-a0f3-3761212b0b67)
```kotlin
public fun File.writeText(text: String, charset:Charset=Charset.UTF_8):Unit
   =writeBytes(text.toByteArray(charset))
```

```kotlin
punlic fun FIle.writeBytes(array:ByteArray):Unit=FileOutputStream(this).use{it.write(array)}
```

---

# 파일에서 읽기
## 파일에서 읽기: Java Style
![image](https://github.com/qlkdkd/OOP/assets/71871927/b91b6871-61bd-4f8e-8e7f-000faf8799c8)
```kotlin
fun readJavaStyle(path: String){
    val inputString=StringBuilder()

    try{
        val file=File(path)
        val inStream:InputStream=file.inputStream()
        val isr=InputStreamReader(inStream)
        val br=BufferedReader(isr)

        val line=br.readLine()
        while(line!=null){
            inputString.append(line, '\n')
            line=br.readLine()
        }
        br.close()
    }catch(e: Exception){}
    println(inputString)
}
```

## 파일에서 읽기: File.bufferedReader(),Reader.readText() 확장함수 사용하기
![image](https://github.com/qlkdkd/OOP/assets/71871927/d2d05f48-eaf0-4d93-903d-7d45633cf85e)

## 파일에서 읽기: 축약된 버전(use함수 추가 적용)
![image](https://github.com/qlkdkd/OOP/assets/71871927/41f60b66-7300-4249-ae09-42c990ff2689)
```kotlin
fun useReadTextBufferedReader(path:String) {
    val br:BufferedReader
    try {
        br = File(path).bufferedReader()
    }catch (e:Exception){ return }

    val inputString = br.use { it.readText() }
    println(inputString)
}

```

## 파일에서 읽기: Reader.useLines 사용
![image](https://github.com/qlkdkd/OOP/assets/71871927/3e3c314f-533f-4e84-8ed4-6c5b88e371de)

```kotlin
fun BRuseLines(path:String) {
    val br:BufferedReader
    try {
        br = File(path).bufferedReader()
    } catch (e:Exception) { return }

    val lineList = mutableListOf<String>()
    br.useLines { lines -> lines.forEach { lineList.add(it) } }
    lineList.forEach { println(">  " + it) }
}

fun fileUseLines(path:String) {
    val lineList = mutableListOf<String>()
    try {
        File(path).useLines { lines -> lines.forEach { lineList.add(it) } }
    } catch (e:Exception) {}
    lineList.forEach { println(">  " + it) }
}
```

## 그 밖에 유용한 확장 함수
* 파일의 내용 출력하기: `File(path)`, `forEachLine{println(it)}`
* 바이트 단위로 읽기: `val bytes=File(path).readBytes()`, `println(Arrays.toString(bytes))`
* 줄 단위로 읽기: `val lines=File(path).readLines()`, `lines.forEach{println(it)}`
* 텍스트 단위로 읽기: `val text=File(path).readText()`, `println(text)`
