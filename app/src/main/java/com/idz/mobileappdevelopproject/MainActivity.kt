package com.idz.mobileappdevelopproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    var blueFragment:BlueFragment?=null;

    private var fragmentOne: StudentsListFragment? = null
    private var fragmentTwo: BlueFragment? = null
    private var fragmentThree: BlueFragment? = null
    private var fragmentFour: BlueFragment? = null
    private var buttonOne: Button? = null
    private var buttonTwo: Button? = null
    private var buttonThree: Button? = null
    private var buttonFour: Button? = null
    private var inDisplayFragment: Fragment? = null
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
        fragmentOne = StudentsListFragment()
        fragmentTwo = BlueFragment.newInstance("2️⃣")
        fragmentThree = BlueFragment.newInstance("3️⃣")
        fragmentFour = BlueFragment.newInstance("4️⃣")
        buttonOne = findViewById(R.id.main_activity_button_one)
        buttonTwo = findViewById(R.id.main_activity_button_two)
        buttonThree = findViewById(R.id.main_activity_button_three)
        buttonFour = findViewById(R.id.main_activity_button_four)
        buttonOne?.setOnClickListener {
            display(fragmentOne)
        }
        buttonTwo?.setOnClickListener {
            display(fragmentTwo)
        }
        buttonThree?.setOnClickListener {
            display(fragmentThree)
        }
        buttonFour?.setOnClickListener {
            display(fragmentFour)
        }
        display(fragmentOne)
        }
    private fun display(fragment: Fragment?) {
        fragment?.let {
            supportFragmentManager.beginTransaction().apply {
                if (it != inDisplayFragment) {
                    add(R.id.main_activity_frame_layout, it)
                    inDisplayFragment?.let {
                        remove(it)
                    }
                    addToBackStack("TAG")
                    commit()
                }
                inDisplayFragment = fragment
            }
        }
    }

    private fun removeFragment() {
        blueFragment?.let {
            //supportFragmentManager.popBackStack("BlueFragmentTag",FragmentManager.POP_BACK_STACK_INCLUSIVE)

            supportFragmentManager.beginTransaction().apply {
                    remove(it)
                    .commit()
            }
        }
        blueFragment = null
    }

    private fun addFragment() {
        blueFragment = BlueFragment.newInstance("this is my text ♥")

        blueFragment?.let{
            supportFragmentManager.beginTransaction().apply {
                addToBackStack("BlueFragmentTag")
                .add(R.id.main_activity_frame_layout, it)
                .commit()
            }
        }
    }
}