package com.example.kotlin_pr3.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_pr3.R

class ViewModel_2: ViewModel() {
    val _currentImage = MutableLiveData<Int>(R.drawable.winter2)
    private var imageChanged = false

    fun toggleImage() {
        if (!imageChanged) {
            _currentImage.value = R.drawable.summer2
            imageChanged = true
        } else {
            _currentImage.value = R.drawable.winter2
            imageChanged = false
        }
    }
}