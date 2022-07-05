package com.coolkosta.aplicationfortraning

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coolkosta.aplicationfortraning.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var text: Text

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater).also { setContentView(it.root) }
        text = intent.getParcelableExtra(EXTRA_OPTIONS)!!
        binding.fieldEditText.setText(text.message)
        binding.saveButton.setOnClickListener { onSavedPressed() }
    }

    private fun onSavedPressed() {
        val editText = binding.fieldEditText.text.toString()
        text = text.copy(message = editText)
        val intent = Intent()
        intent.putExtra(EXTRA_OPTIONS, text)
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