package com.github.spheniscine.udacityredone.courtcounter.ui

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.github.spheniscine.udacityredone.courtcounter.App
import com.github.spheniscine.udacityredone.courtcounter.util.onSet

interface ActivityOrFragment : LifecycleOwner {
    val ctx: Context
    val act: BaseActivity
    val app: App
    val root: View
}

inline fun <T> ActivityOrFragment.bindText(view: TextView, liveData: LiveData<T>,
                                           crossinline template: (T) -> String = { it.toString() }) {
    onSet(liveData) {
        view.text = template(it)
    }
}

inline fun ActivityOrFragment.bindClick(view: View, crossinline onClicked: () -> Unit) {
    view.setOnClickListener { onClicked() }
}