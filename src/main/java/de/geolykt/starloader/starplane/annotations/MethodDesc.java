package de.geolykt.starloader.starplane.annotations;

import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

/**
 * Annotation that represents the descriptor of a method.
 * If referencing the required classes is not possible (either because they do not exist or are not visible),
 * this Annotation should not be used. Instead {@link RemapMemberReference#desc()} or similar should be used.
 */
@Documented
@Retention(CLASS)
public @interface MethodDesc {
    Class<?>[] args();
    Class<?> ret();
}
