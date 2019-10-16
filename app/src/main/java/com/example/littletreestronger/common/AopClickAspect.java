package com.example.littletreestronger.common;

import android.util.Log;
import android.view.View;

import com.example.littletreestronger.common.AopClickUtil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import java.lang.reflect.Method;

import kotlin.jvm.Throws;
import timber.log.Timber;


@Aspect
public class AopClickAspect {
    /**
     * 定义切点，标记切点为所有被@AopOnclick注解的方法
     * 注意：这里com.freak.aop.AopOnclick需要替换成
     * 你自己项目中AopOnclick这个类的全路径
     */
    @Pointcut("execution(@com.example.littletreestronger.common.AopOnclick * *(..))")
    public void methodAnnotated() {}

    /**
     * 定义一个切面方法，包裹切点方法
     */
    @Around("methodAnnotated()")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        // 取出方法的参数
        View view = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof View) {
                view = (View) arg;
                break;
            }
        }
        if (view == null) {
            return;
        }
        // 取出方法的注解
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        if (!method.isAnnotationPresent(AopOnclick.class)) {
            return;
        }
        AopOnclick aopOnclick = method.getAnnotation(AopOnclick.class);
        // 判断是否快速点击
        if (!AopClickUtil.isFastDoubleClick(view, aopOnclick.value())) {
            // 不是快速点击，执行原方法
            Timber.d("按钮执行成功");
            joinPoint.proceed();
        }
    }

//
//    @Pointcut("execution(* com.example.littletreestronger.ui.exercise.ExerciseFragment.onCreateView(..))")
//    public void test() {}
//
//    @Before("onPointcut()")
//    public void aroundJoinPoint0(ProceedingJoinPoint joinPoint) throws Throwable {
//                Log.d("helloAOP", "" + joinPoint.getSignature());
//    }

}
