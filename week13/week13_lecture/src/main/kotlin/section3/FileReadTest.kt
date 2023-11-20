package section3

import java.io.*

fun main() {
    val path = "testfile.txt"

    // 1. Java 스타일
    readJavaStyle(path)

    // 2. use와 Reader.readText(), File.bufferReader() 사용
    useReadTextBufferedReader(path)

    // 3. BufferedReader의 useLines 사용
    BRuseLines(path)

    // 4. File의 useLines 사용
    fileUseLines(path)

}

fun readJavaStyle(path:String) {
    val inputString = StringBuilder()
    try {
        val file = File(path)
        val inStream: InputStream = file.inputStream()
        val isr = InputStreamReader(inStream)
        val br = BufferedReader(isr)

        var line = br.readLine()
        while (line != null) {
            inputString.append(line, '\n')
            line = br.readLine()
        }
        br.close()
    } catch (e:Exception){ }
    println(inputString)
}

fun useReadTextBufferedReader(path:String) {
    val br:BufferedReader
    try {
        br = File(path).bufferedReader()
    }catch (e:Exception){ return }

    val inputString = br.use { it.readText() }
    println(inputString)
}

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