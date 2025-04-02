package com.sanjidmaybe.digidokan.views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sanjidmaybe.digidokan.R
import com.sanjidmaybe.digidokan.base.BaseFragment
import com.sanjidmaybe.digidokan.core.DataState
import com.sanjidmaybe.digidokan.data.models.UserLogin
import com.sanjidmaybe.digidokan.databinding.FragmentLoginBinding
import com.sanjidmaybe.digidokan.isEmpty
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel : LoginViewModel by viewModels ()



    override fun setListener() {

        with(binding) {
            btnLogin.setOnClickListener {

                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etEmail.isEmpty() && !etPassword.isEmpty()){
                    val user = UserLogin(
                        etEmail.text.toString(),
                        etPassword.text.toString()
                    )
                    viewModel.userLogin(user)
                }
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
    }

    override fun allObserver() {
        loginObserver()
    }

    private fun loginObserver() {
        viewModel.loginResponse.observe (viewLifecycleOwner){
            when (it) {
                is DataState.Error<*> -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading<*> -> {
                    Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
                }
                is DataState.Success<*> -> {
                    Toast.makeText(context, "Logged in : ${it.data}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}