package com.example.cn333_as2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AddNote : AppCompatActivity() {
    var back_bt: Button? = null
    var save_bt: Button? = null
    var title_text: EditText? = null
    var body_text: EditText? = null
    var testshow: TextView? = null
    var a: String = "txt_title1"
    lateinit var shared : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        var count: Int = intent.getStringExtra("count").toString().toInt()
        shared = getSharedPreferences("Test" , Context.MODE_PRIVATE)

        back_bt = findViewById(R.id.back_bt) as Button
        back_bt!!.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        save_bt = findViewById(R.id.save_bt) as Button
        save_bt!!.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            title_text = findViewById(R.id.title_text) as EditText
            body_text = findViewById(R.id.body_text) as EditText


            var title: String = title_text!!.text.toString()
            var body: String = body_text!!.text.toString()


            val edit = shared.edit()
            edit.putString("txt_title$count" , title)
            edit.putString("txt_body$count" , body)
            edit.apply()

            startActivity(intent)
        }
    }


}
