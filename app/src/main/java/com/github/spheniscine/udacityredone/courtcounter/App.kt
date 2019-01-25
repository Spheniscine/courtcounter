package com.github.spheniscine.udacityredone.courtcounter

import android.app.Application
import org.koin.standalone.StandAloneContext

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        StandAloneContext.startKoin(listOf(module()))
    }
}