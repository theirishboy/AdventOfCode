fun main() {
    //We have card
    //Each card has winning number at the beginning and the game number after a |
    //We need first to find the winning number and put them in a list, then check each other number if they are winning
    //For each number right we double the point
    //return the sum of all point
    fun part1(input: List<String>): Int {
        var total = 0
        var oneLine = ""
        var nbLine = 1
        for(line in input){
            oneLine = line.replace("Card $nbLine: ","")
            oneLine = oneLine.replace("Card  $nbLine: ","")
            oneLine = oneLine.replace("Card   $nbLine: ","")
            var lineTotal = 0
            var aNumber = ""
            val winningNumberList : MutableSet<Int> =HashSet()
            var winningNumber = true
            for(char in oneLine){
                if (char.code in 48..57){
                    aNumber += char

                }else{
                    if(char == '|') winningNumber = false
                    if(winningNumber && aNumber.isNotEmpty()){
                        winningNumberList.add(aNumber.toInt())
                        aNumber = ""
                    } else if (aNumber.isNotEmpty() && !winningNumber){
                        println(winningNumberList)
                        println(aNumber)
                        if (aNumber.toInt() in winningNumberList && aNumber != "  "){
                            winningNumberList.remove(aNumber.toInt())
                            println(winningNumberList)
                            if (lineTotal == 0){
                                lineTotal = 1
                            } else{
                                lineTotal *= 2

                            }
                        }
                        aNumber = ""


                    }
                }
            }
            if (aNumber.isNotEmpty() && !winningNumber){
                if (winningNumberList.contains(aNumber.toInt())){
                    if (lineTotal == 0){
                        lineTotal = 1
                    } else{
                        lineTotal *= 2

                    }
                }
            }
            total += lineTotal
            nbLine++
        }
        println(total)
        return total
    }
    ///part 2 Each time we match we win 1 copy of the next X card
    fun part2(input: List<String>): Int {
            var total = 0
            var oneLine = ""
            var nbLine = 1
            var mapOfScore : MutableMap<Int,Int> = mutableMapOf()
            for (i in 1..input.size){
                mapOfScore.put(i,1)
            }
            for (line in input) {
                oneLine = line.replace("Card $nbLine: ", "")
                oneLine = oneLine.replace("Card  $nbLine: ", "")
                oneLine = oneLine.replace("Card   $nbLine: ", "")
                var nbCopyToDo = 0
                var aNumber = ""
                val winningNumberList: MutableSet<Int> = HashSet()
                var winningNumber = true
                for (char in oneLine) {
                    if (char.code in 48..57) {
                        aNumber += char

                    } else {
                        if (char == '|') winningNumber = false
                        if (winningNumber && aNumber.isNotEmpty()) {
                            winningNumberList.add(aNumber.toInt())
                            aNumber = ""
                        } else if (aNumber.isNotEmpty() && !winningNumber) {
                            println(winningNumberList)
                            println(aNumber)
                            if (aNumber.toInt() in winningNumberList && aNumber != "  ") {
                                winningNumberList.remove(aNumber.toInt())
                                println(winningNumberList)
                                nbCopyToDo++
                            }
                            aNumber = ""


                        }
                    }
                }
                if (aNumber.isNotEmpty() && !winningNumber) {
                    if (winningNumberList.contains(aNumber.toInt())) {
                        nbCopyToDo++
                    }
                }
                for (i in 1..nbCopyToDo){
                    mapOfScore.replace(nbLine+i, mapOfScore[nbLine+i]!! + mapOfScore[nbLine]!!)
                }
                nbLine++
            }
            var totalAll = 0
            for (i in 1..input.size){
                totalAll += mapOfScore[i]!!
            }
        println(totalAll)
        return totalAll
    }

    // test if implementation meets criteria from the description, like:
    val day = "Day04"
    val testInputLimit: List<String> = listOf("Card 1: 41 41 48 48 83 86 17 5 9 2 2 | 2 22 48 41 48 41 83 86 6 31 17 9 48 53 41 83 5 9")
    val testInputLimit2: List<String> = listOf("Card  18: 80 99 40 59 75 82 25 70 87 92 | 90 32 27 30 95 33 12 31 78 75 26 44 87 83 39 81 55 43 76 22 61 25 99 69 59")
    val testInput = readInput("${day}_test")
//    check(part1(testInput) == 13)
//    check(part1(testInputLimit) == 128)
//    check(part1(testInputLimit2) == 16)
    check(part2(testInput) == 30)
    //check(part1(testInputLimit2) == 16)

    //cas limite possible :
    //Dans les inputs, duplication, one digit
    val input = readInput(day)
  //  part1(input).println()
    part2(input).println()
}
