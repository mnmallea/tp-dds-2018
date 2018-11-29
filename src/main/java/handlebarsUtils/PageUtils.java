package handlebarsUtils;

import spark.Request;

public class PageUtils {
    public static Integer getPageRequested(Request request) {
        Integer page = null;
        try {
            page = Math.max(Integer.valueOf(request.queryParams("page")), 1);
        } catch (NumberFormatException e) {
            page = 1;
        }
        return page;
    }
}
