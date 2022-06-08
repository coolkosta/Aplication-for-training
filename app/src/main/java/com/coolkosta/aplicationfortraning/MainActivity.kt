package com.coolkosta.aplicationfortraning

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

private const val KEY = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button_view)
        textView = findViewById(R.id.numbers_text_view)

        if(savedInstanceState != null) {
            textView.text = savedInstanceState.getString(KEY)
        }

        button.setOnClickListener {
            randomNumbers()
        }
    }

    private fun randomNumbers() {
        textView.text = Random.nextInt(999).toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY, textView.text.toString())
    }


}