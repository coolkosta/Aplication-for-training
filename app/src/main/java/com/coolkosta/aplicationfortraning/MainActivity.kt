package com.coolkosta.aplicationfortraning

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.coolkosta.aplicationfortraning.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var text: String


    private val editTextLauncher =
        registerForActivityResult(StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                text = result.data?.getStringExtra(SecondActivity.EXTRA_OPTIONS)!!
                binding.fieldTextView.text = text
            } else {
                Toast.makeText(this, "Текст не сохранен", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        text = savedInstanceState?.getString(TEXT_OPTIONS) ?: TEXT
        binding.fieldTextView.text = text
        binding.changeButton.setOnClickListener { onChangeButtonClicked() }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_OPTIONS, text)
    }

    private fun onChangeButtonClicked() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.EXTRA_OPTIONS, text)
        editTextLauncher.launch(intent)
    }

    companion object {
        private const val TEXT_OPTIONS = "TEXT_OPTIONS"
        private const val TEXT = "Change text in next Activity"
    }
}

