package com.raj.softuser.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.raj.softuser.Database
import com.raj.softuser.Model.Student
import com.raj.softuser.R
import com.raj.softuser.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var gender: RadioButton

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        binding = FragmentDashboardBinding.inflate(inflater)
//        val intent = root.intent.get
        binding.btnAddStudent.setOnClickListener {
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
            clear()
        }
        return binding.root
    }
    private fun clear(){
        binding.etName.setText("")
        binding.etAge.setText("")
        binding.etAddress.setText("")
        binding.etImageUrl.setText("")
        binding.radioGroup.clearCheck()
    }
}