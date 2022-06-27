package com.coolkosta.aplicationfortraning

import android.content.Intent
import android.os.Bundle
import com.coolkosta.aplicationfortraning.data.Options
import com.coolkosta.aplicationfortraning.databinding.ActivityEvenNumberBinding

class EvenNumberActivity : BaseActivity() {

    private lateinit var binding: ActivityEvenNumberBinding
    private lateinit var options: Options
    private lateinit var resultText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvenNumberBinding.inflate(layoutInflater).also { setContentView(it.root) }
        options = intent.getParcelableExtra(EXTRA_OPTIONS)
            ?: throw IllegalArgumentException("Need specify EXTRA_OPTIONS for this Activity.")
        resultText = if (options.isEvenNumber) {
            "Число является четным"
        } else "Число является нечетным"

        binding.evenNumberTextView.text = resultText

        binding.mainMenuButton.setOnClickListener { onToMainMenuPressed() }

    }

    private fun onToMainMenuPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)

    }

    companion object {
        const val EXTRA_OPTIONS = "EXTRA_OPTIONS"
    }
}