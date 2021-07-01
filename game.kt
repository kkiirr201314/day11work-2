import java.lang.IllegalArgumentException

fun main() {

    Game.play()
}

object Game{
    private val player = Player("Madrigal")
    private var currentRoom: room = TownSquare()

    init{
        println("歡迎，冒險者")
        player.castFireball()
    }
    fun play(){
        while (true){
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)
            print("> 輸入您的命令: ")
            println("最後命令: ${readLine()}")
        }
    }
    private  fun  printPlayerStatus(player: Player){
        println("光環顏色:${player.auraColor()}" + "     走運嗎?${if (player.isBlessed) "是的" else "否，他很背"}")
        println("${player.name} ${player.formatHealthStatus()}")
    }
}