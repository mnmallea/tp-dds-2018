package controllers;

import exception.UnloggedException;
import spark.Request;
import spark.Response;

public class LoginValidator{

    public static void validate(Request request, Response response) {
        if (request.session().isNew()) {
            throw new UnloggedException();
        }
    }
}
