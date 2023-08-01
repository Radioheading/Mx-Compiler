package Util.error;
import Util.position;

abstract public class error extends RuntimeException {
    private position pos;
    private String message;

    public error(String msg, position pos) {
        this.pos = pos;
        this.message = msg;
    }

    public String toString() {
        if (pos != null) {
            return message + ": " + pos.toString();
        } else {
            return message;
        }
    }
}
