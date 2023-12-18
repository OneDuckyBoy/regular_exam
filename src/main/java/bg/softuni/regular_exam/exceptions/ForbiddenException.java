package bg.softuni.regular_exam.exceptions;


public class ForbiddenException {

    private int code;
    private String message;

    public ForbiddenException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
