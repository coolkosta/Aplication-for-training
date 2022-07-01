package com.coolkosta.aplicationfortraning

import android.app.Activity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.coolkosta.aplicationfortraning.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val editTextLauncher = registerForActivityResult(StartActivityForResult()) {
     result: ActivityResult -> if (result.resultCode == Activity.RESULT_OK) {
         val intent = result.data

    }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

    }
}