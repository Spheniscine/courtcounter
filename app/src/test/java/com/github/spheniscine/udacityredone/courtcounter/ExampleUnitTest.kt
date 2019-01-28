package com.github.spheniscine.udacityredone.courtcounter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.github.spheniscine.udacityredone.courtcounter.util.delegate
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `LiveData delegate test`() {
        val ld = MutableLiveData<Boolean>()
        var property by ld.delegate()

        assertTrue(runCatching { property }.isFailure)

        property = true

        assertTrue(property)
    }

    @Test
    fun `Nullable liveData delegate test`() {
        val ld = MutableLiveData<Boolean?>()
        var property by ld.delegate()

        assertEquals(null, property)

        property = true

        assertTrue(property!!)
    }
}
