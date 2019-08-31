package com.example.awspolly.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.awspolly.R
import com.example.awspolly.data.PhotoListItem
import com.example.awspolly.data.TodoListItem
import kotlinx.android.synthetic.main.photo_view_item.view.*
import org.w3c.dom.Text

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var photo: ImageView? = itemView.photo
    var text: TextView? = itemView.photo_text

    fun bind(item: PhotoListItem) {
        photo?.setImageBitmap(item.photo)
        text?.setText(item.text)
    }
}