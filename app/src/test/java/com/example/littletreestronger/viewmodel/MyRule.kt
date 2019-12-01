package com.example.littletreestronger.viewmodel

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement


class MyRule : TestRule {

    override fun apply(base: Statement?, description: Description?): Statement {

        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                // evaluate前执行方法相当于@Before
                val methodName = description?.getMethodName() // 获取测试方法的名字
                println(methodName + "测试开始！")
                base?.evaluate()  // 运行的测试方法
//                base.e
                // evaluate后执行方法相当于@After
                println(methodName + "测试结束！")
            }
        }
    }

}