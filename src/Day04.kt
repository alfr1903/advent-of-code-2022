fun main() {
    fun part1(input: List<String>): Int = input.count { hasCompleteOverlap(it) }
    fun part2(input: List<String>): Int = input.count { hasPartialOverlap(it) }

    val input = readInputAsList("Day04Input")
    println(part1(input))
    println(part2(input))
}

private fun hasCompleteOverlap(inp: String): Boolean {
    val ranges: List<String> = inp.split(",")
    val firstRange: IntRange = ranges.first().substringBefore("-").toInt()..ranges.first().substringAfter("-").toInt()
    val secondRange: IntRange = ranges.last().substringBefore("-").toInt()..ranges.last().substringAfter("-").toInt()
    return (firstRange.first <= secondRange.first && firstRange.last >= secondRange.last)
            || (secondRange.first <= firstRange.first && secondRange.last >= firstRange.last)
}

private fun hasPartialOverlap(inp: String): Boolean {
    val ranges: List<String> = inp.split(",")
    val firstRange: IntRange = ranges.first().substringBefore("-").toInt()..ranges.first().substringAfter("-").toInt()
    val secondRange: IntRange = ranges.last().substringBefore("-").toInt()..ranges.last().substringAfter("-").toInt()
    return (firstRange.contains(secondRange.first) || firstRange.contains(secondRange.last))
            || (secondRange.contains(firstRange.first) || secondRange.contains(firstRange.last))
}
