package com.coolkosta.aplicationfortraning

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.coolkosta.aplicationfortraning.data.Options
import com.coolkosta.aplicationfortraning.databinding.ActivityOptionsBinding

class OptionsActivity : BaseActivity() {

    private lateinit var binding: ActivityOptionsBinding
    private lateinit var options: Options


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionsBinding.inflate(layoutInflater).also { setContentView(it.root) }
        options = savedInstanceState?.getParcelable(KEY_OPTIONS) ?: intent.getParcelableExtra(
            EXTRA_OPTIONS
        ) ?: throw IllegalArgumentException("Need specify EXTRA_OPTIONS for this Activity.")

        binding.currentNumberTextView.text = "Текущее сохраненное число ${options.number}"

        binding.saveButton.setOnClickListener { onSavedPressed() }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_OPTIONS, options)
    }

    private fun onSavedPressed() {
        val savedNumber = binding.numberEditText.text.toString().toInt()
        options = options.copy(number = savedNumber)
        val intent = Intent()
        intent.putExtra(EXTRA_OPTIONS, options)
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
        private const val KEY_OPTIONS = "KEY_OPTIONS"
    }

}