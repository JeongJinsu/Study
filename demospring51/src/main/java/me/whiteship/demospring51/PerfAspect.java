package me.whiteship.demospring51;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    //JoinPoint: @Around 타겟 메소드를 감싸는 형식으로
    //PointCut: @PerfLogging 애노테이션이 붙은 곳에 적용 하겠다
    @Around("@annotation(PerfLogging)")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable { //ProceedingJoinPoint: Advice가 적용되는 대상(Target 메소드)
        long begin = System.currentTimeMillis();
        Object reVal = pjp.proceed(); //Target 메소드(핵심 관심사) 실행
        System.out.println(System.currentTimeMillis() - begin);
        return reVal;
    }
}
