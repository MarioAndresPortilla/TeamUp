package teamup.p2backend.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect


public class EventAspect {
    Logger logger = Logger.getLogger(EventAspect.class);

    @Before("execution(* postEvent*(..))")
    public void BeforeSavingEvent(JoinPoint joinPoint){
        logger.info("Post Event Logged / Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* updateEvent*(..))")
    public void BeforeUpdatingEvent(JoinPoint joinPoint){
        logger.info("Updated Event / Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* getEvents*(..))")
    public void BeforeGettingAllEvent(JoinPoint joinPoint){
        logger.info("All Events Logged / Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* getEventBy*(..))")
    public void BeforeGettingEventBy(JoinPoint joinPoint){
        logger.info("Get Event By Logged / Command signature:  " + joinPoint.getSignature());
    }

}

