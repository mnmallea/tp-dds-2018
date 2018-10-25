package controllers;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    public static String hashPassword(String pass) {
        return BCrypt.hashpw(pass, BCrypt.gensalt());
    }

    public static boolean verifyPassword(String pass, String hash) {
        return BCrypt.checkpw(pass, hash);
    }
}
