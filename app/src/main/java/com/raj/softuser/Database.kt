package com.raj.softuser

import com.raj.softuser.Model.Student

private var studentList = arrayListOf<Student>(
    Student("Raj Shrestha", 20,"Male","Gokarneshwor",
    "https://lh3.googleusercontent.com/ogw/ADGmqu_-Ldk0cIB5iNgtFtxq7Vl5HPkKUWbWV15hZHWVMA=s83-c-mo"),
    Student("Suaj Maharjan", 22,"Male","Kapan",
        "https://scontent.fktm7-1.fna.fbcdn.net/v/t1.0-1/p200x200/90030379_2603253559916935_8214241325738885120_o.jpg?_nc_cat=103&ccb=2&_nc_sid=7206a8&_nc_ohc=PPnSU84w6jMAX8kLjGg&_nc_ht=scontent.fktm7-1.fna&tp=6&oh=629b008fd2f98b445efc1cd110ff1f0d&oe=6024D8C1"),
    Student("Raj Shrestha", 20,"Male","Gokarneshwor",
        "https://lh3.googleusercontent.com/ogw/ADGmqu_-Ldk0cIB5iNgtFtxq7Vl5HPkKUWbWV15hZHWVMA=s83-c-mo"),
)
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
    fun editStudent(student: Student,postion:Int){
        studentList[postion] = student
    }
}