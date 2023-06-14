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
@Constraint(validatedBy = {ActionValidator.validateAction.class})
public @interface ActionValidator {


    // 校验信息,不能省略
    String message() default "「权限」参数不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class validateAction implements ConstraintValidator<ActionValidator, List<String>> {

        private List<String> pattern;

        @Override
        public void initialize(ActionValidator validateAction) {
            this.pattern = new ArrayList<String>();
            this.pattern.add("connect");
            this.pattern.add("upload");
            this.pattern.add("download");
            this.pattern.add("copy");
            this.pattern.add("paste");
        }

        @Override
        public boolean isValid(List<String> value, ConstraintValidatorContext context) {

            try {
                for (String str:value) {
                    if (!this.pattern.contains(str)) {
                        return false;
                    }
                }
            } catch (Exception e) {
                return false;
            }
            return true;
        }
    }
}
