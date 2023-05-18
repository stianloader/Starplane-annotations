package de.geolykt.starloader.starplane.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation to remap a given class and return it as a string whenever {@link ReferenceSource#getStringValue()}
 * is called and assigned to the field that is annotated with this annotation.
 * Either {@link RemapClassReference#name()} or {@link RemapClassReference#type()} is used to represent the
 * class - if both are supplied undefined behaviour may occur. However the transformer may also crash, so this
 * undefined behaviour should not be relied on in any shape.
 *
 * @since 1.0.0
 */
@Retention(CLASS)
@Target(FIELD)
@Documented
public @interface RemapClassReference {

    /**
     * The fully qualified internal name of the class.
     * Example: "org/example/Outer$Inner"
     *
     * @return The name of the class
     */
    String name() default "";

    /**
     * The type of the class to represent. Note: referencing this class in an annotation won't lead to classloading
     * unless the class constant needs to be loaded (though as of v1.0.0 that is not possible).
     *
     * @return The {@link Class} type of the class to reference
     * @since 1.0.0
     */
    Class<?> type() default void.class;
}
