/*
 * Copyright - LittleTree (c) 2019.
 */

package com.example.littletreestronger.viewmodel


import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest




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