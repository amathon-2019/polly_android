package com.example.awspolly.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.awspolly.R
import com.example.awspolly.data.TodoListItem

class ItemRecyclerViewAdapter(val dataList: ArrayList<TodoListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var context:Context

    private val PHOTO_VIEW_TYPE = 1
    private val TODO_VIEW_TYPE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context


        return if (viewType == PHOTO_VIEW_TYPE) {
            PhotoViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.photo_view_item,
                    parent,
                    false
                )
            )
        } else {
            TodoViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.todo_view_item,
                    parent,
                    false
                )
            )
        }
    }


    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            PHOTO_VIEW_TYPE
        } else {
            TODO_VIEW_TYPE
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)

        if (viewType == PHOTO_VIEW_TYPE) {
            holder as PhotoViewHolder
//            holder.bind()

        } else {
            holder as TodoViewHolder
            holder.bind(dataList[position])
        }
    }


    fun setData(setDataList: List<TodoListItem>) {
        this.dataList.clear()
        this.dataList.addAll(setDataList)
        this.notifyDataSetChanged()
    }

}