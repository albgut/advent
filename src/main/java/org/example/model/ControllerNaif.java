package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ControllerNaif {

    private static final int MAX_VAL = 5;

    private static final int MIN_VAL = 1;

    private static final int LENGTH = 3;

    private final Map<Regle, List<Boolean>> data;

    public ControllerNaif(Map<Regle, List<Boolean>> data) {
        this.data = data;
    }

    public static List<Code> buildAllCode(){
        List<List<Integer>> codeRecList = buildCodeRec(IntStream.rangeClosed(MIN_VAL, MAX_VAL).boxed().toList(), LENGTH);
        return codeRecList.stream().map(Code::new).toList();
    }

    private static List<List<Integer>> buildCodeRec(List<Integer> allValues, int size){
        if(size == 0){
            return List.of(List.of());
        } else {
            if(allValues.isEmpty()){
                return List.of();
            } else {
                return allValues.stream().flatMap(
                        currentValue -> buildCodeRec(allValues, size - 1).stream()
                                .map(integerList -> {
                                    List<Integer> newList = new ArrayList<>(integerList);
                                    newList.add(0, currentValue);
                                    return newList.stream().toList();
                                })
                ).toList();
            }
        }
    }

    public List<Code> getPossibleCode() {
        List<Code> allCodes = buildAllCode();
        return buildValidVerifieurs().stream().flatMap(predicates -> allCodes.stream().filter(predicates.stream().map(Predicat::predicat).reduce(x -> true, Predicate::and))).distinct().toList();
    }

    public List<Pair<List<Predicat>, List<Code>>> getPossibleCodeWithPredicat(){
        List<Code> allCodes = buildAllCode();
        return buildValidVerifieurs().stream().map(predicates -> {
            List<Code> listCode = allCodes.stream().filter(
                    predicates.stream().map(Predicat::predicat).reduce(x -> true, Predicate::and)
            ).toList();
            Pair<List<Predicat>, List<Code>> pairValue = new Pair(predicates, listCode);
            return pairValue;
        }).toList();
    }

    private List<List<Predicat>> buildValidVerifieurs() {
        List<List<Predicat>> filtredPredicateList = data.entrySet().stream().map(regleListEntry -> {
            List<Predicat> listPred = regleListEntry.getKey().verifieurs();
            List<Predicat> filtredList = new ArrayList<>();
            for (int i = 0; i < listPred.size(); i++) {
                if(regleListEntry.getValue().get(i)){
                    filtredList.add(listPred.get(i));
                }
            }
            return filtredList.stream().toList();
        }).toList();
        return buildVerifieurs(filtredPredicateList);
    }

    private List<List<Predicat>> buildVerifieurs(List<List<Predicat>> allverifieurList) {
        if(allverifieurList.isEmpty()){
            return List.of(List.of());
        } else {
            return allverifieurList.get(0).stream().flatMap(codePredicate ->
                    buildVerifieurs(allverifieurList.subList(1, allverifieurList.size())).stream().map(predicates -> {
                        List<Predicat> newList = new ArrayList<>(predicates);
                        newList.add(0, codePredicate);
                        return newList.stream().toList();
                    })
            ).toList();
        }
    }
}
