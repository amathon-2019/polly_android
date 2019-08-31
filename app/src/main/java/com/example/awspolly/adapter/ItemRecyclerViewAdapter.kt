package com.example.awspolly.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.awspolly.R
import com.example.awspolly.data.TodoListItem

class ItemRecyclerViewAdapter(val dataList: ArrayList<TodoListItem>) : RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recyclerview_main_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    fun setData(setDataList: List<TodoListItem>) {
        this.dataList.clear()
        this.dataList.addAll(setDataList)
        this.notifyDataSetChanged()
    }

}