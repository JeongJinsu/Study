package me.whiteship.demospring51;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    //JoinPoint: @Around 타겟 메소드를 감싸는 형식으로
    //PointCut: IOC 컨테이너에 담겨있는 해당 빈의 모든 메소드에 적용 하겠다
    @Around("bean(simpleEventService)")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable { //ProceedingJoinPoint: Advice가 적용되는 대상(Target 메소드)
        long begin = System.currentTimeMillis();
        Object reVal = pjp.proceed(); //Target 메소드(핵심 관심사) 실행
        System.out.println(System.currentTimeMillis() - begin);
        return reVal;
    }

    //JoinPoint: @Before 타겟 메소드가 호출되기 이전에
    @Before("bean(simpleEventService)")
    public void hello() {
        System.out.println("hello");
    }
}
