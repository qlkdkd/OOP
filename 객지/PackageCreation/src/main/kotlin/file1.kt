fun main()
{
    val a = 1
    val b = 3
    val s1 = "a is $a"        // $a는 a의 값을 문자열로 변환
    val s2 = "b is $b"        // $b는 b의 값을 문자열로 변환
    val s3 = "a+b is ${a+b}"  // ${a+b} 는 a+b의 수식 값을 문자열로 변환

// \"는 큰따옴포(")을 문자열의 종료 문자로 인지하지 않게하여 문자열 안에 포함시킴
    println("s1 = \"$s1\", s2 = \"$s2\", s3 = \"$s3\"")
}