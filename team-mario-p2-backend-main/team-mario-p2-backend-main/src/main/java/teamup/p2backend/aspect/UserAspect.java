package teamup.p2backend.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class UserAspect {

    Logger logger = Logger.getLogger(UserAspect.class);

    @Before("execution(* postUser*(..))")
    public void BeforeCreatingUser(JoinPoint joinPoint) {
        logger.info("User created / Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* getAllUsers*(..))")
    public void BeforeGettingUser(JoinPoint joinPoint) {
        logger.info("Every user retrieved / Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* postUser*(..))")
    public void BeforePostingUser(JoinPoint joinPoint) {
        logger.info("Executing: Post(create) User / Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* updateUser*(..))")
    public void BeforeUpdatingUser(JoinPoint joinPoint) {
        logger.info("Executing: Update User / Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* deleteUser*(..))")
    public void BeforeDeletingUser(JoinPoint joinPoint) {
        logger.info("Executing: Update User / Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* getUserById*(..))")
    public void BeforeGettingUsersById(JoinPoint joinPoint) {
        logger.info("Executing: User retrieved by id / Command signature:  " + joinPoint.getSignature());
    }
    @After("execution(* getUserById*(..))")
    public void AfterGettingUsersById(JoinPoint joinPoint) {
        logger.info("User retrieved by id / Command signature:  " + joinPoint.getSignature());
    }

    @Before("execution(* getUserByUsername*(..))")
    public void BeforeGettingUsersByUsername(JoinPoint joinPoint) {
        logger.info("Executing: Retrieve User by Username. Command signature:  " + joinPoint.getSignature());
    }

}