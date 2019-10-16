package com.example.littletreestronger.common

import android.util.Log
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect

import timber.log.Timber
import java.util.logging.Logger

@Aspect
class DebugAspect {

    companion object {
        val TAG = "DebugAspect"
    }

//    @Pointcut("execution(* com.example.littletreestronger..*.on*(..))")
//    fun onPointcut(){}

//    @Pointcut("execution(* com.example.littletreestronger.ui.exercise.ExerciseFragment.onCreateView(..))")
//    fun onPointcut(){}
//
//    @After("onPointcut()")
//    fun aroundJoinPoint0(){
//        try {
//            Log.d("helloAOP", "" + joinPoint?.getSignature());
//        }catch (e: Exception) {
//            Log.d("helloAOP", "" + e.message);
//        }
//    }

//    @After("execution( * com.example.littletreestronger.ui.exercise.ExerciseFragment.on*(..))")
//    fun aroundJoinPoint0(joinPoint: JoinPoint?){
//        try {
//            Log.d("helloAOP", "" + joinPoint?.getSignature());
//        }catch (e: Exception) {
//            Log.d("helloAOP", "" + e.message);
//        }
//    }


    @Around("execution( * androidx.fragment.app.Fragment+.on*(..))")
    fun around(joinPoint: ProceedingJoinPoint) {
        val before = System.currentTimeMillis()
        joinPoint.proceed()
        Timber.d(
            """
                
            AOP___
            signature = ${joinPoint.signature}
            args = ${joinPoint.args.iterator()}
            kind = ${joinPoint.kind}
            sourceLocation = ${joinPoint.sourceLocation}
            staticPart = ${joinPoint.staticPart}
            target = ${joinPoint.target}
            
            funTime = ${System.currentTimeMillis() - before}
            """
        )
    }


}
