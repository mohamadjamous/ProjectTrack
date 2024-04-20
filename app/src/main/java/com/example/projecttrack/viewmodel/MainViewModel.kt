package com.example.projecttrack.viewmodel

import androidx.lifecycle.ViewModel
import com.example.projecttrack.repo.MainRepo

class MainViewModel(val repo: MainRepo): ViewModel() {

    constructor() : this(MainRepo())

    fun loadData() = repo.items
}