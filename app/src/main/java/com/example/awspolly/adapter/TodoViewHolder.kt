package com.example.awspolly.adapter

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.awspolly.data.TodoListItem
import kotlinx.android.synthetic.main.todo_view_item.view.*
import org.jetbrains.anko.backgroundColor

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var todoText: TextView? = itemView.todo_text
    var colorTag: View? = itemView.color_tag

    fun bind(item: TodoListItem) {
        todoText?.text = item.content
        colorTag?.setBackgroundColor(Color.parseColor(item.color))
    }
}
