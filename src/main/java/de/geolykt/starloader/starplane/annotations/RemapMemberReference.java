package de.geolykt.starloader.starplane.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation to remap a given method or field and return it as a string whenever {@link ReferenceSource#getStringValue()}
 * is called and assigned to the field that is annotated with this annotation.
 *
 * @since 1.0.0
 */
@Retention(CLASS)
@Target(FIELD)
@Documented
public @interface RemapMemberReference {

    /**
     * The fully qualified internal name owner of the member. Mutually exclusive with {@link #ownerType()}.
     * Example: "com/example/Outer$Inner"
     *
     * @return The owner class.
     * @since 1.0.0
     */
    String owner() default "";

    /**
     * The {@link Class} of the owner of the member. Mutually exclusive with {@link #owner()}.
     *
     * @return The owner class.
     * @since 1.0.0
     */
    Class<?> ownerType() default void.class;

    /**
     * The member's name.
     *
     * @return The field or method name.
     * @since 1.0.0
     */
    String name();

    /**
     * The descriptor of the method or field in string format. Mutually exclusive with both
     * {@link #descType()} and {@link #methodDesc()}.
     * Examples:
     * <ul>
     *  <li>()V</li>
     *  <li>()Ljava/lang/Object;</li>
     *  <li>(Z)I</li>
     *  <li>(Ljava/lang/Object;)V</li>
     *  <li>J</li>
     *  <li>Ljava/lang/Object;</li>
     * </ul>
     *
     * <p>Hint: If you have no clue what this is, use {@link #methodDesc()}
     * for methods and {@link #descType()} for fields instead.
     *
     * @return The descriptor string of the member
     * @since 1.0.0
     */
    String desc() default "";

    /**
     * The descriptor (i.e. type) of the <b>field</b>. Mutually exclusive with both
     * {@link #desc()} and {@link #methodDesc()}.
     *
     * @return The {@link Class} type of the member <b>field</b>
     * @since 1.0.0
     */
    Class<?> descType() default void.class;

    /**
     * The <b>method</b> descriptor of the member represented through a {@link MethodDesc}.
     * Mutually exclusive with both {@link #desc()} and {@link #descType()}.
     *
     * @return The <b>method</b> descriptor.
     * @since 1.0.0
     */
    MethodDesc methodDesc() default @MethodDesc(args = {}, ret = void.class);

    /**
     * The format to use when inlining {@link ReferenceSource#getStringValue()}.
     *
     * @return The format of the inlined reference.
     * @since 1.0.0
     */
    ReferenceFormat format();

    /**
     * The formats known to the transformer that will inline {@link ReferenceSource#getStringValue()}.
     *
     * @since 1.0.0
     */
    public enum ReferenceFormat {

        /**
         * Only return the fully qualified internal name of the owner of the class member.
         * While generally {@link RemapClassReference} can be used from the get-go, some minor sanity tests
         * are needed (i.e. to ensure that methods exists at compile-time) by using {@link RemapMemberReference} with
         * {@link ReferenceFormat#OWNER}.
         *
         * @since 1.0.0
         */
        OWNER,

        /**
         * Only return the name of the class member.
         *
         * @since 1.0.0
         */
        NAME,

        /**
         * Only return the descriptor string of the class member.
         * Examples of such descriptor strings are:
         * <ul>
         *  <li>()V</li>
         *  <li>()Ljava/lang/Object;</li>
         *  <li>(Z)I</li>
         *  <li>(Ljava/lang/Object;)V</li>
         *  <li>J</li>
         *  <li>Ljava/lang/Object;</li>
         * </ul>
         *
         * <p>For more information on method and field descriptors,
         * see <a href="https://docs.oracle.com/javase/specs/jvms/se17/html/jvms-4.html#jvms-4.3">JVMS §4.3</a>.
         *
         * @since 1.0.0
         */
        DESCRIPTOR,

        /**
         * A composite format consisting of member owner, name and descriptor.
         * 
         *<p>The format of the value of the resulting string must be:
         * <br> {@literal "org/example/Example.field"} for fields
         * <br> {@literal "org/example/Example.method(Lorg/example/Parameter;)Lorg/example/ReturnType;"} for methods
         *
         * @since 1.0.0
         */
        COMBINED_LEGACY;
    }
}
