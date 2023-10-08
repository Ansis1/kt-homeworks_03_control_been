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
        val hoursArray = hours.toString().toCharArray()
        val hoursArrSize = hoursArray.size
        return when {
            preFastFastNumberIsEquals(hoursArray, 1, hoursArrSize) -> "$hours час"
            preFastFastNumberIsEquals(hoursArray, 2, hoursArrSize, true) ||
                    preFastFastNumberIsEquals(hoursArray, 3, hoursArrSize, true) ||
                    preFastFastNumberIsEquals(hoursArray, 4, hoursArrSize, true)
            -> "$hours часа"

            else -> "$hours часов"

        }

    } else {

        val minutes = seconds / 60;
        val minutesArray = minutes.toString().toCharArray()
        val minutesArrSize = minutesArray.size
        return when {
            preFastFastNumberIsEquals(minutesArray, 1, minutesArrSize) -> "$minutes минуту"
            preFastFastNumberIsEquals(minutesArray, 2, minutesArrSize, true) ||
                    preFastFastNumberIsEquals(minutesArray, 3, minutesArrSize, true) ||
                    preFastFastNumberIsEquals(minutesArray, 4, minutesArrSize, true)
            -> "$minutes минуты"

            else -> "$minutes минут"
        }
    }
}

fun preFastFastNumberIsEquals(
    array: CharArray,
    number: Int,
    arrSize: Int,
    ignoreTheSameNumbers: Boolean = false
): Boolean {
    val fastN = array[arrSize - 1].digitToInt();
    val preFastN = array[arrSize - 1].digitToInt();
    val firstN = array[0].digitToInt();
    return if (arrSize > 1) (if (ignoreTheSameNumbers) ((firstN == number && preFastN == number) ||
            (fastN == number && firstN != 1)) else fastN == number && firstN != number) else firstN == number

}
