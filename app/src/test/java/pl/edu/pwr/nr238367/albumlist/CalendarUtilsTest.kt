package pl.edu.pwr.nr238367.albumlist

import org.junit.Test
import java.util.*


class CalendarUtilsTest {
    @Test(expected = IllegalArgumentException::class)
    fun forInvalidDateShouldThrowException() {
        Calendar.getInstance().createDate(32, 13, 1900)
    }
}