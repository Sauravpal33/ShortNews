package com.example.shortnews.UI

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shortnews.R
import com.squareup.picasso.Picasso

class MyAdapter(val context : Activity, val newsArrayList : List<Article>) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
         var title : TextView
         var description : TextView
         var image : ImageView

         init {
             title = itemView.findViewById(R.id.titleView)
             description = itemView.findViewById(R.id.descriptionView)
             image = itemView.findViewById(R.id.newsImageView)
         }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        Picasso.get().load(currentItem.urlToImage).into(holder.image)
        holder.itemView.setOnClickListener{
            val intent = Intent(context , detail_activity::class.java)
                intent.putExtra("URL",currentItem.url)
                context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }
}