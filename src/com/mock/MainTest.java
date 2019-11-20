package com.mock;

public class MainTest {

    public static void main(String[] args) {

        System.out.println("# MockProxy");
        FooInterface fooInterfaceMock = MockProxy.mock(FooInterface.class);

        MockProxy.when(fooInterfaceMock.foo()).thenReturn("Foo Fighters!");
        System.out.println(fooInterfaceMock.foo());

        MockProxy.when(fooInterfaceMock.echo("echo")).thenReturn("echo");
        System.out.println(fooInterfaceMock.echo("echo"));

        MockProxy.when(fooInterfaceMock.echo("hello")).thenReturn("world");
        System.out.println(fooInterfaceMock.echo("hello"));

        System.out.println();

    }

}
