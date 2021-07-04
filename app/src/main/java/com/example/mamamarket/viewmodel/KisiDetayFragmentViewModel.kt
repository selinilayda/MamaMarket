package com.example.mamamarket.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KisiDetayFragmentViewModel: ViewModel() {
    var mailLiveData = MutableLiveData<String> ()
    var phoneNumberLiveData = MutableLiveData<String> ()
    var fullNameLiveData = MutableLiveData<String> ()

    init{

    }
}