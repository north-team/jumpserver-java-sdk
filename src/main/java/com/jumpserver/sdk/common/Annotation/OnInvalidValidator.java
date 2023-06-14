package com.jumpserver.sdk.common.Annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Documented
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Constraint(validatedBy = {OnInvalidValidator.validateOnInvalid.class})
public @interface OnInvalidValidator {


    // 校验信息,不能省略
    String message() default "「账号存在策略」参数不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class validateOnInvalid implements ConstraintValidator<OnInvalidValidator, String> {

        private List<String> pattern;

        @Override
        public void initialize(OnInvalidValidator validateOnInvalid) {
            this.pattern = new ArrayList<String>();
            this.pattern.add("skip");
            this.pattern.add("update");
            this.pattern.add("error");
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {

            try {
                if (this.pattern.contains(value)) {
                    return true;
                }else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
    }
}
