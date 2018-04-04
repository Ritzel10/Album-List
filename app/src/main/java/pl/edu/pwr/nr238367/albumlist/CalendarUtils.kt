package pl.edu.pwr.nr238367.albumlist

import java.util.*

fun Calendar.createDate(day: Int, month: Int, year: Int): Date {
    try {
        this.apply {
            isLenient = false
            set(Calendar.DAY_OF_MONTH, day)
            set(Calendar.MONTH, month - 1)
            set(Calendar.YEAR, year)
        }
        return this.time
    } catch (e: ArrayIndexOutOfBoundsException) {
        throw IllegalArgumentException()
    }
}
