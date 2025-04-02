package com.sanjidmaybe.digidokan.views.starter

import android.content.Intent
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.sanjidmaybe.digidokan.R
import com.sanjidmaybe.digidokan.base.BaseFragment
import com.sanjidmaybe.digidokan.databinding.FragmentStartBinding
import com.sanjidmaybe.digidokan.views.dashboard.seller.SellerDashboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding :: inflate) {

    override fun setListener() {

        setUpAutoLogin()

        with (binding){

            btnLogin.setOnClickListener {

                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }
            btnRegister.setOnClickListener {

                findNavController().navigate(R.id.action_startFragment_to_registerFragment)
            }

        }

    }

    private fun setUpAutoLogin() {

        FirebaseAuth.getInstance().currentUser?.let {

            startActivity(Intent(requireContext(), SellerDashboard::class.java))
            requireActivity().finish()
        }

    }

    override fun allObserver() {

    }



}