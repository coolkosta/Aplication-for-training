package com.coolkosta.aplicationfortraning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.coolkosta.aplicationfortraning.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.text = getString(R.string.tap)
        binding.button.setOnClickListener { viewModel.tapped() }

        viewModel.initState(
            savedInstanceState?.getParcelable(KEY) ?: MainActivityViewModel.State(
                count = 0,
                text = "tap on the button"
            )
        )

        viewModel.stateLiveData.observe(this, Observer { render(it) })

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY, viewModel.stateLiveData.value)
    }


    private fun render(state: MainActivityViewModel.State) = with(binding) {
        textView.text = state.text
    }

    companion object {
        @JvmStatic
        private val KEY = "KEY"
    }
}