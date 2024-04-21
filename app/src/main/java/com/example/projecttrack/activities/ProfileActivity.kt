package com.example.projecttrack.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projecttrack.R
import com.example.projecttrack.adapters.ArchiveAdapter
import com.example.projecttrack.adapters.MyTeamAdapter
import com.example.projecttrack.databinding.ActivityProfileBinding
import com.example.projecttrack.viewmodel.ProfileViewModel

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            val myTeamAdapter by lazy { MyTeamAdapter(profileViewModel.loadDataMyTeam()) }

            viewTeam.apply {
                adapter = myTeamAdapter
                layoutManager = LinearLayoutManager(this@ProfileActivity, LinearLayoutManager.VERTICAL, false
                )
            }


            val archiveAdapter by lazy { ArchiveAdapter(profileViewModel.loadDataArchive()) }

            viewArchives.apply {
                adapter = archiveAdapter
                layoutManager = LinearLayoutManager(this@ProfileActivity,
                    LinearLayoutManager.HORIZONTAL, false
                )
            }
        }
    }
}