package bz.test.benchmark.exception;


public class BusinessExceptionWithStaticStacktrace extends RuntimeException {

    public static final BusinessExceptionWithStaticStacktrace BUSINESS_EXCEPTION = new BusinessExceptionWithStaticStacktrace();
    static {
        BUSINESS_EXCEPTION.setStackTrace(new StackTraceElement[0]);
    }

    public BusinessExceptionWithStaticStacktrace() {
    }

    public BusinessExceptionWithStaticStacktrace(String message) {
        super(message);
    }
}

