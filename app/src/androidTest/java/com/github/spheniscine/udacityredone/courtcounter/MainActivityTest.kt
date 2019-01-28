package com.github.spheniscine.udacityredone.courtcounter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread
import androidx.test.rule.ActivityTestRule
import com.github.spheniscine.udacityredone.courtcounter.ui.MainActivity
import com.github.spheniscine.udacityredone.courtcounter.ui.MainViewModel
import com.github.spheniscine.udacityredone.courtcounter.util.MutableLiveData
import com.github.spheniscine.udacityredone.courtcounter.util.setTo
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.loadKoinModules

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var mockVm: MainViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        loadKoinModules(module(override = true) { viewModel { mockVm } })

        every {mockVm.scoreTeamA_ld} returns MutableLiveData(0)
        every {mockVm.scoreTeamB_ld} returns MutableLiveData(0)

        activityTestRule.launchActivity(null)
    }

    @Test
    fun scoreTeamA_changes_whenViewModelSet() {
        runOnUiThread { mockVm.scoreTeamA_ld setTo 55 }
        assertDisplayed(R.id.team_a_score, "55")

    }
}