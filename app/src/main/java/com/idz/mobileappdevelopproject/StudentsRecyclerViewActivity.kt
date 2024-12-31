package com.idz.mobileappdevelopproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.idz.mobileappdevelopproject.Model.Model
import com.idz.mobileappdevelopproject.Model.Student
import com.idz.mobileappdevelopproject.adapter.StudentsRecyclerAdapter

interface OnItemClickListener{
    fun onItemClick(position:Int)
    fun onItemClick(student:Student?)
}

class StudentsRecyclerViewActivity : AppCompatActivity() {
    var  students: MutableList<Student> ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        students = Model.shared.students

        val recyclerView: RecyclerView = findViewById(R.id.students_recycler_view)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = StudentsRecyclerAdapter(students)
        adapter.listener = object:OnItemClickListener{
            override fun onItemClick(position: Int) {
                Log.d("TAG" , "On click Activity listener on position $position ")
            }

            override fun onItemClick(student: Student?) {
                Log.d("TAG" , "On Student clicked name:  ${student?.name} ")

            }

        }
        recyclerView.adapter = adapter
    }



}