package org.example.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Code {

    private final List<Integer> list;

    public Code(List<Integer> list){
        this.list = list;
    }

    public int getFirst(){
        return list.get(0);
    }

    public int getSecond(){
        return list.get(1);
    }

    public int getThird(){
        return list.get(2);
    }

    public int getOne() {
        return list.stream().filter(x -> x == 1).toList().size();
    }

    public int getThree(){
        return list.stream().filter(x -> x == 3).toList().size();
    }

    public int getPair() {
        return list.stream().filter(x -> x % 2 == 0).toList().size();
    }

    public int getImpair(){
        return list.stream().filter(x -> x % 2 == 1).toList().size();
    }

    public boolean sameValue() {
        return list.stream().filter(x -> Objects.equals(x, list.get(0))).toList().size() == 3;
    }

    @Override
    public String toString() {
        return list.stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    public boolean sameTwoValues() {
        return list.stream().filter(x -> Objects.equals(x, list.get(0))).toList().size() == 2 ||
                list.stream().filter(x -> Objects.equals(x, list.get(1))).toList().size() == 2;
    }

    public boolean isCroissant() {
        return getFirst() < getSecond() && getSecond() < getThird();
    }

    public boolean isDecroissant() {
        return getFirst() > getSecond() && getSecond() > getThird();
    }

    public boolean isNotMonotone() {
        return !isCroissant() && !isDecroissant();
    }

    public boolean allDifferent() {
        return list.stream().filter(x -> Objects.equals(x, list.get(0))).toList().size() == 1 &&
                list.stream().filter(x -> Objects.equals(x, list.get(1))).toList().size() == 1;
    }
    public int getFour() {
        return list.stream().filter(x -> x == 4).toList().size();
    }

    public int getSomme(){
        return getFirst() + getSecond() + getThird();
    }

    public int getSommeFirstSecond(){
        return getFirst() + getSecond();
    }

    public int getSommeSecondThird(){
        return getThird() + getSecond();
    }

    public int getSommeFirstThird(){
        return getFirst() + getThird();
    }

    public boolean allConsecutiveCroissantValues(){
        return (getSecond() == getFirst() + 1) && (getThird() == getSecond() + 1);
    }

    public boolean twoConsecutiveCroissantValues(){
        return ((getSecond() == getFirst() + 1) && (getThird() != getSecond() + 1)) ||
                ((getSecond() != getFirst() + 1) && (getThird() == getSecond() + 1));
    }

    public boolean noneConsecutiveCroissantValues(){
        return (getSecond() != getFirst() + 1) && (getThird() != getSecond() + 1);
    }

    public boolean allConsecutiveDecroissantValues(){
        return (getSecond() == getFirst() - 1) && (getThird() == getSecond() - 1);
    }

    public boolean twoConsecutiveDecroissantValues(){
        return ((getSecond() == getFirst() - 1) && (getThird() != getSecond() - 1)) ||
                ((getSecond() != getFirst() - 1) && (getThird() == getSecond() - 1));
    }

    public boolean noneConsecutiveDecroissantValues(){
        return (getSecond() != getFirst() - 1) && (getThird() != getSecond() - 1);
    }
}
