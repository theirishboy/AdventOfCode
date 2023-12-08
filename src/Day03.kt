fun main() {
    fun isDigitOrDot(oneElement: Char) : Boolean{
        return oneElement in '0'..'9' || oneElement == '.';

    }
    fun symbolAround(line: String, index: Int) : Boolean{
        if(line.isNotEmpty()){
            if (!isDigitOrDot(line[index])){
            println(line[index])

            return true
        }
        if(index > 0){
            if (!isDigitOrDot(line[index-1])){
                println(line[index-1])

                return true
            }

        }
        if (index+1 < line.length) {
            if (!isDigitOrDot(line[index+1])){
                println(line[index+1])

                return true
            }
        }}
        return false

    }


    fun checkALine(
        lineAct: String,
        linePrec: String,
        lineNext: String,
        ): Int {
        var localTot = 0
        var aNumber = ""
        var browseNumber = false
        var index = 0
        var isNumberIn = false
        for (element in lineAct) {
            if (element.code in 48..57) {
                if (!browseNumber) browseNumber = true
                aNumber += element
            }
            if (browseNumber) {
                if (symbolAround(linePrec, index) || symbolAround(
                        lineAct,
                        index
                    ) || symbolAround(lineNext, index)
                ) {
                    isNumberIn = true
                }
            }
            if (browseNumber && (lineAct[index].code !in 49..57 || index+1 == lineAct.length)) {
                if (isNumberIn) localTot += aNumber.toInt()
                browseNumber = false
                println("$aNumber $isNumberIn")
                isNumberIn = false
                aNumber = ""
            }

            index++

        }
        return localTot
    }

    fun part1(input: List<String>): Int {
        //the goal is to sum all number that have an adjacent symbol even diagonally
        //detect number
        //partNumber ?
        //Is there an element at they emplacement (-1 +1) at the top and bottom that is a special character
        //What's a special character ?
        var lineAct = ""
        var linePrec = ""
        var lineNext= ""
        var tot = 0
        for(line in input){
            linePrec = lineAct
            lineAct = lineNext
            lineNext = line
            tot += checkALine(lineAct, linePrec, lineNext)
        }
        linePrec = lineAct
        lineAct = lineNext
        lineNext = ""
        tot += checkALine(lineAct,linePrec,lineNext)
        return tot
    }

    fun part2(input: List<String>): Int {
        for(line in input){

        }
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 5015)

    val input = readInput("input")
    part1(input).println()
    //part2(input).println()
}
