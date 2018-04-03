package pl.edu.pwr.nr238367.albumlist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_gallery.*


/**
 * A simple [Fragment] subclass.
 * Use the [GalleryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GalleryFragment : Fragment() {

    private lateinit var drawableIdentifiers: List<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            drawableIdentifiers = arguments.getStringArrayList(ARG_DRAWABLE_IDENTIFIERS)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoGrid.adapter = AlbumImageAdapter(context, drawableIdentifiers)
    }

    companion object {
        // the fragment initialization parameter
        private val ARG_DRAWABLE_IDENTIFIERS = "album_id"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param drawableIdentifiers ArrayList of drawable identifiers
         * @return A new instance of fragment GalleryFragment.
         */

        fun newInstance(drawableIdentifiers:ArrayList<String>): GalleryFragment {
            val fragment = GalleryFragment()
            val args = Bundle()
            args.putStringArrayList(ARG_DRAWABLE_IDENTIFIERS, drawableIdentifiers)
            fragment.arguments = args
            return fragment
        }
    }
}
