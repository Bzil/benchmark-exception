package bz.test.benchmark;

import bz.test.benchmark.writer.DummyPojo;
import bz.test.benchmark.writer.Writer;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Main {

    private static final int ARRAY_SIZE = 10_000;
    // Destination buffer, the slayer
    private final Writer writer = new Writer();
    // experiment test input
    private DummyPojo[] dummyPojos;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Main.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void init() {
        dummyPojos = new DummyPojo[ARRAY_SIZE];
        for (int i = 0; i < dummyPojos.length; i++) {
            dummyPojos[i] = new DummyPojo();
        }
    }

    @Benchmark
    public int failWriteWithLazyException() {
        writer.failWriteWithLazyException(dummyPojos);
        return dummyPojos.length;
    }

    @Benchmark
    public int failWriteWithNewException() {
        writer.failWriteWithNewException(dummyPojos);
        return dummyPojos.length;
    }

    @Benchmark
    public int failWriteWithNewExceptionAndMessage() {
        writer.failWriteWithNewExceptionAndMessage(dummyPojos);
        return dummyPojos.length;
    }

    @Benchmark
    public int failWriteWithOverrideException() {
        writer.failWriteWithOverrideException(dummyPojos);
        return dummyPojos.length;
    }

    @Benchmark
    public int failWriteWithStaticException() {
        writer.failWriteWithStaticException(dummyPojos);
        return dummyPojos.length;
    }
}

