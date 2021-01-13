package com.raj.softuser

import com.raj.softuser.Model.Student

private var studentList = arrayListOf<Student>()
class Database {
    fun appendStudent(student: Student){
        studentList.add(student)
    }
    fun returnStudent(): ArrayList<Student>{
        return studentList
    }
    fun deleteStudent(student: Student){
        studentList.remove(student)
    }
}