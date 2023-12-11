fun main() {
    fun part1(input: List<String>): Int {
        //Step One find AAA, transform all those string in map<String, Array<String>[1]
        val mapOut : MutableMap<String,MutableList<String>> = mutableMapOf()
        var instruction  = ""
        var isInstruction = true
        for(line in input){
            var word = ""
            var key = ""
            var isAKey = true
            var storeFuturElement : MutableList<String> = arrayListOf()
            for (element in line){
                if (element.code in 'A'.code..'Z'.code){
                    if (isInstruction){
                        print(element)
                        instruction+=element
                    }else{
                        word += element
                    }
                }else{
                    if (word != "" && isAKey){
                        mapOut[word] = arrayListOf()
                        key = word
                        word = ""
                        isAKey = false
                    }else{
                        if (word != ""){
                            storeFuturElement.add(word)
                            if (storeFuturElement.size == 2) {
                                mapOut[key] = storeFuturElement
                                storeFuturElement = arrayListOf()
                                isAKey = true
                            }
                            word = ""
                        }

                    }
                }
            }
            isInstruction = false
        }
        var actPoint = "AAA"
        var leftOrRight = 0
        var index = 0
        var score = 0
        while (actPoint != "ZZZ"){
            if (index == instruction.length) index = 0
            leftOrRight = if (instruction[index] == 'L')  0 else 1
            actPoint = mapOut[actPoint]?.get(leftOrRight) ?: ""
            index++
            score++
        }
        println(instruction)
        println(mapOut)
        return score
    }

    fun findLCM(allScore: MutableList<Int>) {
        val modifyValues = allScore.toMutableList()
        var allEqual = false
        println(modifyValues)

        while (allEqual == false){
            var smallest = modifyValues.minOrNull()
            var index = modifyValues.indexOf(smallest)
            if (smallest != null) {
                modifyValues[index] = smallest + allScore[index]
            }
            allEqual = true
            var elemPrec = modifyValues[0]
            for (element in modifyValues){
                if(element == elemPrec) continue else allEqual = false
                elemPrec = element
            }

        }
        println(modifyValues)


    }

    fun part2(input: List<String>): Int {
        val mapOut : MutableMap<String,MutableList<String>> = mutableMapOf()
        var instruction  = ""
        var isInstruction = true
        for(line in input){
            var word = ""
            var key = ""
            var isAKey = true
            var storeFuturElement : MutableList<String> = arrayListOf()
            for (element in line){
                if (element.code in 'A'.code..'Z'.code){
                    if (isInstruction){
                        instruction+=element
                    }else{
                        word += element
                    }
                }else{
                    if (word != "" && isAKey){
                        mapOut[word] = arrayListOf()
                        key = word
                        word = ""
                        isAKey = false
                    }else{
                        if (word != ""){
                            storeFuturElement.add(word)
                            if (storeFuturElement.size == 2) {
                                mapOut[key] = storeFuturElement
                                storeFuturElement = arrayListOf()
                                isAKey = true
                            }
                            word = ""
                        }

                    }
                }
            }
            isInstruction = false
        }
        val listOfStartingPoint = mapOut.filter { it.key.endsWith('A') }
        var score = 0
        println(listOfStartingPoint)
        val allScore : MutableList<Int> = mutableListOf()
        var i = 0

        for (element in listOfStartingPoint){
                var actPoint = element.key
                var leftOrRight: Int
                var index = 0
                while (!actPoint.endsWith('Z')){
                    if (index == instruction.length) index = 0
                    leftOrRight = if (instruction[index] == 'L')  0 else 1
                    actPoint = mapOut[actPoint]?.get(leftOrRight) ?: ""
                    index++
                    score++
                }
                  allScore.add(score)
                println("output find at score ${allScore[i]} for ${element.key} with $i")
                score = 0
                i++
            }
        println(allScore)
        findLCM(allScore)
        return score
    }

    // test if implementation meets criteria from the description, like:
    val day = "Day08"
    val testInput = readInput("${day}_test")
  //  check(part2(testInput) == 6)

    val input = readInput(day)
    //part1(input).println()
    part2(input).println()
}
