package com.jools.jmh.quickstart;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.openjdk.jmh.annotations.*;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/12 11:37
 * @description: TODO
 */
@State(Scope.Benchmark)
public class HashExecutionPlan {

    @Param({"100", "200", "300", "500", "1000"})
    public int iterations;

    public Hasher murmur3;

    public String password = "4v3rys3kur3p455w0rd";

    @Setup(Level.Invocation)
    public void setUp() {
        murmur3 = Hashing.murmur3_128().newHasher();
    }
}
