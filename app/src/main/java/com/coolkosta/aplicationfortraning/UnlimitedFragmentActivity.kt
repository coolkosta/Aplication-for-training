package com.coolkosta.aplicationfortraning

import android.os.Bundle
import com.coolkosta.aplicationfortraning.databinding.ActivtiyUnlimitedFragmentBinding
import com.coolkosta.aplicationfortraning.fragments.unlimitedfragment.CounterFragment

class UnlimitedFragmentActivity : BaseActivity() {

    private lateinit var binding: ActivtiyUnlimitedFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivtiyUnlimitedFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = CounterFragment.newInstance(count = 1)
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit()
        }

    }
}