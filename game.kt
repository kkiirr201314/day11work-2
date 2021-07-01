import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

fun main() {

    Game.play()
}

object Game{
    private val player = Player("Madrigal")
    private var currentRoom: room = TownSquare()

    private var worldMap = listOf(
        listOf(currentRoom, room("Tavern"),room("Black Room")),
        listOf(room("Long Corridor"), room("Generic Room")))

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
            println(GameInput(readLine()).processCommand())
        }
    }
    private  fun  printPlayerStatus(player: Player){
        println("光環顏色:${player.auraColor()}" + "     走運嗎?${if (player.isBlessed) "是的" else "否，他很背"}")
        println("${player.name} ${player.formatHealthStatus()}")
    }
    private class GameInput(arg: String?){
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, {""})

        fun processCommand() = when (command.toLowerCase()){
            else -> commandNotFound()
        }
        private fun commandNotFound() = "我不太確定你想做什麼!"
    }
    private  fun move(directionInput: String) =
    try{
        val direction = Direction.valueOf(directionInput.toUpperCase())
        val newPosition = direction.updateCoordinate(player.currentPosition)
        if (!newPosition.isInBounds){
            throw IllegalStateException("$direction is out of bounds.")
        }
        val newRoom = worldMap[newPosition.y][newPosition.x]
        player.currentPosition = newPosition
        currentRoom = newRoom
        "Ok, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
    }catch (e:Exception){
        "Invalid direction: $directionInput."
    }

}