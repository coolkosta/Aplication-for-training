package com.coolkosta.aplicationfortraning

import android.content.Intent
import android.os.Bundle
import com.coolkosta.aplicationfortraning.data.Options
import com.coolkosta.aplicationfortraning.databinding.ActivityOpenBoxBinding

class OpenBoxActivity : BaseActivity() {

    private lateinit var binding: ActivityOpenBoxBinding
    private lateinit var options: Options

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenBoxBinding.inflate(layoutInflater).also { setContentView(it.root) }

        options = intent?.getParcelableExtra(
            EXTRA_OPTIONS
        ) ?: throw IllegalArgumentException("Need specify EXTRA_OPTIONS for this Activity.")

        binding.resultTextView.text = "Задано число ${options.number}"
        binding.checkButton.setOnClickListener { onCheckBoxPressed() }


    }


    private fun onCheckBoxPressed() {
        val intent = Intent(this, EvenNumberActivity::class.java)
        intent.putExtra(EvenNumberActivity.EXTRA_OPTIONS, options)
        startActivity(intent)


    }

    companion object {
        const val EXTRA_OPTIONS = "EXTRA_OPTIONS"
    }
}