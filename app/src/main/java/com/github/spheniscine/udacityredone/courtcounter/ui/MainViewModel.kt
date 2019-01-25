package com.github.spheniscine.udacityredone.courtcounter.ui

import androidx.lifecycle.ViewModel
import com.github.spheniscine.udacityredone.courtcounter.AllOpen
import com.github.spheniscine.udacityredone.courtcounter.util.MutableLiveData
import com.github.spheniscine.udacityredone.courtcounter.util.delegate

@AllOpen
class MainViewModel : ViewModel() {
    val scoreTeamA_ld = MutableLiveData(0)
    var scoreTeamA by scoreTeamA_ld.delegate()

    val scoreTeamB_ld = MutableLiveData(0)
    var scoreTeamB by scoreTeamB_ld.delegate()

    fun addOneForTeamA() { scoreTeamA += 1 }
    fun addTwoForTeamA() { scoreTeamA += 2 }
    fun addThreeForTeamA() { scoreTeamA += 3 }

    fun addOneForTeamB() { scoreTeamB += 1 }
    fun addTwoForTeamB() { scoreTeamB += 2 }
    fun addThreeForTeamB() { scoreTeamB += 3 }

    fun resetScore() {
        scoreTeamA = 0
        scoreTeamB = 0
    }
}