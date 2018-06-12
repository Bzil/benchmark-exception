package bz.test.benchmark.exception;

public class BusinessExceptionWithOverrideStacktrace extends RuntimeException {

    public BusinessExceptionWithOverrideStacktrace() {
    }

    public BusinessExceptionWithOverrideStacktrace(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

