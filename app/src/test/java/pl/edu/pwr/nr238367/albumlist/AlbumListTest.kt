package pl.edu.pwr.nr238367.albumlist

import junit.framework.Assert.assertEquals
import org.junit.Test


class AlbumListTest {
    @Test
    fun albumListIsInitialized(){
        assertEquals(true, AlbumList.albumList.size > 0)
    }
}