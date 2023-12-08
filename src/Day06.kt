fun main() {
    fun part1(input: List<String>): Int {
        var time : MutableList<Int> = arrayListOf()
        var distance : MutableList<Int> = arrayListOf()
        var nbline = 1
        for(line in input){
            var number = ""
            for ((index, element) in line.withIndex()){
                if (element.code in 48..57){
                    number+= element
                    println(index)

                } else if (number.isNotEmpty() ){
                    if ( nbline == 1) {
                        time.add(number.toInt())
                        number = ""
                    }
                    if (nbline == 2){
                        distance.add(number.toInt())
                        number = ""

                    }
                }
                if (index == line.length-1 && number.isNotEmpty()){
                    if ( nbline == 1) {
                        time.add(number.toInt())
                        number = ""
                    }
                    if (nbline == 2){
                        distance.add(number.toInt())
                        number = ""

                    }
                }
            }
            nbline++
        }
        //the boat's speed increases by one millimeter per millisecond. but don't move until you release
        var distanceNb = 0
        var score = 1
        for (oneTime in time){
            var nbTimeBetter = 0
            for (i in 0..oneTime){
                val distanceTraveled = i*1*(oneTime-i)
                if (distanceTraveled > distance[distanceNb]) nbTimeBetter++
            }
            score *= nbTimeBetter
            distanceNb++
        }
        println("$time, $distance")
        return score
    }

    fun part2(input: List<String>): Long {

        val time : MutableList<Long> = arrayListOf()
        val distance : MutableList<Long> = arrayListOf()
        var nbline = 1
        for(line in input){
            var number = ""
            for ((index, element) in line.withIndex()){
                if (element.code in 48..57){
                    number+= element

                }
                if (index == line.length-1 && number.isNotEmpty()){
                    if ( nbline == 1) {
                        time.add(number.toLong())
                        number = ""
                    }
                    if (nbline == 2){
                        distance.add(number.toLong())
                        number = ""

                    }
                }
            }
            nbline++
        }
        //the boat's speed increases by one millimeter per millisecond. but don't move until you release
        var distanceNb = 0
        var score: Long = 1
        for (oneTime in time){
            var nbTimeBetter = 0
            for (i in 0..oneTime){
                val distanceTraveled = i*1*(oneTime-i)
                if (distanceTraveled > distance[distanceNb]) nbTimeBetter++
            }
            score *= nbTimeBetter
            distanceNb++
        }
        println("$time, $distance")
        return score
    }

    // test if implementation meets criteria from the description, like:
    val day = "Day06"
    val testInput = readInput("${day}_test")
   // check(part1(testInput) == 288)
    check(part2(testInput) == 71503.toLong())

    val input = readInput(day)
  //  part1(input).println()
    part2(input).println()
}
