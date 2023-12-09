fun main() {
    //understand the Card in the hands, witch one is the strongest, witch on is the weakest
    //Between A and Z order croissant, between 2 and 9 order decroissant
    //Then understand the value.
    //Count how many cards are the same => use collection. count.
    var a : List<Char>
    fun isElementOrigineHigher(elementOrgine: Char, elementToCompare: Char): Boolean {
        return if (elementOrgine.code in 48..57) {

            if (elementToCompare.code in 48..57) {
                elementOrgine.code > elementToCompare.code
            } else elementOrgine.code < elementToCompare.code
        } else {
            if (elementToCompare.code in 48..57) true
            else elementOrgine.code < elementToCompare.code

        }

    }

    fun part1(input: List<String>): Int {
        val orderedHand : MutableList<MutableMap<Char,Int>> = arrayListOf()
        for(line in input){
            val oneHand : MutableList<Char> = arrayListOf()
            val value : MutableMap<Char,Int> = mutableMapOf()
            var registerScore = false
            var score : String = ""
            for(element in line){
                if (element != ' '){
                    oneHand.add(element)
                }
                if (oneHand.isNotEmpty() && element == ' '){
                    for (eachCard in oneHand){
                        if (!value.contains(eachCard))
                        {
                            val repOfACard = oneHand.count { it == eachCard }
                            value[eachCard] = repOfACard
                        }

                    }
                    registerScore = true
                    value.values.sortedDescending()
                }
                if (registerScore && element != ' '){
                    score += element
                }
            }
            // Convert the map to a list and sort it
            val sortedList = value.toList().sortedByDescending { it.second }

            // Create a new LinkedHashMap to maintain the sorted order
            val sortedMap = LinkedHashMap<Char, Int>()
            for (pair in sortedList) {
                sortedMap[pair.first] = pair.second
            }
            sortedMap['S'] = score.toInt()
            println(sortedMap)
            println()
            if (orderedHand.isEmpty()) orderedHand.add(sortedMap) else{
                var insertIndex: Int? = null
                for ((index, hand) in orderedHand.withIndex()) {
                    val lookForNextCard = false
                    var i = 0
                    if (hand.values.elementAt(i) > sortedMap.values.elementAt(i)) continue
                    if (hand.values.elementAt(i) == sortedMap.values.elementAt(i)){

                    }
                    if (hand.values.elementAt(i) < sortedMap.values.elementAt(i)) {
                        insertIndex = index
                        break
                    }
                    //Pour chaque main
//                    val maxLocal =  if (hand.values.size < sortedMap.values.size)   hand.values.size else sortedMap.values.size
//                    for (i in 0..maxLocal){
//                        if (hand.values.elementAt(i) < sortedMap.values.elementAt(i)) {
//                            println("insert ${sortedMap.values.elementAt(i)} at $index")
//                            insertIndex = index
//                            break // Once you find the insertion point, you can exit the loop
//                        } else if (hand.values.elementAt(i) == sortedMap.values.elementAt(i)){
//                            if (isElementOrigineHigher(hand.keys.elementAt(i),sortedMap.keys.elementAt(i)) || hand.keys.elementAt(i) == sortedMap.keys.elementAt(i) ){
//                                insertIndex = index
//                                break
//                            }
//                        }
//                    }
//                    if (insertIndex != null) break

                }

                if (insertIndex != null) {
                    println(insertIndex)
                    orderedHand.add(insertIndex, sortedMap)
                } else {
                    orderedHand.add(sortedMap)
                }
            }

        }
        for (element in orderedHand) println(element)
        return input.size
    }

    fun part2(input: List<String>): Int {
        for(line in input){

        }
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val day = "Day07"
    val testInput = readInput("${day}_test")
    check(part1(testInput) == 6440)

    val input = readInput(day)
    part1(input).println()
    part2(input).println()
}
