package com.example.hw5m3


import SecondFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw5m3.databinding.ActivityMainBinding
import com.example.hw5m3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    var numberOfClick = 0
    var textNumber = 0
    val secondFragment = SecondFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPlus.setOnClickListener {
            textNumber++
            binding.tvText.text = textNumber.toString()
            numberOfClick++
            controlClicks()
        }

        binding.btnMinus.setOnClickListener {
            textNumber--
            binding.tvText.text = textNumber.toString()
            numberOfClick++
            controlClicks()
        }
    }

    private fun controlClicks() {
        if (numberOfClick >= 10) {
            val bundle = Bundle()
            bundle.putString("text", textNumber.toString())
            secondFragment.arguments = bundle

            parentFragmentManager.beginTransaction().apply { replace(R.id.frame, secondFragment).commit() }
        }

    }
}