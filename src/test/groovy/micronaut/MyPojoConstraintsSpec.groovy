package micronaut

import io.micronaut.test.annotation.MicronautTest
import io.micronaut.validation.validator.Validator
import spock.lang.Specification

import javax.inject.Inject
import javax.validation.ConstraintViolation

@MicronautTest
class MyPojoConstraintsSpec extends Specification {

    @Inject
    Validator validator

    void 'test custom validator'() {
        given:
        MyPojo myPojo = new MyPojo(myList: ['', ' '])

        when:
        Set<ConstraintViolation<MyPojo>> constraintViolations = validator.validate(myPojo)

        then:
        constraintViolations.size() == 1
        constraintViolations.first().message == 'must not be blank'
    }
}
