package micronaut;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidURL {

    /**
     * @return message
     */
    String message() default "invalid url";

//    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
//    @Retention(RetentionPolicy.RUNTIME)
//    @Documented
//    @interface List {
//        ValidURL[] value();
//    }
}
