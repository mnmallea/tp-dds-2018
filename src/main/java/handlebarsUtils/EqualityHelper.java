package handlebarsUtils;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class EqualityHelper implements Helper<Object> {
    @Override
    public Object apply(Object context, Options options) throws IOException {
        Object param1 = options.param(0);
        return context.equals(param1);
    }
}
