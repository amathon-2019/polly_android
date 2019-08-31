package com.example.awspolly.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.awspolly.R
import com.example.awspolly.data.TodoListItem
import com.example.awspolly.adapter.ItemRecyclerViewAdapter
import com.example.awspolly.network.TodoApi
import com.example.awspolly.network.TodoResponse
import com.example.awspolly.network.TodoService
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val networkService: TodoApi by lazy {
        TodoService.instance.todoApi
    }

    private lateinit var tickerAdapter: ItemRecyclerViewAdapter
    private lateinit var todoDataList: ArrayList<TodoListItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoDataList = ArrayList()

        todoDataList.add(
            TodoListItem(
                "라이언 무지 어파치", "돌리고"
            )
        )
        tickerAdapter = ItemRecyclerViewAdapter(todoDataList)

        recyclerView_main.adapter = ItemRecyclerViewAdapter(todoDataList)
        recyclerView_main.layoutManager =
            LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
            )

//        todoListReponse()

        fb_create.onClick {
            Log.v("hi", "hello")
            todoDataList.clear()
            tickerAdapter.notifyDataSetChanged()
        }
    }

    private fun todoListReponse() {
        val getTodoResponse = networkService.getTodo()
        getTodoResponse.enqueue(object : Callback<TodoResponse> {
            override fun onFailure(call: Call<TodoResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<TodoResponse>, response: Response<TodoResponse>) {
                when {
                    response.isSuccessful -> {

                    }
                    else -> {
                    }
                }
            }
        })
    }
}
