package vp.videoplayer.mvvm.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(resultsItem: com.example.mock_assignment1.DataClasses.Address) {
        itemView.tvAuthor.text="\""+resultsItem.city+"\""
        itemView.tvQuotes.text="~ "+resultsItem.addressString
    }
}