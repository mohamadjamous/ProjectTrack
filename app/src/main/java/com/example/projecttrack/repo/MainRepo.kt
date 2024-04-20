package com.example.projecttrack.repo

import com.example.projecttrack.domain.OnGoingDomain

class MainRepo {


    val items = listOf(

        OnGoingDomain("Food App", "June 12, 2024", 50, "ongoing1"),
        OnGoingDomain("AI Recording", "June 26, 2023", 60, "ongoing2"),
        OnGoingDomain("Weather App", "June 12, 2024", 25, "ongoing3"),
        OnGoingDomain("E-Book App", "June 12, 2024", 80, "ongoing4")
    )
}