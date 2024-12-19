package com.example.kotlin_pr3.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_pr3.R


//хранит данные конкретного компонента

//ViewModel обрабатывает логику, а View фокусируется исключительно на представлении
class ViewModel_1: ViewModel() {
    val _currentImage = MutableLiveData<Int>(R.drawable.winter1) //хранит текущее изображение. И
    private var imageChanged = false

    fun toggleImage() {
        if (!imageChanged) {
            _currentImage.value = R.drawable.summer1
            imageChanged = true
        } else {
            _currentImage.value = R.drawable.winter1
            imageChanged = false
        }
    }

}