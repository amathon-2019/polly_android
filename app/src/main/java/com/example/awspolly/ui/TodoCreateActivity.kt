package com.example.awspolly.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.awspolly.R
import com.example.awspolly.network.TodoResponse
import com.example.awspolly.network.TodoService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_todo_create.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class TodoCreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_create)


        bt_update.onClick {
            createResponse()
        }
    }

    private fun createResponse() {


    }
}