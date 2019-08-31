package com.example.awspolly.network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodoService : Application(){
    private val baseURL ="https://goldenticket.ga"
    //internal var progressDialog: AppCompatDialog? = null

    lateinit var todoApi: TodoApi

    companion object{
        lateinit var instance: TodoService
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()
    }

    //Retrofit 객체 생성
    private fun buildNetwork() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //Retrofit 객체 활성화
        todoApi = retrofit.create(TodoApi::class.java)
    }
}