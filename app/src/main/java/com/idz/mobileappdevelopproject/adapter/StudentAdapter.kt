package com.idz.mobileappdevelopproject.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.idz.mobileappdevelopproject.Model.Student;
import com.idz.mobileappdevelopproject.R

class StudentsAdapter(private val students: MutableList<Student>?): BaseAdapter(){
    override fun getCount(): Int {
        return students?.size?:0;
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflator = LayoutInflater.from(parent?.context)

        val view = convertView ?:inflator.inflate(R.layout.student_list_row,parent,false).apply {
            findViewById<CheckBox>(R.id.student_row_check_box).apply {
                setOnClickListener{ view ->
                    (tag as? Int)?.let{ tag ->
                        val student = students?.get(tag)
                        student?.isChecked = (view as? CheckBox)?.isChecked ?: false
                    }
                }
            }
        }
        val nameTextView: TextView?= view?.findViewById(R.id.student_row_name_text_view)
        val idTextView:TextView?= view?.findViewById(R.id.student_row_id_text_view)
        val studentCheckBox: CheckBox?= view?.findViewById(R.id.student_row_check_box)

        val student = students?.get(position)
        nameTextView?.text = student?.name
        idTextView?.text = student?.id
        studentCheckBox?.apply {
            isChecked = student?.isChecked ?: false
            tag = position
        }

        return view!!;
    }

}