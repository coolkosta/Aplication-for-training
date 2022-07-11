package com.coolkosta.aplicationfortraning.fragments.twofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.coolkosta.aplicationfortraning.data.GeneralViewModel
import com.coolkosta.aplicationfortraning.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val viewModel: GeneralViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        viewModel.stateMessages.observe(
            activity as LifecycleOwner,
            Observer {
                binding.secondFragmentTextView.text = viewModel.stateMessages.value?.secondFragment
            })
        binding.buttonForSendActivity.setOnClickListener {
            viewModel.messageForActivity("Hello from Fragment 2")
        }

        binding.buttonForSendFragment.setOnClickListener {
            viewModel.messageFromSecondFragment("Hello to Fragment 1 from Fragment 2")
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = SecondFragment()

    }
}