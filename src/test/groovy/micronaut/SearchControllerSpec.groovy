package micronaut

import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class SearchControllerSpec extends Specification {

    @Inject @Shared
    @Client("/")
    RxHttpClient client

    void 'search with wrong parameters fails with BAD_REQUEST'() {
        given:
        HttpRequest req = HttpRequest.POST("/search", new Search());

        when:
        client.toBlocking().exchange(req, Argument.of(HttpResponse), Argument.of(HttpResponse))

        then:
        HttpClientResponseException e = thrown()
        e.response.status() == HttpStatus.BAD_REQUEST
    }
}
