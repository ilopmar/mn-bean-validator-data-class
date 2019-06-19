package micronaut;

import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Introspected
public class PojoWithURL {

    @Nonnull
    @NotEmpty
    @ValidURL
    private List<String> baseUris;

    public PojoWithURL() {
    }

    public PojoWithURL(@Nonnull @NotEmpty List<String> baseUris) {
        this.baseUris = baseUris;
    }

    @Nonnull
    public List<String> getBaseUris() {
        return baseUris;
    }

    public void setBaseUris(@Nonnull List<String> baseUris) {
        this.baseUris = baseUris;
    }
}
