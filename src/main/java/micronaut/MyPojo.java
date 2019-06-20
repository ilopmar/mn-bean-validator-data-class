package micronaut;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Introspected
public class MyPojo {

    private List<@NotBlank String> myList;

    public MyPojo() {
    }

    public MyPojo(List<@NotBlank String> myList) {
        this.myList = myList;
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }
}
