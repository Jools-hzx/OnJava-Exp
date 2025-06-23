package com.jools.generic_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/21 17:34
 * @description: TODO
 */
public class MultipleInterfaceVariants {
}

interface Payable<T> {
}

class Emp implements Payable<Emp> {
}

// 报错: 'com.jools.generic_.Payable' cannot be inherited with different type arguments:
// 'com.jools.generic_.Emp' and 'com.jools.generic_.Hourly
//class Hourly extends Emp implements Payable<Hourly> { }