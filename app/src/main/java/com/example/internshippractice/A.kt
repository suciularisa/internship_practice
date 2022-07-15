package com.example.internshippractice

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.internshippractice.databinding.ActivityMainBinding

class A : AppCompatActivity() {

    val activityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ activityResult ->
        registerForResult(activityResult)
    }

    private lateinit var binding: ActivityMainBinding
    private val TAG = "TEST"
    private val RESULT_ACTIVITY_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btnExplicitIntent.setOnClickListener{ explicitIntent() }

        binding.btnImplicitIntent.setOnClickListener{ implicitIntent() }

        binding.btnStartSctivityForResult.setOnClickListener { startActivityForResultBtn() }

        binding.btnRegisterLaunch.setOnClickListener {
            val intent = Intent(baseContext, C2::class.java)
            activityLauncher.launch(intent)
        }
        Log.v(TAG, "onCreate")
    }

    private fun explicitIntent(){
        val intent = Intent(this.baseContext, B::class.java)
        startActivity(intent)
    }

    private fun implicitIntent(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/"))
        startActivity(intent)
    }

    private fun startActivityForResultBtn(){
        val intent = Intent(this.baseContext, C::class.java)
        intent.putExtra("Int", 1)
        intent.putExtra("String", "From activity A ")
        startActivityForResult(intent, RESULT_ACTIVITY_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == RESULT_ACTIVITY_CODE){
            val result = data?.getStringExtra("Result")
            if(resultCode == Activity.RESULT_OK){
                Log.v(TAG, "OK : $result")
            }else if(resultCode == Activity.RESULT_CANCELED){
                Log.v(TAG, "CANCELED : $result")
            }
        }
    }


    private fun registerForResult(activityResult: ActivityResult){
        if(activityResult.resultCode == Activity.RESULT_OK){
            Log.v(TAG,"REGISTER FOR ACTIVITY RESULT: OK")
        }else if(activityResult.resultCode == Activity.RESULT_CANCELED){
            Log.v(TAG,"REGISTER FOR ACTIVITY RESULT: CANCELED")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG, "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy")
    }
}