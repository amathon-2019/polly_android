package com.example.awspolly.ui

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.awspolly.R
import com.example.awspolly.data.DBHandler
import com.example.awspolly.network.TodoApi
import com.example.awspolly.network.TodoResponse
import com.example.awspolly.network.TodoService
import com.example.awspolly.service.Alarm_Receiver
import kotlinx.android.synthetic.main.activity_todo_create.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class TodoCreateActivity : AppCompatActivity() {

    val networkService: TodoApi by lazy {
        TodoService.instance.todoApi
    }

    var alarm_manager: AlarmManager? = null
    var alarm_timepicker: TimePicker? = null
    var pendingIntent: PendingIntent? = null
    val calendar = Calendar.getInstance()
    companion object{
        lateinit var dbHandler: DBHandler
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_create)


        alarm_manager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        // 타임피커 설정
        alarm_timepicker = findViewById(R.id.tp_timepicker)

        val my_intent = Intent(this, Alarm_Receiver::class.java)

        confirm_button.setOnClickListener {
            // calendar에 시간 셋팅
            calendar.set(Calendar.HOUR_OF_DAY, tp_timepicker.hour)
            calendar.set(Calendar.MINUTE, tp_timepicker.minute)

            // 시간 가져옴
            val hour = tp_timepicker.hour
            val minute = tp_timepicker.minute
            Toast.makeText(
                this,
                "Alarm 예정 " + hour + "시 " + minute + "분",
                Toast.LENGTH_SHORT
            ).show()

            // reveiver에 string 값 넘겨주기
            my_intent.putExtra("state", "alarm on")

            pendingIntent = PendingIntent.getBroadcast(
                this, 0, my_intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            // 알람셋팅
            alarm_manager!!.set(
                AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
                pendingIntent
            )
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