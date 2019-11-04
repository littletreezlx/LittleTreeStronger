/*
 * Copyright - LittleTree (c) 2019.
 */

package com.example.littletreestronger.viewmodel


import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import kotlin.random.Random
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import com.example.littletreestronger.ui.MainActivity
import org.robolectric.Robolectric
import org.robolectric.RuntimeEnvironment

import org.junit.Assert.assertThat
import org.hamcrest.Matchers.*




@RunWith(AndroidJUnit4::class)
class TestTest {

    @get:Rule
    val rule2 = MyRule2()

    @get:Rule
    val rule = MyRule()

//    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()
//
//
//    @Test fun testEvent() {
//        val scenario = activityScenarioRule.scenario
//        scenario.moveToState(Lifecycle.State.CREATED)
//        assertThat(scenario.state, `is`(Lifecycle.State.CREATED))
//    }

    @Mock
    lateinit var testClass: TestClass

    val context = ApplicationProvider.getApplicationContext<Context>()

    @Before
    fun setUp() {
        // 必须要调用这行代码初始化 Mock
//        MockitoAnnotations.initMocks(this)

//        mainActivity = Robolectric.setupActivity(MainActivity::class.java)

    }

    @After
    fun tearDown() {
        println("down!!!!!!!")
    }


    @Test
    fun ve(){
        val testClass = Mockito.mock(TestClass::class.java)
        `when`(testClass.getA()).thenReturn(2)
        println(testClass.getA())


    }



    @Test
    @PrepareForTest(TestClass::class)
    fun ves(){
        val testClass = PowerMockito.mock(TestClass::class.java)

//        PowerMockito.`when`(testClass._getStr()).thenCallRealMethod()
//        PowerMockito.`when`(testClass, "_getStr").thenReturn("111")

//        PowerMockito.`when`(testClass, "_getStr").thenReturn("111")

    }

}