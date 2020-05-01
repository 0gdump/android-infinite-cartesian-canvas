package open.geosolve.canvasdemo.model

class Node(
    var x: Float,
    var y: Float
) : Element {

    var isMove = false
    val neighborLines: MutableList<Line> = ArrayList()

    var outerAngle: Float? = null
        private set

    var innerAngle: Float? = null
        private set

    // TODO Защита от дурака
    fun setInnerAngle(value: Float?) {
        innerAngle = value
        outerAngle = if (value != null) 360f - value else null
    }

    // TODO Защита от дурака
    fun setOuterAngle(value: Float?) {
        outerAngle = value
        innerAngle = if (value != null) 360f - value else null
    }

    fun moveNode(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    fun inRadius(x: Float, y: Float): Boolean {
        val xBool = this.x - 0.05f < x && x < this.x + 0.05f

        val yBool = this.y - 0.05f < y && y < this.y + 0.05f

        return xBool && yBool
    }

    // TODO Переписать систему перетаскивания точек
    fun stopMove(): Boolean {
        return if (isMove) {
            isMove = false
            true
        } else false
    }

}