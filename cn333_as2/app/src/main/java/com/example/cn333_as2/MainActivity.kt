package com.example.cn333_as2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var note_title: Array<String> = arrayOf()
    var note_body: Array<String> = arrayOf()
    var count = 0
    lateinit var shared : SharedPreferences

    var add_button: Button? = null
    var recycler_note: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shared = getSharedPreferences("Test" , Context.MODE_PRIVATE)

        var i = 1
        var st = shared.getString("txt_title$i" , "-1" ).toString()

        while(st.equals("-1") != true){
            count+=1
            add(st)
            i+=1
            st = shared.getString("txt_title$i" , "-1" ).toString()
        }

        recycler_note = findViewById<RecyclerView>(R.id.recycler_note)
        recycler_note!!.layoutManager = LinearLayoutManager(this)
        val itemAdapter = NoteAdapter(note_title,this)
        recycler_note!!.adapter = itemAdapter

        /*itemAdapter.setOnItemClickListener(object : NoteAdapter.onItemClickListener){

            override fun onItemClick(position: Int){
                val intent = Intent(this@MainActivity,AddNote::class.java)
                intent.putExtra("count",(count+1).toString())
                startActivity(intent)
            }
        }*/




        add_button = findViewById(R.id.newNote) as Button

        add_button!!.setOnClickListener{
            val intent = Intent(this,AddNote::class.java)
            intent.putExtra("count",(count+1).toString())
            startActivity(intent)
        }
    }


    fun add(input: String) {
        note_title += input
    }
    fun add2(input: String) {
        note_body += input
    }
}