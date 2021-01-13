package com.raj.softuser.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raj.softuser.Database
import com.raj.softuser.R
import com.raj.softuser.ui.dashboard.DashboardFragment
import de.hdodenhof.circleimageview.CircleImageView

private var database = Database()
private var studentList = database.returnStudent()
class StudentAdapter(
    val context: Context
):RecyclerView.Adapter<StudentAdapter.StudentHolder>(){
    class StudentHolder(view: View): RecyclerView.ViewHolder(view){
        val imgProfile: CircleImageView
        val tvName: TextView
        val tvAddress: TextView
        val tvAge: TextView
        val tvGender: TextView
        val btnEdit:ImageButton
        val btnDelete:ImageButton

        init{
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvAge = view.findViewById(R.id.tvAge)
            tvGender = view.findViewById(R.id.tvGender)
            btnEdit = view.findViewById(R.id.ibEdit)
            btnDelete = view.findViewById(R.id.ibDelete)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_layout,parent,false)
        return StudentHolder(view)
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        val student = studentList[position]
        holder.tvName.text = student.studentName
        holder.tvAddress.text = student.studentAddress
        holder.tvAge.text = student.studentAge.toString()
        holder.tvGender.text = student.studentGender
        Glide.with(context).load(student.profileImage).into(holder.imgProfile)

        holder.btnDelete.setOnClickListener{
            database.deleteStudent(student)
            notifyItemRemoved(position)
        }
        holder.btnEdit.setOnClickListener{
            Intent(context, DashboardFragment::class.java).also {
                it.putExtra("student",student)
                it.putExtra("position",position)
                context.startActivity(it)
            }
        }

    }

    override fun getItemCount(): Int {
        return studentList.size
    }

}

