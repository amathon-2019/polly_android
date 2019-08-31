package com.example.awspolly.ui

import android.annotation.SuppressLint
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
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity() {

    val networkService: TodoApi by lazy {
        TodoService.instance.todoApi
    }

    private lateinit var tickerAdapter: ItemRecyclerViewAdapter
    private lateinit var todoDataList: ArrayList<TodoListItem>

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cal = Calendar.getInstance()
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        val date: Date = df.parse("2019-07-04T12:30:30+0530")
        cal.time = date

        Log.d("tag","current: ${df.format(cal.time)}")

        cal.add(Calendar.YEAR, 1)
        cal.add(Calendar.MONTH, 2)
        cal.add(Calendar.DATE, 3)
        cal.add(Calendar.HOUR_OF_DAY, 1)
        cal.add(Calendar.MINUTE, 20)
        cal.add(Calendar.SECOND, 10)





        todoDataList = ArrayList()



        todoDataList = arrayListOf(
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 1
            ),
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 0
            ),
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 0
            ),
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 0
            ),
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 1
            ),
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 0
            ),
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 0
            ),
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 0
            ),
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 0
            ),
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 0
            ),
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 0
            ),
            TodoListItem(
                "라이언 무지 어파치", "돌리고", 0
            ),
            TodoListItem(
                "일정 2", "돌리고", 0
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

        //todoListReponse()

        fb_create.onClick {
            Log.v("hi", "hello")
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
