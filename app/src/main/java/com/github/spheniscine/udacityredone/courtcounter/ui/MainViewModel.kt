package com.github.spheniscine.udacityredone.courtcounter.ui

import androidx.lifecycle.ViewModel
import com.github.spheniscine.udacityredone.courtcounter.util.MutableLiveData
import com.github.spheniscine.udacityredone.courtcounter.util.delegate

open class MainViewModel : ViewModel() {
    open val scoreTeamA_ld = MutableLiveData(0)
    open var scoreTeamA by scoreTeamA_ld.delegate()

    open val scoreTeamB_ld = MutableLiveData(0)
    open var scoreTeamB by scoreTeamB_ld.delegate()

    open fun addOneForTeamA() { scoreTeamA += 1 }
    open fun addTwoForTeamA() { scoreTeamA += 2 }
    open fun addThreeForTeamA() { scoreTeamA += 3 }

    open fun addOneForTeamB() { scoreTeamB += 1 }
    open fun addTwoForTeamB() { scoreTeamB += 2 }
    open fun addThreeForTeamB() { scoreTeamB += 3 }

    open fun resetScore() {
        scoreTeamA = 0
        scoreTeamB = 0
    }
}