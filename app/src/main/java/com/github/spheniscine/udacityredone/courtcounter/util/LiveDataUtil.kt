package com.github.spheniscine.udacityredone.courtcounter.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T : Any> MutableLiveData<T>.delegate() = object : ReadWriteProperty<Any?, T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T =
        this@delegate.value!!

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this@delegate setIfNot value
    }
}

@JvmName("delegateNullable")
fun <T : Any> MutableLiveData<T?>.delegate() = object : ReadWriteProperty<Any?, T?> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T? =
        this@delegate.value

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        this@delegate setIfNot value
    }
}

/**
 * Advantages of these extension functions:
 * - nullability checking (though *grabbing* the value will always be nullable, we can make sure we avoid setting
 * them to null if we shouldn't)
 *
 * - infix functions allow idiomatic code. E.g. `username setIfNot "abc"` instead of `username.setIfNot("abc")`
 */
infix fun <T> MutableLiveData<T>.setTo(new: T) { value = new }

/** Pseudo-constructor that sets a MutableLiveData to an initial value */
fun <T> MutableLiveData(initialValue: T) = MutableLiveData<T>().apply{ value = initialValue }

/**
 * Only triggers observers if the contained value isn't already equal to the desired value
 */
infix fun <T> MutableLiveData<T>.setIfNot(new: T) { if(value != new) value = new }

/**
 * Convenience extension function for LifeCycleOwner (e.g. activity, fragment) to observe LiveData
 * @param liveData The LiveData object to observe.
 * @param callback The lambda function to invoke if liveData's value is set (and/or invoked, in the case of SingleLiveEvent)
 */
inline fun <T> LifecycleOwner.onSet(liveData : LiveData<T>, crossinline callback : (T) -> Unit) =
    liveData.observe(this, Observer {callback(it)})