package section1.objectoriented.init

class Circle {
    val shape = "CIRCLE"
    val sound = "circle.aif"
    fun rotate() {
        println("도형의 중심을 기준으로 360도 회전:$shape")
    }

    fun playSound() {
        println("AIF 사운드 재생:$sound")
    }
}