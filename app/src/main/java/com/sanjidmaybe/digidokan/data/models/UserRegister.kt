package com.sanjidmaybe.digidokan.data.models


data class UserRegister(
    val name: String,
    val email: String,
    val password: String,
    val userType: String,
    val userId: String
)
