package micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller("/")
@Validated
public class SearchController {

    @Post("/search")
    public HttpResponse search(@Body @NotNull @Valid Search search) {
        return HttpResponse.ok();
    }

    @Error(exception = ConstraintViolationException.class)
    public HttpResponse validationError(ConstraintViolationException ex) {
        assert ex.getConstraintViolations().size() == 1;

        return HttpResponse.badRequest();
    }
}
