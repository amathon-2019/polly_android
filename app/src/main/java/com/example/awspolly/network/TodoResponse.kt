package com.example.awspolly.network

import com.google.gson.annotations.SerializedName

data class TodoResponse(
    @SerializedName("english_name")
    val englishName: String
)