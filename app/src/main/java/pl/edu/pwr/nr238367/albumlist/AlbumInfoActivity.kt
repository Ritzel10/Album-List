package pl.edu.pwr.nr238367.albumlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_album_info.*

class AlbumInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_info)

        val albumId = intent.extras.getInt(getString(R.string.EXTRA_ALBUM_ID))
        showAlbumInfo(albumId)
        viewpager.adapter = AlbumInfoFragmentPagerAdapter(supportFragmentManager, baseContext ,albumId)
        sliding_tabs.setupWithViewPager(viewpager)
    }
    private fun showAlbumInfo(albumId:Int){
        require(albumId in 0 .. AlbumList.albumList.size)
        val album = AlbumList.albumList[albumId]
        albumTitle.text = album.albumName
        albumArtist.text = album.artistName
        albumGenre.text = album.genreInfo.toString
        if(album.photos.isNotEmpty()){
            albumCoverLarge.setImageResource(applicationContext.resources.getIdentifier(album.photos[0],"drawable",applicationContext.packageName))
        }
    }
}
