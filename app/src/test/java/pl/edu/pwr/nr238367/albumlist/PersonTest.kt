package pl.edu.pwr.nr238367.albumlist

import junit.framework.Assert.assertEquals
import org.junit.Test
import java.util.*


class PersonTest {
    @Test
    fun forValidBirthdayShouldReturnValidAge() {
        val calendar = Calendar.getInstance()
        calendar.set(1996, 2, 12)
        val date = calendar.time
        val person = Person("", "", date)
        assertEquals(22, person.calculateAge())
    }

    @Test(expected = IllegalArgumentException::class)
    fun forInvalidBirthdayShouldThrowException() {
        val calendar = Calendar.getInstance()
        calendar.set(2300, 2, 12)
        val date = calendar.time
        val person = Person("", "", date)
        person.calculateAge()
    }

    @Test
    fun validFullName() {
        val person = Person("John", "Smith")
        assertEquals("John Smith", person.fullName)
    }

    @Test
    fun forNullDayOfDeathShouldReturnFalse() {
        val person = Person("John", "Smith")
        assertEquals(false, person.isDead)
    }

    @Test
    fun forNonNullDayOfDeathShouldReturnTrue() {
        val birthday = Calendar.getInstance().createDate(10, 10, 1945)
        val dayOfDeath = Calendar.getInstance().createDate(22, 12, 2010)
        val person = Person("John", "Smith", birthday, dayOfDeath)
        assertEquals(true, person.isDead)
    }

}