package com.github.brbrt;

import com.github.brbrt.publicfieldxjc.sample.generated.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PublicFieldPluginTest {

    @Parameterized.Parameters
    public static Collection<Class<?>[]> classes() {
        return Arrays.asList(new Class<?>[][] {
                { AddressType.class },
                { CustomerType.class },
                { OrderType.class },
                { ShipInfoType.class }
        });
    };

    private Class<?> clazz;

    public PublicFieldPluginTest(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Test
    public void doesNotHaveMethods() {
        assertEquals(clazz.getDeclaredMethods().length, 0);
    }

    @Test
    public void allPropertiesPublic() {
        for (Field f : clazz.getDeclaredFields()) {
            int modifiers = f.getModifiers();
            assertEquals(Modifier.isPublic(modifiers), true);
        }
    }

}
