package dev.nichoko.data.jpa.exception;

public class EmployeeNotFoundException extends RuntimeException {
    private String message;

    

    public EmployeeNotFoundException(String message) {
        this.message = message;
    }



    public EmployeeNotFoundException(String message, String message2) {
        super(message);
        message = message2;
    }



    public EmployeeNotFoundException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }



    public EmployeeNotFoundException(String message, Throwable cause, String message2) {
        super(message, cause);
        message = message2;
    }



    public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace, String message2) {
        super(message, cause, enableSuppression, writableStackTrace);
        message = message2;
    }



    @Override
    public String toString() {
        return "EmployeeNotFoundException [message=" + message + "]";
    }

    
}
