package com.sanjidmaybe.digidokan.views.starter

import androidx.navigation.fragment.findNavController
import com.sanjidmaybe.digidokan.R
import com.sanjidmaybe.digidokan.base.BaseFragment
import com.sanjidmaybe.digidokan.databinding.FragmentStartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {


    override fun setListener() {

        with(binding){

            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }

            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_registerFragment)
            }
        }

    }

    override fun allObserver() {

    }

}