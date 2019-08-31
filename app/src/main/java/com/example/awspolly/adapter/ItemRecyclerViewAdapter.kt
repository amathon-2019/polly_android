package com.example.awspolly.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.awspolly.R
import com.example.awspolly.data.TodoListItem
import java.time.Month

class ItemRecyclerViewAdapter(val dataList: ArrayList<TodoListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var context:Context

    private val TODO_VIEW_TYPE = 0
    private val MONTH_VIEW_TYPE = 1
    private val WEEK_VIEW_TYPE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context


        return if (viewType == MONTH_VIEW_TYPE) {
            MonthViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.month_view_item,
                    parent,
                    false
                )
            )
        } else if (viewType == WEEK_VIEW_TYPE) {
            WeekViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.week_view_item,
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
        return dataList[position].viewType
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)

        if (viewType == MONTH_VIEW_TYPE) {
            holder as MonthViewHolder
        } else if (viewType == WEEK_VIEW_TYPE) {
            holder as WeekViewHolder
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