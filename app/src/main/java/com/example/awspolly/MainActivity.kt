package com.example.awspolly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.coroutines.channels.ticker
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tickerAdapter: ItemRecyclerViewAdapter
    private lateinit var todoDataList: ArrayList<TodoListItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoDataList = ArrayList()
        todoDataList.add(
            TodoListItem(
                "라이언", "120"
            )
        )
        todoDataList.add(
            TodoListItem(
                "라이언", "아니야"
            )
        )
        todoDataList.add(
            TodoListItem(
                "라이언", "뭐지"
            )
        )
        todoDataList.add(
            TodoListItem(
                "라이언", "필요없어"
            )
        )
        todoDataList.add(
            TodoListItem(
                "라이언", "잘했어"
            )
        )
        todoDataList.add(
            TodoListItem(
                "튜브 프로도 네오", "으싸으싸"
            )
        )
        todoDataList.add(
            TodoListItem(
                "라이언 어파치 튜브", "만세"
            )
        )
        todoDataList.add(
            TodoListItem(
                "라이언 무지 어파치", "돌리고"
            )
        )

        tickerAdapter = ItemRecyclerViewAdapter(todoDataList)

        //activity는 this fragment는 context
        recyclerView_main.adapter = ItemRecyclerViewAdapter(todoDataList)
        recyclerView_main.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        //tickerAdapter.setData(todoDataList)

        fb_create.onClick {
            Log.v("hi", "hello")
            //startActivity<TodoCreateActivity>()
            todoDataList.clear()
            tickerAdapter.notifyDataSetChanged()
//            todoDataList.add(
//                TodoListItem(
//                    "aaaaa", "120"
//                )
//            )
//            todoDataList.add(
//                TodoListItem(
//                    "라이aaa언", "아니야"
//                )
//            )
//
//
//            todoDataList.addAll(todoDataList)
//            tickerAdapter.notifyDataSetChanged()
         }
    }
}
