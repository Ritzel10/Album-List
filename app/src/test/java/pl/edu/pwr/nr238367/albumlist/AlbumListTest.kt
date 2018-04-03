package pl.edu.pwr.nr238367.albumlist

import org.junit.Test

/**
 * Created by Marcin on 31.03.2018.
 */
class AlbumListTest {
    @Test
    fun albumListIsInitialized(){
        assert(AlbumList.albumList.size > 0)
    }
}