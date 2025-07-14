package cn.hjblogs.hjblogs.common.aspect;

import java.lang.annotation.*;

/**
 * @author JUHE
 * @version 1.0
 */



@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {
    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";
}
