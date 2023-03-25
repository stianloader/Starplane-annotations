package de.geolykt.starloader.starplane.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(CLASS)
@Target(FIELD)
public @interface RemapMemberReference {

    String owner() default "";
    Class<?> ownerType() default void.class;
    String name();
    String desc() default "";
    Class<?> descType() default void.class;
    MethodDesc methodDesc() default @MethodDesc(args = {}, ret = void.class);
    ReferenceFormat format();

    public enum ReferenceFormat {
        OWNER,
        NAME,
        DESCRIPTOR,

        /**
         * A composite format consisting of member owner, name and descriptor.
         * 
         *<p>The format of the value of the resulting string must be:
         * <br> {@literal "org/example/Example.field"} for fields
         * <br> {@literal "org/example/Example.method(Lorg/example/Parameter;)Lorg/example/ReturnType;"} for methods
         */
        COMBINED_LEGACY;
    }
}
