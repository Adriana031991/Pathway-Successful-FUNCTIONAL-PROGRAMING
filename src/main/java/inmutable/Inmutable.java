package inmutable;

import org.immutables.value.Value;

import java.util.Collections;
import java.util.List;

/*

*/
@Value.Immutable
public final class Inmutable {
    private final String name;
    private final Integer age;
    private final List anillos;

    public Inmutable(String name, Integer age, List anillos) {
        this.name = name;
        this.age = age;
        this.anillos = Collections.unmodifiableList(anillos);
    }

}
