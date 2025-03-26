package com.sanjidmaybe.digidokan.views.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sanjidmaybe.digidokan.R
import com.sanjidmaybe.digidokan.databinding.FragmentRegisterBinding
import com.sanjidmaybe.digidokan.isEmpty

class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        setListener()
        return binding.root
    }

    private fun setListener() {

        with (binding) {
            btnRegister.setOnClickListener {

                etName.isEmpty()
                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()) {
                    Toast.makeText(context, "Register Done!", Toast.LENGTH_SHORT).show()
                }
            }
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }
    }


}