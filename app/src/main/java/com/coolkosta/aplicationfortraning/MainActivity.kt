package com.coolkosta.aplicationfortraning


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coolkosta.aplicationfortraning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonForNewActivityWithTwoFragment.setOnClickListener {
            startNewActivity(TwoFragmentsActivity::class.java)
        }
    }

    private fun startNewActivity(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
    }

}