package com.sanjidmaybe.digidokan.data.repositories

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.sanjidmaybe.digidokan.data.models.UserLogin
import com.sanjidmaybe.digidokan.data.models.UserRegister
import com.sanjidmaybe.digidokan.services.AuthService
import javax.inject.Inject

class AuthRepository @Inject constructor(private val sAuth: FirebaseAuth): AuthService {
    override fun userRegistration(user: UserRegister) : Task<AuthResult> {

        return sAuth.createUserWithEmailAndPassword(user.email, user.password)
    }

    override fun userLogin(user: UserLogin) : Task<AuthResult> {

        return sAuth.signInWithEmailAndPassword(user.email, user.password)

    }
}