package com.sample;

import java.lang.reflect.Proxy;

public class OurDP {
    @SuppressWarnings("unchecked")
    static <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                (proxy, method, args) -> {

                    //Get Method name
                    //method.getName()

                    //Get Method Parameters
                    //method.getParameters()

                    //Get Parameter Annotation
                    //method.getParameters().getAnnotations()

                    String type = ((TypeCase) method.getParameters()[0].getAnnotations()[0]).value();

                    if (type.equals("L")) {
                        return String.valueOf(args[0]).toLowerCase();
                    } else {
                        return String.valueOf(args[0]).toUpperCase();
                    }

                });
    }
}