package com.example.littletreestronger.viewmodel

import androidx.test.core.app.launchActivity
import com.example.littletreestronger.data.repository.ExerciseRecordRepository
import org.junit.Assert.*
import org.junit.Test

import org.robolectric.Robolectric
import org.robolectric.shadows.ShadowCompoundButton

//class FakeRepo: ExerciseRecordRepository(){

//    @Test
//    @Throws(Exception::class)
//    fun testCheckBoxState() {
//
//        val scenario = launchActivity<MyActivity>()
//
//
//        Robolectric.setupActivity()
//        val cb = ShadowCompoundButton()
//        // 验证CheckBox初始状态
//        assertFalse(cb.isChecked())
//
//        // 点击按钮反转CheckBox状态
//        mInverseBtn.performClick()
//        // 验证状态是否正确
//        assertTrue(checkBox.isChecked())
//
//        // 点击按钮反转CheckBox状态
//        mInverseBtn.performClick()
//        // 验证状态是否正确
//        assertFalse(checkBox.isChecked())
//    }

//}