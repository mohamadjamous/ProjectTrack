package com.example.projecttrack.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projecttrack.R
import com.example.projecttrack.adapters.OngoingAdapter
import com.example.projecttrack.databinding.ActivityMainBinding
import com.example.projecttrack.viewmodel.MainViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationMenuView

class DashboardActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            val ongoingAdapter by lazy { OngoingAdapter(mainViewModel.loadData()) }


            recyclerView.apply {
                layoutManager = GridLayoutManager(this@DashboardActivity, 2)
                adapter = ongoingAdapter

            }

            bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.home -> {
                        // Handle Home item click
                        true
                    }

                    R.id.profile -> {
                        // Handle Dashboard item click
                        startActivity(Intent(this@DashboardActivity, ProfileActivity::class.java))
                        true
                    }

                    else -> false
                }
            }
        }


    }


}