package com.sample;

public final class SimpleService {

    public interface TypeConversion {
        String  toUpper(@TypeCase("L") String text);
    }

    public static void main(String... args)  {
        TypeConversion typeConversion = OurDP.create(TypeConversion.class);

        System.out.println(typeConversion.toUpper( "sQuare"));
    }
}