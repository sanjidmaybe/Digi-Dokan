package com.sanjidmaybe.digidokan.views.dashboard.seller

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.sanjidmaybe.digidokan.R
import com.sanjidmaybe.digidokan.databinding.ActivitySellerDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SellerDashboard : AppCompatActivity() {
    private lateinit var binding: ActivitySellerDashboardBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySellerDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragmentContainerView)
        val appBarConfig = AppBarConfiguration(setOf(
            R.id.product,
            R.id.add,
            R.id.profile

        ))
        binding.bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfig)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}