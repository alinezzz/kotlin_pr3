package com.example.kotlin_pr3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlin_pr3.viewmodels.ViewModel_1
import com.example.kotlin_pr3.R
import com.example.kotlin_pr3.databinding.Fragment1Binding


class Fragment_1 : Fragment() {
    private lateinit var viewModel: ViewModel_1
    private lateinit var binding: Fragment1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Создание экземпляра класса Fragment1Binding и связывание его с разметкой фрагмента
        binding = Fragment1Binding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ViewModel_1::class.java)


        binding.imageView.setOnClickListener {
            viewModel.toggleImage()
        }
        viewModel._currentImage.observe(viewLifecycleOwner,
            Observer {data ->
                binding.imageView.setImageResource(data)

            })

        binding.buttonFr1ToFr2API.setOnClickListener {
            findNavController().navigate(R.id.action_Fragment1_to_Fragment2)
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            Fragment_1().apply {
                arguments = Bundle().apply {

                }
            }
    }
}