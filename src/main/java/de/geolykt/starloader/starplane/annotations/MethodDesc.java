package de.geolykt.starloader.starplane.annotations;

import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

/**
 * Annotation that represents the descriptor of a method.
 * If referencing the required classes is not possible (either because they do not exist or are not visible),
 * this Annotation should not be used. Instead {@link RemapMemberReference#desc()} or similar should be used.
 *
 * @since 1.0.0
 */
@Documented
@Retention(CLASS)
public @interface MethodDesc {

    /**
     * The method's argument types or empty array if no arguments.
     *
     * @return The arguments of the method
     * @since 1.0.0
     */
    Class<?>[] args();

    /**
     * The method's return type.
     *
     * @return The return type of the method (void.class = void)
     * @since 1.0.0
     */
    Class<?> ret();
}
