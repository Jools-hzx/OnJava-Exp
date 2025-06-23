package com.jools.annotation_;

/**
 * @author Jools He
 */

public @interface Uniqueness {

    Constraints constraints() default @Constraints(unique = true);
}
