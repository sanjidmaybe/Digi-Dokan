package com.sanjidmaybe.digidokan.views.register

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanjidmaybe.digidokan.core.DataState
import com.sanjidmaybe.digidokan.data.models.UserRegister
import com.sanjidmaybe.digidokan.data.repositories.AuthRepository

class RegistrationViewModel : ViewModel() {

    private val _registrationResponse = MutableLiveData<DataState<UserRegister>>()
    val registrationResponse : LiveData<DataState<UserRegister>> = _registrationResponse


    fun userRegistration(user : UserRegister){
        _registrationResponse.postValue(DataState.Loading())
        val authService = AuthRepository()
        authService.userRegistration(user).addOnSuccessListener {

            _registrationResponse.postValue(DataState.Success(user))
        }.addOnFailureListener {error ->

            _registrationResponse.postValue(DataState.Error("${error.message}"))
        }
    }
}