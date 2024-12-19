package com.example.kotlin_pr3.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_pr3.R

class ViewModel_3:ViewModel() {
    val _currentImage = MutableLiveData<Int>(R.drawable.winter3)
    private var imageChanged = false

    fun toggleImage() {
        if (!imageChanged) {
            _currentImage.value = R.drawable.summer3
            imageChanged = true
        } else {
            _currentImage.value = R.drawable.winter3
            imageChanged = false
        }
    }
}