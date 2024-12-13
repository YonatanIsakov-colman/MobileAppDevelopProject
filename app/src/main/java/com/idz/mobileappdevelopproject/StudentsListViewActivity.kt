package com.idz.mobileappdevelopproject

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idz.mobileappdevelopproject.Model.Model
import com.idz.mobileappdevelopproject.Model.Student
import com.idz.mobileappdevelopproject.adapter.StudentsAdapter

class StudentsListViewActivity : AppCompatActivity() {
    var  students: MutableList<Student> ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // TODO: 1. Create StudentsListViewActivity --> DONE
        // TODO: 2. Set LAUNCHER --> DONE
        // todo: 3. Set layout in xml
        // TODO: 4. Implement adapter
         students = Model.shared.students
        val listView:ListView = findViewById(R.id.students_list_activity_ListView);
        listView.adapter = StudentsAdapter(students)
    }


}