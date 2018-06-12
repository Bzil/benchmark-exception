package bz.test.benchmark.writer;

import bz.test.benchmark.exception.BusinessExceptionWithOverrideStacktrace;
import bz.test.benchmark.exception.BusinessExceptionWithStaticStacktrace;
import bz.test.benchmark.exception.BusinessException;

public class Writer {

    public void failWriteWithNewException(DummyPojo... pojos) {
        for (DummyPojo pojo: pojos) {
            pojo.setFailure(new BusinessException());
        }
    }

    public void failWriteWithNewExceptionAndMessage(DummyPojo... pojos) {
        for (DummyPojo pojo: pojos) {
            pojo.setFailure(new BusinessException("message"));
        }
    }

    public void failWriteWithLazyException(DummyPojo... pojos) {
        if (pojos.length == 0) {
            return;
        }
        BusinessException businessException = new BusinessException();
        for (DummyPojo pojo: pojos) {
            pojo.setFailure(businessException);
        }
    }

    public void failWriteWithStaticException(DummyPojo... pojos) {
        for (DummyPojo pojo: pojos) {
            pojo.setFailure(BusinessExceptionWithStaticStacktrace.BUSINESS_EXCEPTION);
        }
    }

    public void failWriteWithOverrideException(DummyPojo... pojos) {
        for (DummyPojo pojo: pojos) {
            pojo.setFailure(new BusinessExceptionWithOverrideStacktrace());
        }
    }

}
