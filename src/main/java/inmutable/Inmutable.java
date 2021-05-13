package inmutable;

import com.sun.jdi.Value;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*

 */


public final class Inmutable {
    private final String name;
    private final Integer age;
    private final List anillos;

    public Inmutable(String name, Integer age, List anillos) {
        this.name = name;
        this.age = age;
        this.anillos = anillos;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List getAnillos() {
        return Collections.unmodifiableList(anillos);
    }
}
