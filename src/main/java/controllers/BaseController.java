package controllers;

import exception.UnloggedException;
import spark.Request;

public class BaseController {
    public static final BaseController instancia = new BaseController();

    public void loginValidation(Request request) {
        if (!request.session().isNew()) {
            throw new UnloggedException();
        }
    }
}
