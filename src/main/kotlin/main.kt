package ru.netology

fun main() {
    var seconds = 1
    do {

        println(agoToText(seconds)) // m: ${seconds / 60}")
        seconds += 60
    } while (seconds < 60 * 60)

    do {
        println(agoToText(seconds)) // H: ${(seconds / 60) / 60}")
        seconds += 60 * 60
    } while (seconds < 60 * 60 * 24)

    do {
        println(agoToText(seconds)) // D: ${((seconds / 60) / 60) / 24}")
        seconds += 60 * 60 * 24
    } while (seconds < 60 * 60 * 24 * 4)

}


fun agoToText(seconds: Int): String {

    val daySeconds = 24 * 60 * 60;
    return when {
        seconds < 60 -> "был(а) только что"
        seconds < 60 * 60 -> "был(а) ${hoursOrMinutesAgo(seconds)} назад"
        seconds < daySeconds -> "был(а) ${hoursOrMinutesAgo(isHours = true, seconds = seconds)} назад"
        seconds < daySeconds * 2 -> "был(а) вчера"
        seconds < daySeconds * 3 -> "был(а) позавчера"
        else -> "был(а) давно"
    }

}

fun hoursOrMinutesAgo(seconds: Int, isHours: Boolean = false): String {
    if (isHours) {
        val hours = (seconds / 60) / 60
        return when {
            preFastFastNumberIsEquals(hours) == 1 -> "$hours час"
            preFastFastNumberIsEquals(hours) == 2 ||
                    preFastFastNumberIsEquals(hours) == 3 ||
                    preFastFastNumberIsEquals(hours) == 4
            -> "$hours часа"

            else -> "$hours часов"

        }

    } else {

        val minutes = seconds / 60;
        return when {
            preFastFastNumberIsEquals(minutes) == 1 -> "$minutes минуту"
            preFastFastNumberIsEquals(minutes) == 2 ||
                    preFastFastNumberIsEquals(minutes) == 3 ||
                    preFastFastNumberIsEquals(minutes) == 4
            -> "$minutes минуты"

            else -> "$minutes минут"
        }
    }
}

fun preFastFastNumberIsEquals(
    number: Int,
): Int {

    return when {

        number == 1 || number in 21..61 step 10 -> 1 //-ту / -с
        (number in 2..4
                || number in 22..24
                || number in 32..34
                || number in 42..44
                || number in 52..54)
        -> 2 //-ты / -са

        else -> 0 // -т / -ов
    }


}
