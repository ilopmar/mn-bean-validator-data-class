package micronaut

import io.micronaut.test.annotation.MicronautTest
import io.micronaut.validation.validator.Validator
import spock.lang.Specification

import javax.inject.Inject
import javax.validation.ConstraintViolation

@MicronautTest
class ValidURLValidatorSpec extends Specification {

    @Inject
    Validator validator

    void 'test custom validator'() {
        given:
        PojoWithURL foo = new PojoWithURL(['ssss'])

        when:
        Set<ConstraintViolation<PojoWithURL>> constraintViolations = validator.validate(foo)

        then:
        constraintViolations.forEach { c -> println("${c.propertyPath}: ${c.getMessage()}") }
        constraintViolations.size() == 1
        constraintViolations.first().message == "invalid url"
    }
}
