package com.rizkiaazmi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Rizki Abdillah Azmi on 20-Jan-23
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NumberUniqueConstraintValidator.class)
public @interface NumberUniqueConstraint {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
