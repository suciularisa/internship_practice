package com.example.internshippractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internshippractice.databinding.ActivityCBinding
import com.example.internshippractice.databinding.ActivityMainBinding

class C : AppCompatActivity() {

    private lateinit var binding: ActivityCBinding
    private var intFromA : Int = 0
    private var stringFromA : String = "string"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intFromA = intent.getIntExtra("Int", 0)
        if(intent.getStringExtra("String") != null) {
            stringFromA = intent.getStringExtra("String").toString()
        }

        binding.btnOk.setOnClickListener { returnResult() }
        binding.btnCanceled.setOnClickListener { returnResult(false) }

    }

    private fun returnResult(result : Boolean = true){
        val returnIntent = Intent()
        returnIntent.putExtra("Result", "Information returned - $stringFromA & $intFromA")

        if(result){
            setResult(Activity.RESULT_OK, returnIntent)
        }else{
            setResult(Activity.RESULT_CANCELED, returnIntent)
        }
        finish()

    }
}