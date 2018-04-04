package pl.edu.pwr.nr238367.albumlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.row_people.view.*


class PeopleListAdapter(val context: Context, private val people: List<Person>) : BaseAdapter() {
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return people.size
    }

    override fun getItem(position: Int): Person {
        return people[position]
    }

    override fun getView(position: Int, convertView: View?, container: ViewGroup): View {
        val newConvertView = convertView ?: LayoutInflater.from(context).inflate(R.layout.row_people, container, false)
        val person = getItem(position)
        newConvertView.personName?.text = person.fullName
        try {
            newConvertView.personAge?.text = person.calculateAge().toString()
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }
        if (person.isDead) {
            newConvertView.personImage.setImageResource(R.drawable.ic_rip3)
        }
        return newConvertView
    }

}
