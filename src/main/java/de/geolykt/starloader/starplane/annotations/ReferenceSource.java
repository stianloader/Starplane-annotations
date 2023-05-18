package de.geolykt.starloader.starplane.annotations;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * An imaginary class from which magic constants are called from.
 * The semantics of the starplane annotations mean that all references to this class are "inlined" in one way or another,
 * sometimes with remapping being performed beforehand.
 *
 * @since 1.0.0
 */
public final class ReferenceSource {

    private ReferenceSource() {
        throw new AssertionError();
    }

    /**
     * A method whose references are changed to the appropriate LDC constant used.
     * All annotations depend on this method call, with the exception of {@link StarplaneReobfuscateReference},
     * which transforms an already existing LDC call. Due to the properties of the
     * transformer ALL calls to this method need to be <b>directly</b> assigned to a field which has
     * a starplane annotation on it.
     *
     *<p>The existence of such a method avoids javac inlining the String constant, which is a problem with
     * {@link StarplaneReobfuscateReference}. As such static final fields can be safely used.
     *
     * @return No useful value (this method always throws - but the transformer changes it to a useful
     * value).
     * @since 1.0.0
     */
    @NotNull
    @Contract(pure = true)
    public static String getStringValue() {
        throw new AssertionError("All references to this method must be inlined by a transformer.");
    }
}
