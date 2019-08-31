package com.example.awspolly.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.awspolly.R
import com.example.awspolly.data.TodoListItem

class ItemRecyclerViewAdapter(val dataList: ArrayList<TodoListItem>) : RecyclerView.Adapter<TodoViewHolder>() {
    private lateinit var context:Context

    private val PHOTO_VIEW_TYPE = 1
    private val TODO_VIEW_TYPE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        context = parent.context


        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recyclerview_main_item,
                parent,
                false
            )
        )
    }


    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    fun setData(setDataList: List<TodoListItem>) {
        this.dataList.clear()
        this.dataList.addAll(setDataList)
        this.notifyDataSetChanged()
    }

}