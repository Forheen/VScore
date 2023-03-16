package com.example.vscore.Login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.vscore.Login.model.SignInRequestModel
import com.example.vscore.Login.respository.LoginRepository
import com.example.vscore.SignUp.model.SignUpResponseModel

class LoginViewModel() : ViewModel() {

    private val repository = LoginRepository()
    val showProgress: LiveData<Boolean>
    val errorMessage: LiveData<String>
    val loginResponseMutableLiveData: LiveData<SignUpResponseModel>


    init {
        this.showProgress = repository.showProgress
        this.errorMessage = repository.errorMessage
        this.loginResponseMutableLiveData = repository.signUpResponseMutableLiveData
    }

    fun callLoginApi(signInRequestModel: SignInRequestModel) {
        repository.loginApiCall(signInRequestModel)
    }

}
