package com.idz.mobileappdevelopproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /*
        TODO: Step 1 - Add Student Button -> DONE!
        TODO: Step 2 - Navigate to AddStudentActivity -> DONE!
        TODO: Step 3 - Create AddStudentActivity -> DONE!
        TODO: Step 4 - Save Student
        */

        val addStudentButton:Button = findViewById(R.id.main_activity_add_student_button)
        addStudentButton.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)

            }
        }
    }