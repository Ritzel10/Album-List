package pl.edu.pwr.nr238367.albumlist

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView


class AlbumImageAdapter(private val context: Context, private val images:List<String>):BaseAdapter() {

    // create a new ImageView for each item referenced by the Adapter
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageView: ImageView
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = ImageView(context)
            imageView.layoutParams = ViewGroup.LayoutParams(300, 300)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8, 8, 8, 8)
        } else {
            imageView = convertView as ImageView
        }
        imageView.setImageResource(context.resources.getIdentifier(images[position],"drawable",context.packageName))
        return imageView
    }
    override fun getCount(): Int {
        return images.size
    }
    //we can ignore these next two methods
    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0L
    }


}