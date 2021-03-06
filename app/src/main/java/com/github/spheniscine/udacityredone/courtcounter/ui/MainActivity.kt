package com.github.spheniscine.udacityredone.courtcounter.ui

import android.os.Bundle
import com.github.spheniscine.udacityredone.courtcounter.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindText(team_a_score, vm.scoreTeamA_ld)
        bindText(team_b_score, vm.scoreTeamB_ld)
        
        bindClick(addOneForTeamA, vm::addOneForTeamA)
        bindClick(addTwoForTeamA, vm::addTwoForTeamA)
        bindClick(addThreeForTeamA, vm::addThreeForTeamA)

        bindClick(addOneForTeamB, vm::addOneForTeamB)
        bindClick(addTwoForTeamB, vm::addTwoForTeamB)
        bindClick(addThreeForTeamB, vm::addThreeForTeamB)

        bindClick(resetScore, vm::resetScore)
    }
}
