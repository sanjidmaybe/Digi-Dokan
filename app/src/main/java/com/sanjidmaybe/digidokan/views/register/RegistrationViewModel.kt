package com.sanjidmaybe.digidokan.views.register

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.sanjidmaybe.digidokan.core.DataState
import com.sanjidmaybe.digidokan.data.models.UserRegister
import com.sanjidmaybe.digidokan.data.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val authService: AuthRepository): ViewModel() {

    private val _registrationResponse = MutableLiveData<DataState<UserRegister>>()
    val registrationResponse : LiveData<DataState<UserRegister>> = _registrationResponse


    fun userRegistration(user : UserRegister){
        _registrationResponse.postValue(DataState.Loading())
        authService.userRegistration(user).addOnSuccessListener {

            _registrationResponse.postValue(DataState.Success(user))
        }.addOnFailureListener {error ->

            _registrationResponse.postValue(DataState.Error("${error.message}"))
        }
    }
}