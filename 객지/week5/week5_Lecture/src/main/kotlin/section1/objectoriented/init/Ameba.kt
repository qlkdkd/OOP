package section1.objectoriented.revision


class Ameba {
    val shape = "AMEBA"
    val sound = "ameba.hif"
    fun rotate() {
        println("도형의 한쪽 끝을 기준으로 360도 회전:$shape")
    }

    fun playSound() {
        println("HIF 사운드 재생:$sound")
    }
}
