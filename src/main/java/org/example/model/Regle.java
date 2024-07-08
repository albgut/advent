package org.example.model;

import java.util.List;

public record Regle(int id, String description, List<Predicat> verifieurs) {
}
