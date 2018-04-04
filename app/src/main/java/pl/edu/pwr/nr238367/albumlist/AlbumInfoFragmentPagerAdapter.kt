package pl.edu.pwr.nr238367.albumlist

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class AlbumInfoFragmentPagerAdapter(fragmentManager: FragmentManager, context: Context, private val albumId:Int):FragmentPagerAdapter(fragmentManager) {
    private val PAGE_TITLES = arrayOf(context.getString(R.string.tab1_title), context.getString(R.string.tab2_title))
    override fun getItem(position: Int): Fragment {
        return if(position == 0){
            GalleryFragment.newInstance(AlbumList.albumList[albumId].photos)
        }
        else{
            PeopleListFragment.newInstance(albumId)
        }
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence {
        return PAGE_TITLES[position]
    }

    companion object {
        private const val PAGE_COUNT = 2
    }
}