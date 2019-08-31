package com.example.awspolly

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var tvContent = itemView.findViewById(R.id.tv_todo) as TextView
    var tvDate = itemView.findViewById(R.id.tv_date) as TextView

    fun bind(item: TodoListItem) {
        tvContent.text = item.content
        tvDate.text = item.todoDate
    }
}