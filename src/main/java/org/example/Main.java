package org.example;

import org.example.model.*;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        buildPartieDELAMORT();
//        Code code = new Code(List.of(1, 4, 2));
//        System.out.println(code.allConsecutiveCroissantValues() || code.allConsecutiveDecroissantValues());
//        System.out.println(code.twoConsecutiveCroissantValues() || code.twoConsecutiveDecroissantValues());
//        System.out.println(code.noneConsecutiveCroissantValues() && code.noneConsecutiveDecroissantValues());
//        System.out.println(code.noneConsecutiveDecroissantValues());
    }

    private static void buildPartieDELAMORT(){
        Map<Regle, List<Boolean>> mapData = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle21(), List.of(true, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle25(), List.of(false, true, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle36(), List.of(true, true, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle39(), List.of(false, false, false, true, true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle46(), List.of(false, true, false, false, true, true, false, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle48(), List.of(true, true, true, true, true, true, true, true, true))
        );

        ControllerNaif controllerNaif = new ControllerNaif(mapData);

        List<Pair<List<Predicat>, List<Code>>> result = controllerNaif.getPossibleCodeWithPredicat();
        printResult(result);
    }

    private static void buildPartieC63_8E9_7(){
        Map<Regle, List<Boolean>> mapData = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle3(), List.of(false, true, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle21(), List.of(true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle23(), List.of(false, false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle24(), List.of(true, false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle34(), List.of(true, true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle45(), List.of(true, true, true, true, true, true, true, true))
        );

        ControllerNaif controllerNaif = new ControllerNaif(mapData);

        List<Pair<List<Predicat>, List<Code>>> result = controllerNaif.getPossibleCodeWithPredicat();
        printResult(result);
    }
    private static void buildPartieB5R_KHW(){
        Map<Regle, List<Boolean>> mapData = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle3(), List.of(false, true, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle7(), List.of(true, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle10(), List.of(true, true, true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle16(), List.of(true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle20(), List.of(false, true, false))
        );

        ControllerNaif controllerNaif = new ControllerNaif(mapData);

        List<Pair<List<Predicat>, List<Code>>> result = controllerNaif.getPossibleCodeWithPredicat();
        printResult(result);
    }

    private static void buildPartieB52_62S_F(){
        Map<Regle, List<Boolean>> mapData = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle4(), List.of(true, false, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle10(), List.of(false, true, false, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle18(), List.of(false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle19(), List.of(false, false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle22(), List.of(true, true, false))
        );

        ControllerNaif controllerNaif = new ControllerNaif(mapData);

        List<Pair<List<Predicat>, List<Code>>> result = controllerNaif.getPossibleCodeWithPredicat();
        printResult(result);
    }

    private static void buildPartieA51_K8J_9(){
        Map<Regle, List<Boolean>> mapData = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle3(), List.of(false, false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle5(), List.of(true, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle9(), List.of(true, true, false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle12(), List.of(true, true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle17(), List.of(true, false, true, true))
        );

        ControllerNaif controllerNaif = new ControllerNaif(mapData);

        List<Pair<List<Predicat>, List<Code>>> result = controllerNaif.getPossibleCodeWithPredicat();
        printResult(result);
    }

    private static void buildPartieA52_KM7_G(){
        Map<Regle, List<Boolean>> mapData = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle7(), List.of(false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle10(), List.of(false, true, false, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle12(), List.of(true, false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle14(), List.of(false, true, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle16(), List.of(false, true))
        );

        ControllerNaif controllerNaif = new ControllerNaif(mapData);

        controllerNaif.getPossibleCode().forEach(System.out::println);

        List<Pair<List<Predicat>, List<Code>>> result = controllerNaif.getPossibleCodeWithPredicat();
        printResult(result);
    }

    private static void buildPartieB51_EIF_C() {
        Map<Regle, List<Boolean>> mapData = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle2(), List.of(true, false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle14(), List.of(false, false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle17(), List.of(true, true, true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle20(), List.of(true, false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle22(), List.of(true, false, true))
        );
        ControllerNaif controllerNaif = new ControllerNaif(mapData);

//        controllerNaif.getPossibleCode().forEach(System.out::println);

        List<Pair<List<Predicat>, List<Code>>> result = controllerNaif.getPossibleCodeWithPredicat();
        printResult(result);
    }
    private static void buildPartieB51_V3U_2() {
        Map<Regle, List<Boolean>> mapData = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle2(), List.of(true, false, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle6(), List.of(false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle9(), List.of(true, true, true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle17(), List.of(false, false, true, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle20(), List.of(false, true, false))
        );
        ControllerNaif controllerNaif = new ControllerNaif(mapData);

//        controllerNaif.getPossibleCode().forEach(System.out::println);

        List<Pair<List<Predicat>, List<Code>>> result = controllerNaif.getPossibleCodeWithPredicat();
        printResult(result);
    }

    private static void buildPartie10() {
        Map<Regle, List<Boolean>> mapData = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle2(), List.of(true, true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle6(), List.of(true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle8(), List.of(true, true, true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle12(), List.of(true, true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle15(), List.of(true, true, true))
        );
        ControllerNaif controllerNaif = new ControllerNaif(mapData);

//        controllerNaif.getPossibleCode().forEach(System.out::println);

        List<Pair<List<Predicat>, List<Code>>> result = controllerNaif.getPossibleCodeWithPredicat();
        printResult(result);
    }

    private static void buildPartie1() {
        Map<Regle, List<Boolean>> mapData = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle4(), List.of(false, true, false)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle9(), List.of(true, false, true, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle11(), List.of(true, false, true)),
                new AbstractMap.SimpleEntry<>(RegleBuilder.buildRegle14(), List.of(false, false, true))
        );
        ControllerNaif controllerNaif = new ControllerNaif(mapData);

        List<Pair<List<Predicat>, List<Code>>> result = controllerNaif.getPossibleCodeWithPredicat();
        printResult(result);
    }

    private static void printResult(List<Pair<List<Predicat>, List<Code>>> result) {
        result.forEach(pair -> {
            String predicateString = pair.first().stream().map(Predicat::toString).collect(Collectors.joining(", "));
            String codeString = pair.second().stream().map(Code::toString).collect(Collectors.joining(" | "));
            if(!codeString.isEmpty() && pair.second().size() == 1) {
                System.out.println(predicateString);
                System.out.println(codeString);
                System.out.println();
            }
        });
    }
}