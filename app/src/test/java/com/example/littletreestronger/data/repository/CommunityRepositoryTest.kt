/*
 * Copyright - LittleTree (c) 2019.
 */

package com.example.littletreestronger.data.repository

import com.example.littletreestronger.viewmodel.MyRule
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CommunityRepositoryTest {


    @get:Rule
    val rule = MyRule()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {

    }



//    val str = CommunityRepository.getInstance().getHelloWorld()
//    println(str)
    @Test
    fun getHelloWorld() {
    runBlocking {
        val str = CommunityRepository.getInstance().getHelloWorld()
        println(str)
    }
    }

}