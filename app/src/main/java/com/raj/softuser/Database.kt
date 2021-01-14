package com.raj.softuser

import com.raj.softuser.Model.Student

private var studentList = arrayListOf<Student>(
    Student("Pratikshya Shrestha", 19,"Female","Sundarijal",
        "https://scontent.fktm7-1.fna.fbcdn.net/v/t1.0-9/69833891_682956532222964_7426496817019224064_n.jpg?_nc_cat=105&ccb=2&_nc_sid=174925&_nc_ohc=F3HU8RYbKfQAX_luN99&_nc_ht=scontent.fktm7-1.fna&oh=82a378ee203ab6b8a1370260af9b462a&oe=60242C64"),
    Student("Ansu Fati", 18,"Male","Spain",
    "https://i.pinimg.com/736x/d3/59/95/d35995ed991f4ac682f68a769983fa9d.jpg"),
    Student("Sujan Maharjan", 22,"Male","Kapan",
        "https://scontent.fktm7-1.fna.fbcdn.net/v/t1.0-1/p200x200/90030379_2603253559916935_8214241325738885120_o.jpg?_nc_cat=103&ccb=2&_nc_sid=7206a8&_nc_ohc=PPnSU84w6jMAX8kLjGg&_nc_ht=scontent.fktm7-1.fna&tp=6&oh=629b008fd2f98b445efc1cd110ff1f0d&oe=6024D8C1")

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