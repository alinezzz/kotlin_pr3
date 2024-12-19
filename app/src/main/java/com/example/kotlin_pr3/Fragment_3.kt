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
import com.example.kotlin_pr3.viewmodels.ViewModel_3
import com.example.kotlin_pr3.databinding.Fragment3Binding

class Fragment_3 : Fragment() {

    private lateinit var binding: Fragment3Binding
    private  lateinit var viewModel: ViewModel_3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater,container,false)

        viewModel = ViewModelProvider(this).get(ViewModel_3::class.java)

        binding.imageView.setOnClickListener {
            viewModel.toggleImage()
        }

        viewModel._currentImage.observe(viewLifecycleOwner, Observer { data ->
            binding.imageView.setImageResource(data)

        })
        binding.buttonFr3ToFr2API.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            Fragment_3().apply {
                arguments = Bundle().apply {
                }
            }
    }
}