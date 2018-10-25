package handlebarsUtils;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class IsNumberHelper implements Helper<Double> {


    @Override
    public CharSequence apply(Double arg0, Options arg1) throws IOException {
        return arg0.isNaN() ? arg1.param(0) : arg0.toString();
    }


}