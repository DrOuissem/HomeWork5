package com.example.homework5

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_layout.view.*

class MyAdapter  (var context: Context,  var listfood:ArrayList<Food>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v);
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        /*
         holder.im.setImageResource(img[position])
          holder.t1.text = text1[position]
          holder.t2.text = text2[position]
          holder.itemView.name.text = blist[position].name
         */
        /* holder.itemView.playout.tv1.text = text1[position]
         holder.itemView.playout.tv2.text = text2[position]
         holder.itemView.playout.imageView.setImageResource(img[position])*/
        holder.itemView.playout.apply {
            name.text = listfood[position].name
            //tv2.text = text2[position]
            imageView.setImageResource(listfood[position].image)
        }
        holder.itemView.playout.setOnClickListener{
            val intent = Intent(context, ShowDetailsActivity::class.java)
            var res = listfood[position].name
            Toast.makeText(context," $res clicked", Toast.LENGTH_LONG).show()
            intent.putExtra("image", listfood[position].image)
            intent.putExtra("name", listfood[position].name)
            intent.putExtra("recipe",listfood[position].recipe)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listfood.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}