package com.example.internshippractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internshippractice.databinding.ActivityC2Binding
import com.example.internshippractice.databinding.ActivityCBinding

class C2 : AppCompatActivity() {
    private lateinit var binding: ActivityC2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityC2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOk.setOnClickListener { returnResult() }
        binding.btnCanceled.setOnClickListener { returnResult(false) }
    }

    private fun returnResult(result : Boolean = true){
        val returnIntent = Intent()
        if(result){
            setResult(Activity.RESULT_OK, returnIntent)
        }else{
            setResult(Activity.RESULT_CANCELED, returnIntent)
        }
        finish()

    }
}