package com.example.awspolly.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface TodoApi {

    @GET("todo")
    fun getTodo(

    ): Call<TodoResponse>

    @PUT("todo")
    fun putTodo():Call<TodoResponse>

    @POST("todo")
    fun postTodo():Call<TodoResponse>

    @HTTP(method = "DELETE", path = "todo", hasBody = true)
    fun deleteTodo(
        @Header("Content-Type") content_type: String,
        @Header("token") user_token: String,
        @Body body: JsonObject
    ): Call<TodoResponse>
}