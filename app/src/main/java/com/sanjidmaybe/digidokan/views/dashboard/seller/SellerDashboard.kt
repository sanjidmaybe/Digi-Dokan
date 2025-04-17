package com.sanjidmaybe.digidokan.views.dashboard.seller

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import com.sanjidmaybe.digidokan.R
import com.sanjidmaybe.digidokan.databinding.ActivitySellerDashboardBinding
import com.sanjidmaybe.digidokan.views.starter.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SellerDashboard : AppCompatActivity() {
    private lateinit var binding: ActivitySellerDashboardBinding
    private lateinit var navController: NavController

    @Inject
    lateinit var sAuth: FirebaseAuth
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.seller_top_menu, menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.report -> {
                Toast.makeText(this, "report Clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.settings -> {
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.logout -> {
                sAuth.signOut()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }


        }
        return super.onOptionsItemSelected(item)
    }
}