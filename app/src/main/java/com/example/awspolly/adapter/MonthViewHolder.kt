package com.example.awspolly.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.awspolly.R
import com.example.awspolly.data.PhotoListItem
import com.example.awspolly.data.TodoListItem
import kotlinx.android.synthetic.main.month_view_item.view.*
import kotlinx.android.synthetic.main.photo_view_item.view.*
import kotlinx.android.synthetic.main.week_view_item.view.*
import org.w3c.dom.Text

class MonthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var textView: TextView? = itemView.month_text

    fun bind(item: String) {
        textView?.setText(item)
    }
}