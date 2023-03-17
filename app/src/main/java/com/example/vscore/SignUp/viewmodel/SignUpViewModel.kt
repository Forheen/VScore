package com.example.vscore.SignUp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.vscore.SignUp.model.SignUpRequestModel
import com.example.vscore.SignUp.model.SignUpResponseModel
import com.example.vscore.SignUp.respository.SignUpRepository

class SignUpViewModel(): ViewModel() {

    private val repository = SignUpRepository()
    val showProgress: LiveData<Boolean>
    val errorMessage: LiveData<String>
    val registerResponseMutableLiveData: LiveData<SignUpResponseModel>


    init {
        this.showProgress = repository.showProgress
        this.errorMessage = repository.errorMessage
        this.registerResponseMutableLiveData = repository.signUpResponseMutableLiveData
    }

    fun callRegisterApi(url:String,signUpRequestModel: SignUpRequestModel) {
        repository.registerApiCall(url,signUpRequestModel)
    }

}