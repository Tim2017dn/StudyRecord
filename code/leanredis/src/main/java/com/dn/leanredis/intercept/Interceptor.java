package com.dn.leanredis.intercept;

import com.dn.leanredis.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {
     boolean before();

     void after();

     Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException ;

     void afterReturning();

     void afterThrowing();

     boolean useAround();

}
