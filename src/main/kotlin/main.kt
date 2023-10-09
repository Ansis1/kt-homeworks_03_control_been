package ru.netology

fun main() {
    var seconds = 1
    System.out.format("%s%15s%10s", "10", "100", "11")
    System.out.println()

    do {

        println(agoToText(seconds)) // m: ${seconds / 60}")
        seconds += 60
    } while (seconds < 60 * 60)
/*
    do {
        println(agoToText(seconds)) // H: ${(seconds / 60) / 60}")
        seconds += 60 * 60
    } while (seconds < 60 * 60 * 24)

    do {
        println(agoToText(seconds)) // D: ${((seconds / 60) / 60) / 24}")
        seconds += 60 * 60 * 24
    } while (seconds < 60 * 60 * 24 * 4)*/

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
            preFastFastNumberIsEquals( 1) -> "$hours час"
            preFastFastNumberIsEquals( 2) ||
                    preFastFastNumberIsEquals( 3) ||
                    preFastFastNumberIsEquals( 4)
            -> "$hours часа"

            else -> "$hours часов"

        }

    } else {

        val minutes = seconds / 60;
        System.out.format("%5s%10d%10s%5s", minutes % 10, minutes % 100, minutes % 11, "  ")
        return when {
            preFastFastNumberIsEquals( 1) -> "$minutes минуту"
            preFastFastNumberIsEquals( 2) ||
                    preFastFastNumberIsEquals( 3) ||
                    preFastFastNumberIsEquals( 4 )
            -> "$minutes минуты"

            else -> "$minutes минут"
        }
    }
}

fun preFastFastNumberIsEquals(
    number: Int,
    numberEq: Int = 2,
    ): Boolean {

    val firstN = number % 10
    val secondN = number % 100

    return if (number > 9){

        when{
            firstN == numberEq && secondN == numberEq || secondN == numberEq -> true
            secondN == numberEq && firstN != numberEq -> true
            else -> firstN == numberEq

        }

    }else {
        true
    }
}
