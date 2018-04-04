package pl.edu.pwr.nr238367.albumlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var albumList = AlbumList.albumList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        viewManager = LinearLayoutManager(this)
        viewAdapter = AlbumAdapter(albumList)
        recyclerView = albumListView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        addDividersBetweenElements()
        deleteElementsOnSwipe()

    }

    private fun onElementSwiped(viewHolder: RecyclerView.ViewHolder?) {
        viewHolder?.let {
            albumList.removeAt(viewHolder.adapterPosition)
            viewAdapter.notifyDataSetChanged()
        }
    }

    private fun deleteElementsOnSwipe() {
        val onSwipeCallback = object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT ){
            override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
                onElementSwiped(viewHolder)
            }

        }
        val itemSwipeHelper = ItemTouchHelper(onSwipeCallback)
        itemSwipeHelper.attachToRecyclerView(recyclerView)
    }

    private fun addDividersBetweenElements() {
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, (viewManager as LinearLayoutManager).orientation))
    }
}
