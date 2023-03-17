package com.example.vscore.Organizer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.vscore.Organizer.model.CheckResponseModel
import com.example.vscore.Organizer.model.CodeResponseModel
import com.example.vscore.Organizer.repository.RoomRepository

class RoomViewModel():ViewModel() {
    private val repository = RoomRepository()
    val showProgress: LiveData<Boolean>
    val errorMessage: LiveData<String>
    val codeResponseMutableLiveData: LiveData<CodeResponseModel>
    val checkResponseMutableLiveData: LiveData<CheckResponseModel>


    init {
        this.showProgress = repository.showProgress
        this.errorMessage = repository.errorMessage
        this.codeResponseMutableLiveData = repository.codeResponseMutableLiveData
        this.checkResponseMutableLiveData = repository.checkResponseMutableLiveData
    }

    fun callCodeApi(id:String?) {
        repository.codeApiCall(id)
    }

    fun callCheckApi(code:String?) {
        repository.checkApiCall(code)
    }
}