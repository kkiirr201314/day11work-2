import java.lang.IllegalArgumentException

fun main() {

    println(currentRoom.description())
    println(currentRoom.load())

    val auraColor = player.auraColor()
    player.auraColor()
    var townSquare = TownSquare()
    var className = when(townSquare){

        is room -> "Room"
        is TownSquare -> "TownSquare"
        else -> throw IllegalArgumentException()
    }
    print(className)

    printPlayerStatus(player)
    Game.play()
}

object Game{
    private val player = Player("Madrigal")
    private var currentRoom: = TownSquare()

    init{
        println("歡迎，冒險者")
        player.castFireball()
    }
    fun play(){
        while (true){

        }
    }
    private  fun  printPlayerStatus(player: Player){
        println("光環顏色:${player.auraColor()}" + "     走運嗎?${if (player.isBlessed) "是的" else "否，他很背"}")
        println("${player.name} ${player.formatHealthStatus()}")
    }
}