package de.geolykt.starloader.starplane.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.jetbrains.annotations.ApiStatus.Obsolete;

/**
 * StarplaneReobfuscateReference is an annotation that can be used to reference class, method and fields at runtime.
 * This annotation may only be applied on strings which may <b>not</b> be final and <b>must</b> be static and
 * the assignment may not happen in the static block or anywhere else. Failure doing so will result in a compile
 * time error
 *
 *<p>The format of the value of the string must be:
 * <br> {@literal "org/example/Example"} for classes
 * <br> {@literal "org/example/Example.field"} for fields
 * <br> {@literal "org/example/Example.method(Lorg/example/Parameter;)Lorg/example/ReturnType;"} for methods
 *
 * @deprecated This annotation is obsolete and should only be used as a drop-in replacement for legacy code.
 * @since 1.0.0
 */
@Documented
@Retention(CLASS)
@Target(FIELD)
@Deprecated
@Obsolete(since = "1.0.0")
public @interface StarplaneReobfuscateReference { }
