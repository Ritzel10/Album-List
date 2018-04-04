package pl.edu.pwr.nr238367.albumlist

import org.joda.time.DateTime
import org.joda.time.Years
import java.util.*

class Person(var firstName: String, var lastName: String, var birthday: Date = Calendar.getInstance().time, var dayOfDeath: Date? = null) {

    val fullName: String
        get() = "$firstName $lastName"

    val isDead: Boolean
        get() = dayOfDeath != null

    private fun birthdayIsValid(): Boolean {
        val birthday = DateTime(birthday)
        return birthday.isBeforeNow
    }

    fun calculateAge(): Int {
        require(birthdayIsValid())
        val current = if(dayOfDeath == null) DateTime(Calendar.getInstance()) else DateTime(dayOfDeath)
        val birthday = DateTime(birthday)
        return Years.yearsBetween(birthday, current).years
    }

}
