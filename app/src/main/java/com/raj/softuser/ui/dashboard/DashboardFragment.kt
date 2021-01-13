package com.raj.softuser.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        binding.btnAddStudent.setOnClickListener {
            val genderId = binding.radioGroup.checkedRadioButtonId
            Database().appendStudent(
                Student(
                    binding.etName.text.toString(),
                    binding.etAge.text.toString().toInt(),
                    gender,
                    binding.etAddress.text.toString(),
                    binding.etImageUrl.text.toString()
                )
            )
        }
        return binding.root
    }
}