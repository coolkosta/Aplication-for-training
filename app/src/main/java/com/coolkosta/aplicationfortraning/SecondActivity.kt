package com.coolkosta.aplicationfortraning

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coolkosta.aplicationfortraning.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var text: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater).also { setContentView(it.root) }
        text = intent.getStringExtra(EXTRA_OPTIONS)!!
        binding.fieldEditText.setText(text)
        binding.saveButton.setOnClickListener { onSavedPressed() }
    }

    private fun onSavedPressed() {
        val editText = binding.fieldEditText.text.toString()
        val intent = Intent()
        intent.putExtra(EXTRA_OPTIONS, editText)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

    companion object {
        const val EXTRA_OPTIONS = "EXTRA_OPTIONS"
    }
}