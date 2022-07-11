package com.coolkosta.aplicationfortraning

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.coolkosta.aplicationfortraning.data.GeneralViewModel
import com.coolkosta.aplicationfortraning.databinding.ActivityTwoFragmentsBinding
import com.coolkosta.aplicationfortraning.fragments.twofragments.FirstFragment
import com.coolkosta.aplicationfortraning.fragments.twofragments.SecondFragment

class TwoFragmentsActivity : BaseActivity() {

    private val viewModel: GeneralViewModel by viewModels()
    private lateinit var binding: ActivityTwoFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityTwoFragmentsBinding.inflate(layoutInflater).also { setContentView(it.root) }
        viewModel.initState(
            savedInstanceState?.getParcelable(KEY) ?: GeneralViewModel.Messages(
                "Waiting action from another fragment",
                "Waiting action from another fragment",
                "Waiting action from fragments"
            )
        )
        binding.textViewActivity.text = viewModel.stateMessages.value?.activityMessage!!

        openFrag(R.id.firstFragmentContainer, FirstFragment.newInstance())
        openFrag(R.id.secondFragmentContainer, SecondFragment.newInstance())

        viewModel.stateMessages.observe(this, Observer {
            render(it)
        }
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY, viewModel.stateMessages.value)
    }

    private fun openFrag(idHolder: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, fragment)
            .commit()
    }

    private fun render(state: GeneralViewModel.Messages) {
        binding.textViewActivity.text = state.activityMessage
    }

    companion object {
        private const val KEY = "KEY"
    }


}