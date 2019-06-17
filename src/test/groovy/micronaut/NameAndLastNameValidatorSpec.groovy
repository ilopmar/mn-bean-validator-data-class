package micronaut

import io.micronaut.test.annotation.MicronautTest
import io.micronaut.validation.validator.Validator
import spock.lang.Specification

import javax.inject.Inject
import javax.validation.ConstraintViolation

@MicronautTest
class NameAndLastNameValidatorSpec extends Specification {

    @Inject
    Validator validator

    void 'test custom validator'() {
        given:
        Search search = new Search()

        when:
        Set<ConstraintViolation<Search>> constraintViolations = validator.validate(search)

        then:
        constraintViolations.size() == 1
    }
}
