package pl.edu.pwr.nr238367.albumlist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_people_list.*


/**
 * A simple [Fragment] subclass.
 * Use the [PeopleListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PeopleListFragment : Fragment() {

    private var albumId: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            albumId = arguments.getInt(ARG_ALBUM_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_people_list, container, false)
    }
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.adapter = PeopleListAdapter(context, AlbumList.albumList[albumId].artists)
    }



    companion object {

        private val ARG_ALBUM_ID = "album_id"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param albumId Album id.
         * @return A new instance of fragment PeopleListFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(albumId: Int): PeopleListFragment {
            val fragment = PeopleListFragment()
            val args = Bundle()
            args.putInt(ARG_ALBUM_ID, albumId)
            fragment.arguments = args
            return fragment
        }
    }
}
