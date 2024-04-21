package com.example.projecttrack.viewmodel

import androidx.lifecycle.ViewModel
import com.example.projecttrack.repo.ProfileRepo

class ProfileViewModel(val repo: ProfileRepo) : ViewModel() {

    constructor() : this(ProfileRepo())

    fun loadDataMyTeam() = repo.myTeamItems
    fun loadDataArchive() = repo.archiveItems
}