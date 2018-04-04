package pl.edu.pwr.nr238367.albumlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_album_info.*

class AlbumInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val albumId = intent.extras.getInt(getString(R.string.EXTRA_ALBUM_ID))
        setTheme(getThemeFromGenre(AlbumList.albumList[albumId].genreInfo))
        setContentView(R.layout.activity_album_info)

        showAlbumInfo(albumId)
        viewpager.adapter = AlbumInfoFragmentPagerAdapter(supportFragmentManager, baseContext ,albumId)
        sliding_tabs.setupWithViewPager(viewpager)
        toolbar?.title = ""
        setSupportActionBar(toolbar)
        toolbar?.setNavigationOnClickListener {
            onBackPressed()
        }
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

    private fun getThemeFromGenre(genre: Genre): Int {
        return when (genre) {
            Genre.ROCK -> R.style.AlbumInfoThemeRock
            Genre.RAP -> R.style.AlbumInfoThemeRap
            Genre.JAZZ -> R.style.AlbumInfoThemeJazz
            Genre.POP -> R.style.AlbumInfoThemePop
            Genre.SOUL -> R.style.AlbumInfoThemeSoul
            Genre.OTHER -> R.style.AlbumInfoTheme
        }
    }
}
