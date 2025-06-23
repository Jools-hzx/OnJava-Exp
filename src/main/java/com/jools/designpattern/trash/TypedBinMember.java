package com.jools.designpattern.trash;

import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/23 13:43
 * @description: 在不改变原有层次结构的情况下，将双路分发方式适配到 trash 的层次中
 */
public interface TypedBinMember {

    boolean addToBin(List<TypedBin> bins);
}
