package br.com.cadpessoas.domain.enums;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    BeanType beanType() default BeanType.CORE;
}
