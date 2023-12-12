fun main() {
    fun part1(input: List<String>): Int {
        var tot = 0
        var oneTableLine : MutableList<MutableList<Int>>
        var i = 0
        for(line in input){
            i = 0
            oneTableLine = arrayListOf()
            oneTableLine.add(emptyList<Int>().toMutableList())
            var oneNumber = ""
            for(element in line){
                if(element.code in 48..57 || element == '-' ) oneNumber += element else{
                    if (oneNumber.isNotEmpty()){
                        oneTableLine[i].add(oneNumber.toInt())
                        oneNumber = ""
                    }

                }
            }
            if (oneNumber.isNotEmpty()){
                oneTableLine[i].add(oneNumber.toInt())
            }
            while (!oneTableLine[i].all{it == 0}){
                oneTableLine.add(emptyList<Int>().toMutableList())
                for(j in 0..oneTableLine[i].size-2){
                    oneTableLine[i+1].add(oneTableLine[i][j+1]-oneTableLine[i][j])
                }
                oneTableLine[i].add(0)
                i++
            }
            for (j in oneTableLine.size-2 downTo 0){
                    oneTableLine[j][oneTableLine[j].size-1] = oneTableLine[j+1].last() + oneTableLine[j][oneTableLine[j].size-2]
            }
            tot += oneTableLine.first().last()




        }
        println(tot)
        return tot
    }

    fun part2(input: List<String>): Int {
        var tot = 0
        var oneTableLine : MutableList<MutableList<Int>>
        var i = 0
        for(line in input){
            i = 0
            oneTableLine = arrayListOf()
            oneTableLine.add(emptyList<Int>().toMutableList())
            var oneNumber = ""
            for(element in line){
                if(element.code in 48..57 || element == '-' ) oneNumber += element else{
                    if (oneNumber.isNotEmpty()){
                        oneTableLine[i].add(oneNumber.toInt())
                        oneNumber = ""
                    }

                }
            }
            if (oneNumber.isNotEmpty()){
                oneTableLine[i].add(oneNumber.toInt())
            }
            //put all to 0
            while (!oneTableLine[i].all{it == 0}){
                oneTableLine.add(emptyList<Int>().toMutableList())
                for(j in 0..oneTableLine[i].size-2){
                    oneTableLine[i+1].add(oneTableLine[i][j+1]-oneTableLine[i][j])
                }
                oneTableLine[i].add(0,0)
                i++
            }
            //determine the result
            for (j in oneTableLine.size-2 downTo 0){
                oneTableLine[j][oneTableLine[j][0]] = oneTableLine[j][1] - oneTableLine[j+1][oneTableLine[j].first()]
            }
            tot += oneTableLine.first().first()




        }
        println(tot)
        return tot
    }

    // test if implementation meets criteria from the description, like:
    val day = "Day09"
    val testInput = readInput("${day}_test")
   //check(part1(testInput) == 114)

    val input = readInput(day)
    part1(input).println()
    part2(input).println()
}
