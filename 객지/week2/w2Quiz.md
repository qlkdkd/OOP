<!DOCTYPE html>
<html lang="en-US">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Begin Jekyll SEO tag v2.8.0 -->
<title>Kotlin/Java 프로그래밍 기초 1 실습 | KJ-exercise</title>
<meta name="generator" content="Jekyll v3.9.3" />
<meta property="og:title" content="Kotlin/Java 프로그래밍 기초 1 실습" />
<meta property="og:locale" content="en_US" />
<link rel="canonical" href="https://kwanulee.github.io/KJ-exercise/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%20%EA%B8%B0%EC%B4%88%201%20%EC%8B%A4%EC%8A%B5.html" />
<meta property="og:url" content="https://kwanulee.github.io/KJ-exercise/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%20%EA%B8%B0%EC%B4%88%201%20%EC%8B%A4%EC%8A%B5.html" />
<meta property="og:site_name" content="KJ-exercise" />
<meta property="og:type" content="website" />
<meta name="twitter:card" content="summary" />
<meta property="twitter:title" content="Kotlin/Java 프로그래밍 기초 1 실습" />
<script type="application/ld+json">
{"@context":"https://schema.org","@type":"WebPage","headline":"Kotlin/Java 프로그래밍 기초 1 실습","url":"https://kwanulee.github.io/KJ-exercise/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%20%EA%B8%B0%EC%B4%88%201%20%EC%8B%A4%EC%8A%B5.html"}</script>
<!-- End Jekyll SEO tag -->

    <link rel="stylesheet" href="/KJ-exercise/assets/css/style.css?v=e56f0c9bde7f0f066286ce17bc33e4ac312a6d4e">
    <!-- start custom head snippets, customize with your own _includes/head-custom.html file -->

<!-- Setup Google Analytics -->



<!-- You can set your favicon here -->
<!-- link rel="shortcut icon" type="image/x-icon" href="/KJ-exercise/favicon.ico" -->

<!-- end custom head snippets -->

  </head>
  <body>
    <div class="container-lg px-3 my-5 markdown-body">
      
      <h1><a href="https://kwanulee.github.io/KJ-exercise/">KJ-exercise</a></h1>
      

      <h1 id="kotlinjava-프로그래밍-기초-1-실습">Kotlin/Java 프로그래밍 기초 1 실습</h1>

<h2 id="0-시작하기-전에">0. 시작하기 전에</h2>

<p>이 Codelab에서는 Kotlin 및 Java 프로젝트의 구조를 이해하고, 프로그램의 기본 개념인  변수, 자료형, 연산자를 활용하여 기초적인 프로그램을 실습해봅니다.</p>

<h3 id="실습-준비">실습 준비</h3>

<ul>
  <li>최신 버전의 JDK와 IntelliJ IDEA IDE가 설치된 컴퓨터</li>
  <li>패키지, 변수와 자료형, 연산자 주제의 온라인 강의영상 시청 완료</li>
</ul>

<h3 id="실습할-내용">실습할 내용</h3>

<ul>
  <li>IntelliJ IDEA IDE환경에서 Kotlin 및 Java 프로젝트를 생성하고, 패키지를 생성하여 파일 및 클래스를 구조화하는 방법을 실습해봅니다.</li>
  <li>Kotlin 과 Java 언어에서 다양한 자료형으로 변수를 선언하고 초기화하는 방법을 실습해봅니다.</li>
  <li>Kotlin 과 Java 언어에서 변수의 자료형을 검사하고 변환하는 방법을 실습해봅니다.</li>
  <li>Kotlin 과 Java 언어에서 다양한 연산자를 활용하여 프로그램의 결과를 예측해 봅시다.</li>
</ul>

<h2 id="1-java-및-kotlin-패키지-생성하기">1. Java 및 Kotlin 패키지 생성하기</h2>

<ol>
  <li>
    <p>다음과 같은 설정의 Kotlin 프로젝트, 패키지, Kotlin 파일을 생성하고, IntelliJ IDEA IDE의 <em>Project File</em> 뷰를 통해 디렉토리, 패키지, 파일의 구조를 확인해보세요.</p>

    <ul>
      <li>
        <p>Kotlin 프로젝트</p>

        <div class="language-plaintext highlighter-rouge"><div class="highlight"><pre class="highlight"><code> - 이름: PackageCreation
</code></pre></div>        </div>
      </li>
      <li>
        <p>패키지</p>

        <ul>
          <li>이름: com.practice.oop.data</li>
        </ul>
      </li>
      <li>
        <p>Kotlin 클래스/파일</p>

        <div class="language-plaintext highlighter-rouge"><div class="highlight"><pre class="highlight"><code> - 이름 : Student.kt
 - 코드 
</code></pre></div>        </div>

        <div class="language-kotlin highlighter-rouge"><div class="highlight"><pre class="highlight"><code><span class="k">package</span> <span class="nn">com.practice.oop.data</span>
     
<span class="kd">class</span> <span class="nc">Student</span><span class="p">(</span><span class="kd">val</span> <span class="py">id</span><span class="p">:</span> <span class="nc">String</span><span class="p">,</span> <span class="kd">val</span> <span class="py">name</span><span class="p">:</span> <span class="nc">String</span><span class="p">)</span>
</code></pre></div>        </div>
      </li>
    </ul>
  </li>
  <li>
    <p>앞서 생성한 Kotlin 프로젝트에 다음과 같은 설정의 패키지와 Kotlin 파일을 생성하면, Student 부분에서 오류 메시지가 표시된다. 이를 해결하기 위해서 앞서 정의한 Student 클래스를 import한 후에, Kotlin 파일을 실행하여 아래와 같은 결과를 얻으시오.</p>

    <ul>
      <li>
        <p>패키지</p>

        <ul>
          <li>이름: com.practice.oop.view</li>
        </ul>
      </li>
      <li>
        <p>Kotlin 파일</p>

        <ul>
          <li>
            <p>이름: DisplayInformation.kt</p>
          </li>
          <li>
            <p>코드 :</p>

            <div class="language-kotlin highlighter-rouge"><div class="highlight"><pre class="highlight"><code><span class="k">package</span> <span class="nn">com.practice.oop.view</span>
       
<span class="k">fun</span> <span class="nf">main</span><span class="p">()</span> <span class="p">{</span>
        <span class="kd">val</span> <span class="py">std1</span> <span class="p">=</span> <span class="nc">Student</span><span class="p">(</span><span class="s">"AI001"</span><span class="p">,</span><span class="s">"Kildong"</span><span class="p">)</span>
       
        <span class="nf">println</span><span class="p">(</span><span class="n">std1</span><span class="p">.</span><span class="n">id</span><span class="p">)</span>
        <span class="nf">println</span><span class="p">(</span><span class="n">std1</span><span class="p">.</span><span class="n">name</span><span class="p">)</span>         
    <span class="p">}</span>
</code></pre></div>            </div>
          </li>
        </ul>
      </li>
      <li>
        <p>실행결과:</p>

        <div class="language-plaintext highlighter-rouge"><div class="highlight"><pre class="highlight"><code>AI001
Kildong
</code></pre></div>        </div>
      </li>
    </ul>
  </li>
  <li>
    <p>1,2번에서 진행된 내용을 Java 프로젝트로 만들어서 진행해 보세요.</p>
  </li>
</ol>

<h2 id="2-변수-선언과-초기화">2. 변수 선언과 초기화</h2>

<ol>
  <li>
    <p>다음 Kotlin 코드에서 변수 선언 및 초기화에 대해서 잘못된 부분이나 사용이 적절하지 않는 부분을 지적하고 이를 적절히 수정하시오.</p>

    <div class="language-kotlin highlighter-rouge"><div class="highlight"><pre class="highlight"><code><span class="k">fun</span> <span class="nf">main</span><span class="p">()</span> <span class="p">{</span> 
    <span class="kd">val</span> <span class="py">username</span> <span class="p">=</span> <span class="mi">123</span>
    <span class="kd">var</span> <span class="py">secondNumber</span> <span class="p">:</span> <span class="n">int</span> <span class="p">=</span> <span class="mi">30</span>
    <span class="n">username</span> <span class="p">=</span> <span class="s">"kwanwoo"</span>
    <span class="kd">val</span> <span class="py">exp01</span> <span class="p">=</span> <span class="mf">3.14</span>
    <span class="kd">var</span> <span class="py">_011</span> <span class="p">=</span> <span class="mi">4</span>    
<span class="p">}</span>
</code></pre></div>    </div>
  </li>
  <li>
    <p>변수의 값이나 표현식을 문자열 안에 넣어 출력하려면 $ 기호와 함께 변수나 표현식을 사용하면됩니다.</p>

    <ul>
      <li>
        <p>예제</p>

        <div class="language-kotlin highlighter-rouge"><div class="highlight"><pre class="highlight"><code><span class="kd">val</span> <span class="py">a</span> <span class="p">=</span> <span class="mi">1</span>
<span class="kd">val</span> <span class="py">b</span> <span class="p">=</span> <span class="mi">3</span>
<span class="kd">val</span> <span class="py">s1</span> <span class="p">=</span> <span class="s">"a is $a"</span>        <span class="c1">// $a는 a의 값을 문자열로 변환</span>
<span class="kd">val</span> <span class="py">s2</span> <span class="p">=</span> <span class="s">"b is $b"</span>        <span class="c1">// $b는 b의 값을 문자열로 변환</span>
<span class="kd">val</span> <span class="py">s3</span> <span class="p">=</span> <span class="s">"a+b is ${a+b}"</span>  <span class="c1">// ${a+b} 는 a+b의 수식 값을 문자열로 변환</span>
     
<span class="c1">// \"는 큰따옴포(")을 문자열의 종료 문자로 인지하지 않게하여 문자열 안에 포함시킴</span>
<span class="nf">println</span><span class="p">(</span><span class="s">"s1 = \"$s1\", s2 = \"$s2\", s3 = \"$s3\""</span><span class="p">)</span>  
</code></pre></div>        </div>
      </li>
      <li>
        <p>문제 : 다음과 같은 문자열이 출력되도록 코드를 작성하시오.</p>

        <div class="language-plaintext highlighter-rouge"><div class="highlight"><pre class="highlight"><code>"hello", I have $15.
</code></pre></div>        </div>
      </li>
    </ul>
  </li>
</ol>

<h2 id="3-연습문제">3. 연습문제</h2>

<ol>
  <li>
    <p>변수 input에는 임의의 4자리 정수가 할당된다고 가정한다. 이 변수의 4자리 정수 값을 예시된 형식으로 출력하는 Kotlin 코드를 작성하시오.</p>

    <ul>
      <li>
        <p>코드</p>

        <div class="language-kotlin highlighter-rouge"><div class="highlight"><pre class="highlight"><code><span class="k">fun</span> <span class="nf">main</span><span class="p">()</span> <span class="p">{</span>
    <span class="kd">val</span> <span class="py">input</span> <span class="p">=</span> <span class="mi">4938</span>
     
    <span class="c1">// 이 부분에 코드를 완성 하시오</span>
     
<span class="p">}</span>
</code></pre></div>        </div>
      </li>
      <li>
        <p>출력결과</p>

        <div class="language-plaintext highlighter-rouge"><div class="highlight"><pre class="highlight"><code>₩4,983
</code></pre></div>        </div>
      </li>
      <li>
        <p>힌트</p>

        <div class="language-plaintext highlighter-rouge"><div class="highlight"><pre class="highlight"><code>     - 자리수별로 값을 구하여 변수에 저장한 후에, 예시된 형식에 맞추어 변수의 값을 출력합니다.
     - 이때, ${변수}와 \(이스케이프 문자)를 활용합니다.
</code></pre></div>        </div>
      </li>
    </ul>
  </li>
  <li>
    <p>1번 문제에 대한 Java 코드를 작성하시오.</p>
  </li>
  <li>
    <p>4개의 변수 g1, g2, g3, g4에 0~100 사이의 임의의 정수값이 지정된다고 가정한다. 각 변수의 값, 변수 값의 총합, 변수 값의 평균(실수 값으로 표현되어야 함)을 각각 다음 형식으로 출력하는 코드를 작성하시오.</p>

    <ul>
      <li>
        <p>코드</p>

        <div class="language-kotlin highlighter-rouge"><div class="highlight"><pre class="highlight"><code><span class="k">fun</span> <span class="nf">main</span><span class="p">()</span> <span class="p">{</span>
    <span class="kd">val</span> <span class="py">g1</span> <span class="p">=</span> <span class="mi">78</span>
    <span class="kd">val</span> <span class="py">g2</span> <span class="p">=</span> <span class="mi">90</span>
    <span class="kd">val</span> <span class="py">g3</span> <span class="p">=</span> <span class="mi">84</span>
    <span class="kd">val</span> <span class="py">g4</span> <span class="p">=</span> <span class="mi">74</span>
     
    <span class="c1">// 이 부분에 코드를 완성 하시오</span>
     
<span class="p">}</span>
</code></pre></div>        </div>
      </li>
      <li>
        <p>출력결과 (예시)</p>

        <div class="language-plaintext highlighter-rouge"><div class="highlight"><pre class="highlight"><code>g1 = 78
g2 = 90
g3 = 84
g4 = 74
     
총합 = 326
평균 = 81.5
</code></pre></div>        </div>
      </li>
    </ul>
  </li>
  <li>
    <p>3번 문제에 대한 Java 코드를 작성하시오</p>
  </li>
</ol>


      
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/anchor-js/4.1.0/anchor.min.js" integrity="sha256-lZaRhKri35AyJSypXXs4o6OPFTbTmUoltBbDCbdzegg=" crossorigin="anonymous"></script>
    <script>anchors.add();</script>
  </body>
</html>
