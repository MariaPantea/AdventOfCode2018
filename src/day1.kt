import java.io.File

fun main(args: Array<String>) {
    val numbers = readFileToNumberList(path + "input1")

    // First star
    println(numbers.fold(0) { total, n -> total + n})

    // Second star
    var visited : MutableList<Int> = mutableListOf()
    var currentFrequency = 0
    var pointer = 0

    while (!visited.contains(currentFrequency)){
        visited.add(currentFrequency)
        currentFrequency += numbers[pointer]
        pointer = if (pointer == numbers.size -1) 0 else pointer + 1
    }
    println("Visited twice: $currentFrequency")
}

