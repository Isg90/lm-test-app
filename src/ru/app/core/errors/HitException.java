package ru.app.core.errors;

public class HitException extends RuntimeException {

    public HitException() {
        super("Мяч улетел в космос и не вернулся");
    }
}
