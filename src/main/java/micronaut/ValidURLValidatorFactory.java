package micronaut;

import io.micronaut.context.annotation.Factory;
import io.micronaut.validation.validator.constraints.ConstraintValidator;

import javax.inject.Singleton;
import java.util.List;
import java.util.regex.Pattern;

@Factory
public class ValidURLValidatorFactory {

    private static final Pattern URL = Pattern.compile("(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?");

    @Singleton
    ConstraintValidator<ValidURL, List<String>> validURLValidator() {
        return (value, annotationMetadata, context) ->
                value != null && value.stream().allMatch(u -> URL.matcher(u).matches());
    }
}
