package com.raj.softuser.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.raj.softuser.Database
import com.raj.softuser.Model.Student
import com.raj.softuser.R
import com.raj.softuser.databinding.FragmentDashboardBinding
import org.w3c.dom.Text

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var gender: RadioButton
    private var position : Int? = null
    private var studentList = Database().returnStudent()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        binding = FragmentDashboardBinding.inflate(inflater)

//        position = arguments?.getInt("position")
//        if (position != null){
//            val student = studentList[position!!]
//            binding.btnAddStudent.text = "UPDATE"
//            binding.etName.setText(student.studentName)
//            binding.etAge.setText(student.studentAge.toString())
//            binding.etAddress.setText(student.studentAddress)
//            binding.etImageUrl.setText(student.profileImage)
//            if (student.studentGender =="Male"){
//                binding.rdoMale.isSelected = true
//            }
//            else if (student.studentGender == "Female"){
//                binding.rdoFemale.isSelected = true
//            }
//            else{
//                binding.rdoOther.isSelected = true
//            }
//        }

        binding.btnAddStudent.setOnClickListener {
//            if (binding.btnAddStudent.text == "ADD STUDENT"){
            if (validation()) {
                val genderId = binding.radioGroup.checkedRadioButtonId
                gender = root.findViewById(genderId)
                Database().appendStudent(
                    Student(
                        binding.etName.text.toString(),
                        binding.etAge.text.toString().toInt(),
                        gender.text.toString(),
                        binding.etAddress.text.toString(),
                        binding.etImageUrl.text.toString()
                    )
                )
                Toast.makeText(context, "Student Added", Toast.LENGTH_LONG).show()
                clear()
            }
//            }
//            else{
//                val genderId = binding.radioGroup.checkedRadioButtonId
//                gender = root.findViewById(genderId)
//                Database().editStudent(
//                    Student(
//                        binding.etName.text.toString(),
//                        binding.etAge.text.toString().toInt(),
//                        gender.text.toString(),
//                        binding.etAddress.text.toString(),
//                        binding.etImageUrl.text.toString()
//                    ),
//                    position!!
//                )
//                binding.btnAddStudent.text = "ADD STUDENT"
//            }
        }
        return binding.root
    }
    private fun clear(){
        binding.etName.setText("")
        binding.etAge.setText("")
        binding.etAddress.setText("")
        binding.etImageUrl.setText("")
        binding.radioGroup.clearCheck()
        binding.rdoMale.isChecked = true
        binding.etName.requestFocus()
    }
    private fun validation():Boolean{
        var flag = true
        if (TextUtils.isEmpty(binding.etName.text)){
            binding.etName.error = "Please Enter Student Name"
            binding.etName.requestFocus()
            flag = false
        }
        else if (TextUtils.isEmpty(binding.etAddress.text)){
            binding.etAddress.error = "Please Enter Student Name"
            binding.etAddress.requestFocus()
            flag = false
        }
        else if (TextUtils.isEmpty(binding.etAge.text)){
            binding.etAge.error = "Please Enter Student Name"
            binding.etAge.requestFocus()
            flag = false
        }
        else if (TextUtils.isEmpty(binding.etImageUrl.text)){
            binding.etImageUrl.error = "Please Enter Student Name"
            binding.etImageUrl.requestFocus()
            flag = false
        }
        return flag
    }
}