<!DOCTYPE html>
<html lang="en-US">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Begin Jekyll SEO tag v2.8.0 -->
<title>입출력 스트림과 파일 (실습) | KJ-exercise</title>
<meta name="generator" content="Jekyll v3.9.3" />
<meta property="og:title" content="입출력 스트림과 파일 (실습)" />
<meta property="og:locale" content="en_US" />
<link rel="canonical" href="https://kwanulee.github.io/KJ-exercise/iostream.html" />
<meta property="og:url" content="https://kwanulee.github.io/KJ-exercise/iostream.html" />
<meta property="og:site_name" content="KJ-exercise" />
<meta property="og:type" content="website" />
<meta name="twitter:card" content="summary" />
<meta property="twitter:title" content="입출력 스트림과 파일 (실습)" />
<script type="application/ld+json">
{"@context":"https://schema.org","@type":"WebPage","headline":"입출력 스트림과 파일 (실습)","url":"https://kwanulee.github.io/KJ-exercise/iostream.html"}</script>
<!-- End Jekyll SEO tag -->

    <link rel="stylesheet" href="/KJ-exercise/assets/css/style.css?v=0144e5da06972a483066ceb7f066452d30eb890a">
    <!-- start custom head snippets, customize with your own _includes/head-custom.html file -->

<!-- Setup Google Analytics -->



<!-- You can set your favicon here -->
<!-- link rel="shortcut icon" type="image/x-icon" href="/KJ-exercise/favicon.ico" -->

<!-- end custom head snippets -->

  </head>
  <body>
    <div class="container-lg px-3 my-5 markdown-body">
      
      <h1><a href="https://kwanulee.github.io/KJ-exercise/">KJ-exercise</a></h1>
      

      <h1 id="입출력-스트림과-파일-실습">입출력 스트림과 파일 (실습)</h1>

<h2 id="0-시작하기-전에">0. 시작하기 전에</h2>

<p>이 Codelab에서는 객체를 파일에 저장하는 방법을 실습해봅니다.</p>

<h3 id="실습-준비">실습 준비</h3>

<ul>
  <li>최신 버전의 JDK와 IntelliJ IDEA IDE가 설치된 컴퓨터</li>
  <li>파일과 입출력 스트림 주제의 온라인 강의영상 시청 완료</li>
</ul>

<p><a name="1"></a></p>
<h2 id="1-객체를-파일에-저장하고-읽기">1. 객체를 파일에 저장하고 읽기</h2>

<ul>
  <li>다음의 정보를 프로퍼티로 가지는 Student 클래스를 data 클래스 정의하시오
    <ul>
      <li>학번(String), 이름(String), 학과/트랙(String), 나이(int)</li>
      <li>데이터 클래스는 toString(), hashCode(), equals(), copy()메소드를 자동으로 만들어주는 클래스입니다.</li>
    </ul>

    <div class="language-plaintext highlighter-rouge"><div class="highlight"><pre class="highlight"><code>  data class Student (
       val id: String,
       val name: String,
       val dept: String,
       val age: Int
  )
</code></pre></div>    </div>
  </li>
  <li>객체를 파일에 저장하고 읽는 방법 두 가지를 살펴본다.
    <ol>
      <li><strong>ObjectOutputStream</strong>과 <strong>ObjectInputStream</strong>을 사용</li>
      <li><strong>구글의 Gson 라이브러리</strong> 사용</li>
    </ol>
  </li>
</ul>

<h3 id="1-objectoutputstream과-objectinputstream을-사용">1. <strong>ObjectOutputStream</strong>과 <strong>ObjectInputStream</strong>을 사용</h3>
<ol>
  <li>저장하려는 객체의 클래스 정의에서 java.io.Serializable 인터페이스 구현</li>
  <li>객체를 저장하기 위해서, <strong>ObjectOutputStream</strong>의 <strong>writeObject()</strong> 메소드 사용</li>
  <li>객체를 읽기 위해서, <strong>ObjectInputStream</strong>의 <strong>readObject()</strong> 메소드 사용</li>
</ol>

<ul>
  <li>
    <p>전체코드</p>

    <div class="language-plaintext highlighter-rouge"><div class="highlight"><pre class="highlight"><code>  import java.io.File
  import java.io.ObjectInputStream
  import java.io.ObjectOutputStream
  import java.io.Serializable
	
  data class Student (
      val id: String,
      val name: String,
      val dept: String,
      val age: Int
  ) : Serializable    // 직렬화가능 선언
	
  fun main() {
      val student = Student("100", "Lee", "사물인터넷", 21)
	
      //직렬화
      ObjectOutputStream(File("Output.txt").outputStream())
                      .use { it.writeObject(student)}
	
      //역직렬화
      val result = ObjectInputStream(File("Output.txt").inputStream())
                      .use { it.readObject()}
	
      println(result)
  }
</code></pre></div>    </div>
  </li>
</ul>

<h3 id="2-구글의-gson-라이브러리-사용">2. <strong>구글의 Gson 라이브러리</strong> 사용</h3>
<ol>
  <li><strong>프로젝트 설정</strong>
    <ol>
      <li><strong>IntelliJ IDEA IDE</strong>의 <strong>File - Project Structure</strong> 메뉴 선택</li>
      <li><strong>Proejct Settings</strong>의 <strong>Libraries</strong> 선택</li>
      <li><strong>+</strong> (New Project Library) 클릭후, <em>*From MAVEN…</em> 선택</li>
      <li>검색창에 <em>gson</em> 입력후 검색 버튼 클릭</li>
      <li>검색 결과 중에 <em>com.google.code.gson:gson:2.10.1</em> 선택</li>
      <li><strong>OK</strong> 클릭
        <ul>
          <li>객체를 Json 문자열로 변환하기 위해서, <strong>Gson</strong>의 <strong>toJson()</strong> 사용</li>
          <li>Json 문자열을 텍스트 파일에 저장하기 위해서 <strong>File</strong>의 <strong>writeText()</strong> 사용</li>
          <li>텍스트 파일에서 저장된 Json 문자열을 읽기 위해서 <strong>File</strong>의 <strong>readText()</strong> 사용</li>
          <li>Json 문자열로부터 객체를 얻기 위해서. <strong>Gson</strong>의 <strong>fromJson()</strong> 사용</li>
        </ul>
      </li>
    </ol>
  </li>
</ol>

<ul>
  <li>
    <p>전체코드</p>

    <div class="language-plaintext highlighter-rouge"><div class="highlight"><pre class="highlight"><code>  package problem2
	
  import com.google.gson.Gson
  import java.io.File
  import java.io.ObjectInputStream
  import java.io.ObjectOutputStream
  import java.io.Serializable
	
  data class Student (
      val id: String,
      val name: String,
      val dept: String,
      val age: Int
  )
	
  fun main() {
      val student = Student("100", "Lee", "사물인터넷", 21)
	
      // 2. 객체를 Json 문자열로 변환
      val jsonString = Gson().toJson(student)
	
      // 3. Json 문자열을 텍스트 파일에 저장
      File("output.txt").writeText(jsonString)
	
      // 4. 텍스트 파일에서 저장된 Json 문자열을 읽기
      val resultStr = File("output.txt").readText()
	
      // 5. Json 문자열로부터 객체를 얻기
      println(Gson().fromJson(resultStr, Student::class.java))
  }
</code></pre></div>    </div>
  </li>
</ul>

<h2 id="2-실습문제">2. 실습문제</h2>
<ul>
  <li>Student 배열 객체인 students가 아래와 같이 초기화 되어 있을 경우에, 이를 파일에 저장하는 함수와 파일로부터 저장된 정보를 읽어와 Student 배열 객체를 재구성하여 반환하는 함수를 각각 구현하시오.
    <ul>
      <li>Student 클래스는 문제1의 정의를 따른다.</li>
    </ul>

    <div class="language-plaintext highlighter-rouge"><div class="highlight"><pre class="highlight"><code>  fun main() {
      var students = arrayOf(
          Student("100", "Lee", "사물인터넷", 21),
          Student("101", "Kim", "지능시스템", 21),
          Student("102", "Park", "사이버보안", 24),
          Student("111", "Kwon", "AI응용", 21),
      )
	
      saveDataToFile(students, "output.txt")
      students = loadDataFromFile("output.txt")
      students.forEach { println("$it") }
	
      saveObjectToFile(students, "output.dat")
      students = loadObjectFromFile("output.dat")
      students.forEach { println("$it") }
  }
</code></pre></div>    </div>
  </li>
  <li>
    <p>fun loadDataFromFile(path: String): Array&lt;Student&gt; {…}</p>
  </li>
  <li>
    <p>fun saveDataToFile(students: Array&lt;Student&gt;, path: String) {…}</p>
  </li>
  <li>
    <p>fun saveObjectToFile(students: Array&lt;Student&gt;, path: String) {…}</p>
  </li>
  <li>fun loadObjectFromFile(path: String):Array&lt;Student&gt; {…}</li>
</ul>



      
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/anchor-js/4.1.0/anchor.min.js" integrity="sha256-lZaRhKri35AyJSypXXs4o6OPFTbTmUoltBbDCbdzegg=" crossorigin="anonymous"></script>
    <script>anchors.add();</script>
  </body>
</html>
