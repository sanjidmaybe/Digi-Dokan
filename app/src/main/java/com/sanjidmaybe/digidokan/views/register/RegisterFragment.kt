package com.sanjidmaybe.digidokan.views.register


import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sanjidmaybe.digidokan.R
import com.sanjidmaybe.digidokan.base.BaseFragment
import com.sanjidmaybe.digidokan.core.DataState
import com.sanjidmaybe.digidokan.data.models.UserRegister
import com.sanjidmaybe.digidokan.databinding.FragmentRegisterBinding
import com.sanjidmaybe.digidokan.isEmpty
import com.sanjidmaybe.digidokan.views.dashboard.seller.SellerDashboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: RegistrationViewModel by viewModels ()


    override fun setListener() {

        with (binding) {
            btnRegister.setOnClickListener {

                etName.isEmpty()
                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()) {
//                    Toast.makeText(context, "Register Done!", Toast.LENGTH_SHORT).show()
                    val user = UserRegister(
                        etName.text.toString(),
                        etEmail.text.toString(),
                        etPassword.text.toString(),
                        userType = "Seller",
                        userId = ""
                    )
                    viewModel.userRegistration(user)
                }
            }
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }
    }

    override fun allObserver() {
        registrationObserver()
    }

    fun registrationObserver() {

        viewModel.registrationResponse.observe (viewLifecycleOwner){
            when(it){
                is DataState.Error<*> -> {
                    loading.dismiss()
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading<*> -> {
                    loading.show()
                    Toast.makeText(context, "Loading.", Toast.LENGTH_SHORT).show()
                }
                is DataState.Success<*> -> {
                    loading.dismiss()
                    Toast.makeText(context, "created User: ${it.data}", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(requireContext(), SellerDashboard::class.java))
                    requireActivity().finish()
                }
            }
        }

    }

}