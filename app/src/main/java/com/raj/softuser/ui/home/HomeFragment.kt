package com.raj.softuser.ui.home

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raj.softuser.Adapter.StudentAdapter
import com.raj.softuser.R
import com.raj.softuser.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val adapter = context?.let { StudentAdapter(it) }
        binding.rvStudents.layoutManager = LinearLayoutManager(context)
        binding.rvStudents.adapter = adapter
        return binding.root
    }
}