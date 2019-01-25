package com.github.spheniscine.udacityredone.courtcounter

import android.app.Application
import android.content.Context
import com.github.spheniscine.udacityredone.courtcounter.ui.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

fun App.module(): Module {
    val app = this
    return module {
        single { app }
        single<Application> { app }
        single<Context> { app }

        viewModel { MainViewModel() }
    }
}