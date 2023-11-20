package section2

import java.io.FileWriter
import java.io.IOException

fun main(){
    val path="textfile.txt"
    val outString="안녕하세요!\r\n FileWriter\t테스트입니다!\n"

    try{
        val writer=FileWriter(path,true)
        writer.write(outString)
        writer.close()
    }catch(e:IOException){}
}