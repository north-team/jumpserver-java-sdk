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
@Constraint(validatedBy = {SecretTypeValidator.validateSecretType.class})
public @interface SecretTypeValidator {


    // 校验信息,不能省略
    String message() default "「密文类型」参数不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class validateSecretType implements ConstraintValidator<SecretTypeValidator, String> {

        private List<String> pattern;

        @Override
        public void initialize(SecretTypeValidator validateSecretType) {
            this.pattern = new ArrayList<String>();
            this.pattern.add("password");
            this.pattern.add("ssh_key");
            this.pattern.add("access_key");
            this.pattern.add("token");
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
