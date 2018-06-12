# Benchmark Exception

The purpose of this project is to see the impact a Exception creation in code

How use me
----------
Clone repo and go inside 
```bash

mvn clean install
java -jar target/exception-benchmarks.jar Main -f 1

```

Output result 
-------------

Result : 
```
Benchmark                                 Mode  Cnt   Score    Error  Units
Main.failWriteWithLazyException           avgt   10   0,025 ±  0,001  ms/op
Main.failWriteWithNewException            avgt   10  14,125 ±  0,289  ms/op
Main.failWriteWithNewExceptionAndMessage  avgt   10  15,560 ±  0,394  ms/op
Main.failWriteWithOverrideException       avgt   10   0,240 ±  0,006  ms/op
Main.failWriteWithStaticException         avgt   10   0,022 ±  0,001  ms/op
```

We can see that :
- custom Exception are more efficient than standard one;
- lazy exception creation is more efficient than standard one.

The main problem of all java Throwable building the full stacktrace. This creation is call by main Throwable constructor :
See in java.lang.Throwable
```java  
    
    public Throwable() {
        fillInStackTrace();
    }
```
But in business exception you do need full stacktrace, you prefer to get some context (with fields and messages).
