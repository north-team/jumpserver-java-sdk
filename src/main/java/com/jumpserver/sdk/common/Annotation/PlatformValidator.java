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
@Constraint(validatedBy = {PlatformValidator.validatePlatform.class})
public @interface PlatformValidator {


    // 校验信息,不能省略
    String message() default "「系统平台」参数不合法";

    // 分组check,不能省略
    Class<?>[] groups() default {};

    // 作用暂时未知,不能省略
    Class<? extends Payload>[] payload() default {};

    // 使用内部类进行校验逻辑书写;还可以把校验的逻辑单独创建一个类,然后将.class文件通过@Constraint注解引入
    class validatePlatform implements ConstraintValidator<PlatformValidator, Integer> {

        private List<Integer> pattern;

        @Override
        public void initialize(PlatformValidator validStrictDateString) {
            this.pattern = new ArrayList<Integer>();
            this.pattern.add(1);
            this.pattern.add(3);
            this.pattern.add(5);
            this.pattern.add(7);
            this.pattern.add(9);
            this.pattern.add(11);
            this.pattern.add(13);
            this.pattern.add(15);
            this.pattern.add(17);
            this.pattern.add(19);
            this.pattern.add(21);
            this.pattern.add(25);
            this.pattern.add(27);
            this.pattern.add(29);
            this.pattern.add(31);
            this.pattern.add(32);
            this.pattern.add(33);
            this.pattern.add(34);
            this.pattern.add(35);
            this.pattern.add(36);
            this.pattern.add(37);
            this.pattern.add(38);
            this.pattern.add(39);
            this.pattern.add(40);
            this.pattern.add(41);
            this.pattern.add(42);
            this.pattern.add(43);
            this.pattern.add(44);
            this.pattern.add(45);
            this.pattern.add(46);
            this.pattern.add(47);
            this.pattern.add(48);
            this.pattern.add(49);
            this.pattern.add(51);
            this.pattern.add(52);
            this.pattern.add(53);
            this.pattern.add(54);
            this.pattern.add(55);
            this.pattern.add(59);
            this.pattern.add(60);
            this.pattern.add(62);
            this.pattern.add(64);
            this.pattern.add(76);
            this.pattern.add(77);
            this.pattern.add(78);
            this.pattern.add(87);
            this.pattern.add(88);
            this.pattern.add(87);
            this.pattern.add(88);
            this.pattern.add(89);
            this.pattern.add(90);
            this.pattern.add(93);
            this.pattern.add(94);
        }

        @Override
        public boolean isValid(Integer value, ConstraintValidatorContext context) {

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
