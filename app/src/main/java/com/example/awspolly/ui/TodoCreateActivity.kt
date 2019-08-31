package com.example.awspolly.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.awspolly.R
import com.example.awspolly.data.DBHandler
import com.example.awspolly.network.TodoApi
import com.example.awspolly.network.TodoResponse
import com.example.awspolly.network.TodoService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_todo_create.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoCreateActivity : AppCompatActivity() {

    val networkService: TodoApi by lazy {
        TodoService.instance.todoApi
    }

    companion object{
        lateinit var dbHandler: DBHandler
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_create)


        bt_update.onClick {
            //createResponse()
        }
    }

    private fun createResponse() {
        val putTodoResponse = networkService.putTodo()
        putTodoResponse.enqueue(object : Callback<TodoResponse> {
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