package com.sanjidmaybe.digidokan.services

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.sanjidmaybe.digidokan.data.models.UserLogin
import com.sanjidmaybe.digidokan.data.models.UserRegister

interface AuthService {

    fun userRegistration(user: UserRegister) : Task<AuthResult>
    fun userLogin(user: UserLogin) : Task<AuthResult>
    fun createUser(user: UserRegister) : Task<Void>
}