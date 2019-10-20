package com.example.littletreestronger.viewmodel


import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import kotlin.random.Random


class TestViewModelTest {

    lateinit var model: TestViewModel


    @get:Rule
    val rule = MyRule()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
        println("down!!!!!!!")
    }

    @Test
    fun getTag() {
    }


//    @displ("自定义名称重复测试")
    @Test
    fun add() {
        val result = model.add(1,2)
    assertEquals("sss",5, result)
    }

    @Test
    fun add2() {
        val result = model.add(1,2)
        assertEquals("sss",3, result)
    }


    @Test
    fun ve(){
        val mock = Mockito.mock(Random::class.java)
//        val s = TestViewModel()
//        s.ran = mock
//        s.verify()
        Mockito.verify(mock).nextLong()
    }



}