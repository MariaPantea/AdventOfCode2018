import kotlin.math.abs

fun main(args: Array<String>) {
    val polymer = readFileToList(path + "input5").first().toMutableList()

    // First star
    val molecules = blowUpMolecules(polymer)
    println("First star: ${molecules.size}")

    // Second star
    val polymerLengths = IntArray(26)

    for ((i, char: Char) in ('a'..'z').withIndex()) {
        val cleanedMolecules = removeUnit(char, molecules).toMutableList()
        val result = blowUpMolecules(cleanedMolecules).size
        polymerLengths[i] = result
    }
    val shortestPolymer = polymerLengths.filter { it > 0 }.min()
    println("Second star: $shortestPolymer")
}

fun blowUpMolecules(molecules: MutableList<Char>): MutableList<Char> {
    var pointer = 0

    while (pointer < molecules.size - 1) {
        val c1 = molecules[pointer]
        val c2 = molecules[pointer + 1]
        if (isBlowable(c1, c2)) {
            molecules.removeAt(pointer + 1)
            molecules.removeAt(pointer)
            if (pointer != 0) pointer -= 1
        } else pointer += 1
    }
    return molecules
}

fun isBlowable(c1: Char, c2: Char): Boolean = abs(c1.toInt() - c2.toInt()) == 32

fun removeUnit(lowerChar: Char, molecules: MutableList<Char>): List<Char> =
    molecules.filter { it.toLowerCase().toInt() - lowerChar.toInt() != 0 }
