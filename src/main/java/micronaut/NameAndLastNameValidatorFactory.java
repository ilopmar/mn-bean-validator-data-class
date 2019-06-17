package micronaut;

import io.micronaut.context.annotation.Factory;
import io.micronaut.validation.validator.constraints.ConstraintValidator;

import javax.inject.Singleton;

@Factory
public class NameAndLastNameValidatorFactory {

    @Singleton
    ConstraintValidator<NameAndLastNameValidator, Search> nameAndLastNameValidator() {
        return (value, annotationMetadata, context) ->
                value != null && (value.getName() != null || value.getLastName() != null);
    }
}
