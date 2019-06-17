package micronaut;

import io.micronaut.core.annotation.Introspected;

@Introspected
@NameAndLastNameValidator
public class Search {

    private String name;

    private String lastName;

    public Search() {
    }

    public Search(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
