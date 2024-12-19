package com.example.kotlin_pr3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlin_pr3.R
import com.example.kotlin_pr3.viewmodels.ViewModel_2
import com.example.kotlin_pr3.databinding.Fragment2Binding

class Fragment_2 : Fragment() {
    private lateinit var viewModel: ViewModel_2
    private lateinit var binding: Fragment2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment2Binding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ViewModel_2::class.java)

        binding.imageView.setOnClickListener {
            viewModel.toggleImage()
        }
        viewModel._currentImage.observe(viewLifecycleOwner,
            Observer {data ->
                binding.imageView.setImageResource(data)

            })

        binding.buttonFr2ToFr1API.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.buttonFr2ToFr3API.setOnClickListener {
            findNavController().navigate(R.id.action_Fragment2_to_Fragment3)
        }

        return binding.root
    }

    companion object {

        fun newInstance() =
            Fragment_2().apply {
                arguments = Bundle().apply {
                }
            }
    }
}