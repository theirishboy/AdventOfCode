fun main() {
    fun part1(input: List<String>): Int {
        for(line in input){

        }
        return input.size
    }

    fun part2(input: List<String>): Int {
        for(line in input){

        }
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val day = "Day"
    val testInput = readInput("${day}_test")
    check(part1(testInput) == 1)

    val input = readInput(day)
    part1(input).println()
    part2(input).println()
}
