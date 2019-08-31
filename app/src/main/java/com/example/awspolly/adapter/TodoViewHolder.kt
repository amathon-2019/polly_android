package com.example.awspolly.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.awspolly.data.TodoListItem
import kotlinx.android.synthetic.main.todo_view_item.view.*

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var todoText: TextView? = itemView.todo_text

    fun bind(item: TodoListItem) {
        todoText?.text = item.content
    }
}