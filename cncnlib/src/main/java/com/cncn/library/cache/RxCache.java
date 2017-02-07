package com.cncn.library.cache;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <请描述这个类是干什么的>
 *
 * @author caiyk@cncn.com
 * @data: 2016/5/17 14:33
 * @version: V1.0
 */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface RxCache {
}
