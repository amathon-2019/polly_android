package com.example.awspolly.data

import java.util.*

data class TodoListItem(
    var content: String,
    var todoDate: String,
    var viewType: Int,
    var color: String = "#fe8c8c"
)