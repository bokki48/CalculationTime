package com.example.calculationtime

fun parseTime(time: String): Triple<Int, Int, Int> {
    var hours = 0
    var minutes = 0
    var seconds = 0

    val regex = """(\d+)([hms])""".toRegex()
    regex.findAll(time).forEach { match ->
        val value = match.groups[1]!!.value.toInt()
        when (match.groups[2]!!.value) {
            "h" -> hours += value
            "m" -> minutes += value
            "s" -> seconds += value
        }
    }

    return Triple(hours, minutes, seconds)
}