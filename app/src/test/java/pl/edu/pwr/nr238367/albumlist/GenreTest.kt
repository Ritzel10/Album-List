package pl.edu.pwr.nr238367.albumlist

import junit.framework.Assert.assertEquals
import org.junit.Test


class GenreTest {
    @Test
    fun forValidStringShouldReturnCorrectGenre() {
        assertEquals(Genre.ROCK, genreFromString("rock"))
        assertEquals(Genre.JAZZ, genreFromString("jazz"))
    }
}