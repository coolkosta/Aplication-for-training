package com.coolkosta.aplicationfortraning.fragments.unlimitedfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.coolkosta.aplicationfortraning.R
import com.coolkosta.aplicationfortraning.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(inflater, container, false)
        binding.counterTextView.text = getString(R.string.screen_label, getCounterValue())
        binding.launchNextButton.setOnClickListener { launchNext() }
        binding.goBackButton.setOnClickListener { goBack() }

        return binding.root
    }

    private fun launchNext() {
        val fragment = CounterFragment.newInstance(count = getCounterValue() + 1)
        parentFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun goBack() {
        requireActivity().onBackPressed()
    }

    private fun getCounterValue(): Int = requireArguments().getInt(ARG_COUNT)

    companion object {

        private const val ARG_COUNT = "ARG_COUNT"

        @JvmStatic
        fun newInstance(count: Int): CounterFragment {
            val arguments = Bundle().apply {
                putInt(ARG_COUNT, count)
            }
            val fragment = CounterFragment()
            fragment.arguments = arguments
            return fragment

        }
    }
}