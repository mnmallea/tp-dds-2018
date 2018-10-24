package controllers;

import spark.Request;
import spark.Response;
import spark.Spark;

public class LoginValidator {

    public static final String USER_SESSION_ID = "JSESSIONID";

    public static void validate(Request request, Response response) {
        String user = getAuthenticatedUser(request);
        if (user == null) {
            response.redirect("/login");
        }
    }

    public static String getAuthenticatedUser(Request request) {
        return request.session().attribute(USER_SESSION_ID);
    }

    public static void addAuthenticatedUser(Request request, String u) {
        request.session().attribute(USER_SESSION_ID, u);
    }

    public static Void removeAuthenticatedUser(Request request, Response response) {
        request.session().removeAttribute(USER_SESSION_ID);
        response.redirect("/");
        return null;
    }
}
