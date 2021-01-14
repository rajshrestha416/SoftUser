package com.raj.softuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.bumptech.glide.Glide
import com.raj.softuser.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load("https://agilenepal.org/wp-content/uploads/2018/11/softwarica.png")
            .into(binding.imageView)

        binding.btnLogin.setOnClickListener{
            if (validate()){
                if (binding.etPassword.text.toString() == "coventry" &&
                    binding.etUsername.text.toString() == "softwarica"){
                    startActivity(Intent(this,MainActivity::class.java))
                }
                else{
                    binding.etUsername.error = "Username or Password is incorrect"
                }
            }
        }
    }
    private fun validate():Boolean{
        var flag = true
        if(TextUtils.isEmpty(binding.etPassword.text)){
            binding.etPassword.error = "Please, enter password"
            binding.etPassword.requestFocus()
            flag = false
        }
        else if(TextUtils.isEmpty(binding.etUsername.text)){
            binding.etUsername.error = "Please, enter username"
            binding.etUsername.requestFocus()
            flag = false
        }
        return flag
    }
}