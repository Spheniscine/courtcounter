package com.github.spheniscine.udacityredone.courtcounter.ui

import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.spheniscine.udacityredone.courtcounter.App

abstract class BaseActivity : AppCompatActivity(), ActivityOrFragment {
    override val act get() = this
    override val ctx: Context get() = this
    override val app get() = application as App
    override val root by lazy { findViewById<View>(android.R.id.content)!! }
}