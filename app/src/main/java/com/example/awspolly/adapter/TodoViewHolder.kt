package com.example.awspolly.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.awspolly.data.TodoListItem
import kotlinx.android.synthetic.main.todo_view_item.view.*

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var todoText: TextView? = itemView.todo_text
    var todoDate: ViewGroup? = itemView.todo_date

    fun bind(item: TodoListItem) {
        todoText?.text = item.content
        todoDate?.visibility = if (item.isShowDate == 1) View.VISIBLE else View.INVISIBLE
    }
}
