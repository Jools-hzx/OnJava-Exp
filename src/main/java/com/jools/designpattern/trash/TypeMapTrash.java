package com.jools.designpattern.trash;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Jools He
 * @date 2025/6/23 15:11
 * @description: TODO
 */
// Adapter class for ParseTrash.fillBin():
class TypeMapAdapter implements Fillable {

    private TypeMap<Trash> map;

    TypeMapAdapter(TypeMap<Trash> map) {
        this.map = map;
    }

    @Override
    public void addTrash(Trash t) {
        map.add(t);
    }
}

public class TypeMapTrash {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        TypeMap<Trash> bin = new TypeMap<>();
        ParseTrash.fillBin(
                "com/jools/designpattern/trash".replaceAll("/", "."),
                new TypeMapAdapter(bin));

        ClassToListOfTrashMap.show(bin.map);
    }

    @Test
    public void groupBy() {
        List<Trash> bin = new ArrayList<>();
        ParseTrash.fillBin(
                "com/jools/designpattern/trash".replaceAll("/", "."),
                bin);
        Map<Class, List<Trash>> m = bin.stream().collect(
                Collectors.groupingBy(Object::getClass)
        );
        ClassToListOfTrashMap.show(m);
    }
}


