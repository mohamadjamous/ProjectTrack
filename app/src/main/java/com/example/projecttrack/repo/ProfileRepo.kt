package com.example.projecttrack.repo

import com.example.projecttrack.domain.TeamDomain

class ProfileRepo {



    val myTeamItems: MutableList<TeamDomain> = mutableListOf(

        TeamDomain("Food App Application", "Project in Progress"),
        TeamDomain("AI Python", "Completed"),
        TeamDomain("Weather App Backend", "Project in Progress"),
        TeamDomain("Kotlin developers", "Completed")
    )


    val archiveItems: MutableList<String> = mutableListOf(
        "UI/UX ScreenShot",
        "Kotlin Source Code",
        "Source Codes"
    )
}