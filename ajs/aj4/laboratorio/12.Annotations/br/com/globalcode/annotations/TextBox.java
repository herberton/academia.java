package br.com.globalcode.annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TextBox {
	String label();
	boolean enabled() default true;
}
