import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Proxy;

public final class SimpleService {


    public interface GitHub {
        String  encryptToUpper(@UpperCase("S") String text);
    }


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface UpperCase {
         String value() default "U";
         //"L" or "U"
    }

    public static void main(String... args) throws IOException {

        // Create an instance of our GitHub API interface.
        GitHub github = OurDP.create(GitHub.class);

        String encrypted = github.encryptToUpper("square");

        System.out.println(encrypted);
    }


    public static class OurDP {
        @SuppressWarnings("unchecked")
        static <T> T create(final Class<T> service) {
            return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                    (proxy, method, args) -> ((UpperCase)method.getParameters()[0].getAnnotations()[0]).value());
        }
    }

}