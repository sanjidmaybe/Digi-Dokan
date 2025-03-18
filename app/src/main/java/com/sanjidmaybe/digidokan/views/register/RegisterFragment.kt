package com.sanjidmaybe.digidokan.views.register

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sanjidmaybe.digidokan.R
import com.sanjidmaybe.digidokan.base.BaseFragment
import com.sanjidmaybe.digidokan.core.DataState
import com.sanjidmaybe.digidokan.data.models.UserRegister
import com.sanjidmaybe.digidokan.databinding.FragmentRegisterBinding
import com.sanjidmaybe.digidokan.isEmpty
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {


    private val viewModel: RegistrationViewModel by viewModels()

    override fun setListener() {

        with(binding){
            btnLogin.setOnClickListener {
                etName.isEmpty()
                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()){

                    val user = UserRegister(
                        etName.text.toString(),
                        etEmail.text.toString(),
                        etPassword.text.toString(),
                        "Seller",
                        ""
                    )
                    viewModel.userRegistration(user)
                    //Toast.makeText(context, "All input Done!",Toast.LENGTH_LONG).show()
                }
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }
    }

    override fun allObserver() {

        registrationObserver()
    }

    private fun registrationObserver() {
        viewModel.registrationResponse.observe(viewLifecycleOwner){
            when(it){
                is DataState.Error -> {
                    loading.dismiss()
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    loading.show()
                    Toast.makeText(context, "Loading.", Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    loading.dismiss()
                    Toast.makeText(context, "Created : ${it.data}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}