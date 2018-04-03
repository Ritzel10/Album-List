package pl.edu.pwr.nr238367.albumlist


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_album.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop

class AlbumAdapter(private val dataSet: List<Album>) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.ViewHolder{
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_album,parent,false)
        val holder = ViewHolder(view)
        view.setOnClickListener {
            parent.context.startActivity(parent.context.intentFor<AlbumInfoActivity>(parent.context.getString(R.string.EXTRA_ALBUM_ID) to holder.adapterPosition).singleTop())
        }

        return holder
    }

    override fun getItemCount(): Int  = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rowView = holder.rowView
        val album = dataSet[position]
        rowView.albumName.text = album.albumName
        rowView.artistName.text = album.artistName
        if(album.photos.isNotEmpty()){
            val coverArtId = rowView.context.resources.getIdentifier(album.photos[0],"drawable", rowView.context.packageName)
            rowView.albumCoverSmall.setImageResource( coverArtId)
        }


    }

    class ViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)

}