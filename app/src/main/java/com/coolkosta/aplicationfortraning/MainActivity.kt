package com.coolkosta.aplicationfortraning

import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.coolkosta.aplicationfortraning.databinding.ActivityMainBinding
import kotlinx.parcelize.Parcelize


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var state: State

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.text = getString(R.string.tap)
        binding.button.setOnClickListener { tapped() }

        state = savedInstanceState?.getParcelable(KEY) ?: State(
            0,
            text = "tap on button"
        )
        render()


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY, state)
    }


    private fun render() = with(binding) {
        textView.text = state.text
    }


    private fun tapped() {
        state.count++
        state.text = "U tapped on button ${state.count} times"
        render()
    }

    @Parcelize
    data class State(var count: Int, var text: String) : Parcelable

    companion object {
        @JvmStatic
        private val KEY = "KEY"
    }
}