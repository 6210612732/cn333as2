package com.example.cn333_as2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class NoteAdapter(private val items: Array<String>, val context: Context): RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTextValue!!.text = items[position]
        holder.itemView.setOnClickListener{
            var intent = Intent(context,EditNote::class.java)
            intent.putExtra("count",(position+1).toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }



}

class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val bindTextValue: TextView? = itemView.findViewById(R.id.n_title)

}
/*
*
* inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val bindTextValue: TextView? = itemView.findViewById(R.id.n_title)

    init {
        itemView.setOnClickListener{
            //val context = holder.title.context
            //val intent = Intent(this@NoteAdapter,AddNote::class.java)
            //intent.putExtra("count","2")
            //startActivity(intent)
            context.startActivity(Intent(context,AddNote::class.java))
        }
    }
}*/