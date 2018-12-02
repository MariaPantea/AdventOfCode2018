import java.io.File

var path = "/Users/maria/IdeaProjects/AdventOfCode2018/src/input/"

fun readFileToNumberList(fileName: String) : List<Int>{
    val input = File(fileName).readText(Charsets.UTF_8)
    return input.split("\n").map { it.toInt() }
}

fun readFileToList(fileName: String) : List<String>{
    val input = File(fileName).readText(Charsets.UTF_8)
    return input.split("\n")
}