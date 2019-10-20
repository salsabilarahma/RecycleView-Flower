package com.example.flowerrecycleview

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class RecycleViewAdapter(private val context: Context, private val items: List<Item>):RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    )=ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

        override fun onBindViewHolder(holder: RecycleViewAdapter.ViewHolder, position: Int) {
            holder.bindItem(items[position])
    }

        override fun getItemCount(): Int = items.size

        class ViewHolder(view: View):RecyclerView.ViewHolder(view){
            private val name = view.findViewById<TextView>(R.id.name)
            private val image = view.findViewById<ImageView>(R.id.image)

            fun bindItem(items: Item){
                name.text = items.name
                items.image?.let { Picasso.get().load(it).fit().into(image) }
            }

        }
}