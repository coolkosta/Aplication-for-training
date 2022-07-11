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
import com.coolkosta.aplicationfortraning.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: GeneralViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        viewModel.stateMessages.observe(
            activity as LifecycleOwner,
            Observer {
                binding.firstFragmentTextView.text = viewModel.stateMessages.value?.firstFragment
            })

        binding.buttonForSendActivity.setOnClickListener {
            viewModel.messageForActivity("Hello from Fragment 1")
        }
        binding.buttonForSendFragment.setOnClickListener {
            viewModel.messageFromFirstFragment("Hello from Fragment 1 to Fragment 2")
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()

    }
}