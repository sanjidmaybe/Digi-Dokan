package com.sanjidmaybe.digidokan.views.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanjidmaybe.digidokan.core.DataState
import com.sanjidmaybe.digidokan.data.models.UserLogin
import com.sanjidmaybe.digidokan.data.models.UserRegister
import com.sanjidmaybe.digidokan.data.repositories.AuthRepository

class LoginViewModel: ViewModel() {
    private val _loginResponse = MutableLiveData<DataState<UserLogin>>()
    val loginResponse : LiveData<DataState<UserLogin>> = _loginResponse


    fun userLogin(user : UserLogin){
        _loginResponse.postValue(DataState.Loading())
        val authService = AuthRepository()
        authService.userLogin(user).addOnSuccessListener {

            _loginResponse.postValue(DataState.Success(user))
        }.addOnFailureListener {error ->

            _loginResponse.postValue(DataState.Error("${error.message}"))
        }
    }
}