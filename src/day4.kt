var sleep = HashMap<Int, Int>()
var sleepArray = IntArray(60)
var currentID = 0
var timeForFallingAsleep = 0


var guardSleepMatrix = Array(4000) { IntArray(60) }

fun main(args: Array<String>) {

    val entries = readFileToList(path + "input4").sorted()

    entries.map { fillMatrix(it) }

    var guards = guardSleepMatrix.map { it.sum() }
    var guard = guards.indexOf(guards.maxBy { it!! })
    var minute = guardSleepMatrix[guard].indexOf(guardSleepMatrix[guard].max()!!)
    val star1 = guard * minute

    println("First star $star1")

    var guards2 = guardSleepMatrix.map { it.max() }
    guard = guards2.indexOf(guards2.maxBy { it!! })
    minute = guardSleepMatrix[guard].indexOf(guardSleepMatrix[guard].max()!!)
    val star2 = guard * minute

    println("Second star $star2")

}

fun fillMatrix(entry: String) {
    val subEntries = entry.split(' ')

    when (subEntries[2].first()) {
        // New guard
        'G' -> currentID = subEntries[3].drop(1).toInt()

        // Falls asleep
        'f' -> timeForFallingAsleep = subEntries[1].drop(3).dropLast(1).toInt()

        // Wakes up
        'w' -> {
            var value = if (sleep.containsKey(currentID)) sleep[currentID]!! else 0
            val timeForWakingUp = subEntries[1].drop(3).dropLast(1).toInt()

            for (i: Int in timeForFallingAsleep until timeForWakingUp) {
                guardSleepMatrix[currentID][i] += 1
            }

        }
    }

}