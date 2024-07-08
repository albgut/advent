package org.example.model;

import java.util.function.Predicate;

public record Predicat(String name, Predicate<Code> predicat) {
    @Override
    public String toString() {
        return name;
    }
}
