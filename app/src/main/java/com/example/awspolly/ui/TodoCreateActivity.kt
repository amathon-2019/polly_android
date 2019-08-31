package com.example.awspolly.ui

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
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

    var selectedHour:Int = 0
    var selectedMinute:Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_create)

        val currentDate = Calendar.getInstance()

        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        selectedHour = currentDate.get(Calendar.HOUR_OF_DAY)
        selectedMinute = currentDate.get(Calendar.MINUTE)

        val dateStr = "%d년 %02d월 %02d일 %02d:%02d".format(year, month + 1, day, selectedHour, selectedMinute)
        date_pick_button.text = dateStr

        alarm_manager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val my_intent = Intent(this, Alarm_Receiver::class.java)

        confirm_button.setOnClickListener {
            // calendar에 시간 셋팅
            calendar.set(Calendar.HOUR_OF_DAY, selectedHour)
            calendar.set(Calendar.MINUTE, selectedMinute)

            Toast.makeText(
                this,
                "Alarm 예정 " + selectedHour + "시 " + selectedMinute + "분",
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

            finish()
        }

        date_pick_button.onClick {
            val currentDate = Calendar.getInstance()
            val year = currentDate.get(Calendar.YEAR)
            val month = currentDate.get(Calendar.MONTH)
            val day = currentDate.get(Calendar.DAY_OF_MONTH)

            val hour = currentDate.get(Calendar.HOUR_OF_DAY)
            val minute = currentDate.get(Calendar.MINUTE)

//            val datePicker = DatePickerDialog(this@TodoCreateActivity, DatePickerDialog.OnDateSetListener { datePicker, mYear, mMonth, mDay ->
//
//            }, year, month, day)


            val timePicker = TimePickerDialog(this@TodoCreateActivity, TimePickerDialog.OnTimeSetListener { timePicker, mHour, mMinute ->
                val dateStr = "%d년 %02d월 %02d일 %02d:%02d".format(year, month + 1, day, mHour, mMinute)
                date_pick_button.text = dateStr

                selectedHour = mHour
                selectedMinute = mMinute
            }, hour, minute, true)

            timePicker.setTitle("날짜 선택")
            timePicker.show()
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