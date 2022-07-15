package com.example.internshippractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internshippractice.databinding.ActivityDBinding

class D : AppCompatActivity() {

    private lateinit var binding : ActivityDBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}