package com.mobapps.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class EditDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_details)
        var back = findViewById<LinearLayout>(R.id.back_arrow_button)

        back.setOnClickListener{
            finish()
        }
    }
}