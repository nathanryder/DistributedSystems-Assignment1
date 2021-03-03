package main.exception;

public class InvalidLogin extends Throwable {

    public InvalidLogin(String s) {
        super(s);
    }

}
