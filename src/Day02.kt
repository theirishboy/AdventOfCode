fun main() {
    fun part1(input: List<String>): Int {
        val maxStat : Map<String,Int> = mapOf(
            "red" to 12,
            "green" to 13,
            "blue" to 14
        )
        var nbline = 1
        var totalId = 0
        var totalIdNotWanted = 0
        for(line in input){
            var oneLine = line
            var oneWord = ""
            oneLine = oneLine.replace("Game $nbline: ","")
            totalId += nbline
            var valueOfAColor = 0
            for(j in oneLine){
                var lineIsImpossible = false
                oneWord += j
                if(j.code in 48..57){
                    valueOfAColor = if (valueOfAColor != 0){
                        valueOfAColor*10+ j.code-48
                    }else{
                        j.code-48
                    }
                }
                for (key in maxStat.keys){
                    if(oneWord.contains(key)){
                        if(valueOfAColor > maxStat[key]!!  ){
                            lineIsImpossible = true
                        }
                        oneWord = ""
                        valueOfAColor = 0
                    }
                }
                if (lineIsImpossible){
                    totalIdNotWanted+= nbline
                    break
                }


            }

            nbline++
        }
        return totalId-totalIdNotWanted
    }

    fun part2(input: List<String>): Int {
        //Max par couleur par line
        //Calculer ce max pour chaque ligne avec maxA*maxB
        var nbline = 1
        var power = 0
        for(line in input){
            val maxColor : MutableMap<String,Int> = mapOf(
                "red" to 0,
                "green" to 0,
                "blue" to 0
            ) as MutableMap<String, Int>
                var oneLine = line
                var oneWord = ""
                oneLine = oneLine.replace("Game $nbline: ","")
                var valueOfAColor = 0
                for(j in oneLine){
                    var lineIsImpossible = false

                    oneWord += j
                    if(j.code in 48..57){
                        valueOfAColor = if (valueOfAColor != 0){
                            valueOfAColor*10+ j.code-48
                        }else{
                            j.code-48
                        }
                    }
                    for (color in maxColor.keys){
                        if(oneWord.contains(color)){
                            if(valueOfAColor > maxColor[color]!!  ){
                                maxColor[color] = valueOfAColor
                            }
                            oneWord = ""
                            valueOfAColor = 0
                        }
                    }
            }
            power += maxColor["green"]!! * maxColor["blue"]!! * maxColor["red"]!!
            nbline++
        }
        return power
    }

    //output = somme of game ID, has tp be 8 on test
    //Verifier que max par tirage il y est 12 rouge 13 vert et 14blute
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    //part1(testInput).println()
    //part2(testInput).println()

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
