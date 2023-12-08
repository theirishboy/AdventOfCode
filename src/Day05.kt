

fun main() {
    ///Seed are map between 0 and 100 with rules
    //If seed don't have rules, their default value is the value
    //The format is source categorie/destination categorie/number of value concerned

    //first step get the seed





    fun part1(input: List<String>): Long {

        val mySeedsString : List<String> = input.first().replace("seeds: ", "").split(" ").toMutableList()
        var mySeeds : MutableList<Long> = arrayListOf()
        for (element in mySeedsString){
            mySeeds.add(element.toLong())
        }
        println(mySeeds)
        var inConversion = false
        var listForNextBlock : MutableList<Long> = arrayListOf()
        for(line in input){
            var myLineElement : List<String> = emptyList()
            if (line.isNotEmpty() && line.first().code in 48..57 ){
                myLineElement = line.split(" ")
                inConversion = true
            }
            else{
                inConversion = false
                if (listForNextBlock.isNotEmpty()){
                    for (seed in mySeeds){
                        if (seed != (-1).toLong()){
                            listForNextBlock.add(seed)
                            println(listForNextBlock)

                        }
                    }
                    mySeeds = listForNextBlock
                    listForNextBlock = arrayListOf()
                }
            }
            if (inConversion){
                for (i in 0..<mySeeds.size){
                    if (mySeeds[i] in myLineElement[1].toLong()..myLineElement[1].toLong()+(myLineElement[2].toLong()-1)){
                        println("mySeed ${mySeeds[i]} will be transform")
                        mySeeds[i] = myLineElement[0].toLong() + (mySeeds[i] - myLineElement[1].toLong())
                        listForNextBlock.add(mySeeds[i])
                        mySeeds[i] = -1

                    }
                }
            }

         //   println(mySeeds)

        }
        if (inConversion){
            if (listForNextBlock.isNotEmpty()){
                for (seed in mySeeds){
                    if (seed != (-1).toLong()){
                        listForNextBlock.add(seed)
                        println(listForNextBlock)

                    }
                }
            }
        }
        listForNextBlock.sortBy { it.dec() }

        return listForNextBlock.first()
    }

    fun part2(input: List<String>): Long {
        val mySeedsString : List<String> = input.first().replace("seeds: ", "").split(" ").toMutableList()
        var mySeeds : MutableList<Long> = arrayListOf()
        for (element in mySeedsString){
            mySeeds.add(element.toLong())
        }
        for (i in 1..<mySeeds[1]){
            mySeeds.add(mySeeds[0]+i)
        }
        for (i in 1..<mySeeds[3]){
            mySeeds.add(mySeeds[2]+i)
        }
        mySeeds.removeAt(index = 1)
        mySeeds.removeAt(index = 2)

        println(mySeeds)
        var inConversion = false
        var listForNextBlock : MutableList<Long> = arrayListOf()
        for(line in input){
            var myLineElement : List<String> = emptyList()
            if (line.isNotEmpty() && line.first().code in 48..57 ){
                myLineElement = line.split(" ")
                inConversion = true
            }
            else{
                inConversion = false
                if (listForNextBlock.isNotEmpty()){
                    for (seed in mySeeds){
                        if (seed != (-1).toLong()){
                            listForNextBlock.add(seed)
                            println(listForNextBlock)

                        }
                    }
                    mySeeds = listForNextBlock
                    listForNextBlock = arrayListOf()
                }
            }
            if (inConversion){
                for (i in 0..<mySeeds.size){
                    if (mySeeds[i] in myLineElement[1].toLong()..myLineElement[1].toLong()+(myLineElement[2].toLong()-1)){
                        println("mySeed ${mySeeds[i]} will be transform")
                        mySeeds[i] = myLineElement[0].toLong() + (mySeeds[i] - myLineElement[1].toLong())
                        listForNextBlock.add(mySeeds[i])
                        mySeeds[i] = -1

                    }
                }
            }

            //   println(mySeeds)

        }
        if (inConversion){
            if (listForNextBlock.isNotEmpty()){
                for (seed in mySeeds){
                    if (seed != (-1).toLong()){
                        listForNextBlock.add(seed)
                        println(listForNextBlock)

                    }
                }
            }
        }
        listForNextBlock.sortBy { it.dec() }
        println(listForNextBlock)
        return listForNextBlock.first()
    }

    val day = "Day05"
    val testInput = readInput("${day}_test")
    //check(part1(testInput) == 35.toLong())
  //  check(part2(testInput) == 46.toLong())

    val input = readInput(day)
    part1(input).println()
    part2(input).println()
}
