package org.example.model;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RegleBuilder {

    public static @NotNull Regle buildRegle1(){
        Predicat verif1_1 = new Predicat("verif1_1", (code) -> code.getFirst() == 1);
        Predicat verif1_2 = new Predicat("verif1_2", (code) -> code.getFirst() > 1);
        List<Predicat> verifieurs1 = List.of(verif1_1, verif1_2);
        return new Regle(1, "Triangle par rapport à 1", verifieurs1);
    }

    public static @NotNull Regle buildRegle2(){
        Predicat verif2_1 = new Predicat("verif2_1", (code) -> code.getFirst() < 3);
        Predicat verif2_2 = new Predicat("verif2_2", (code) -> code.getFirst() == 3);
        Predicat verif2_3 = new Predicat("verif2_3", (code) -> code.getFirst() > 3);
        List<Predicat> verifieurs2 = List.of(verif2_1, verif2_2, verif2_3);
        return new Regle(2, "Triangle par rapport à 3", verifieurs2);
    }

    public static @NotNull Regle buildRegle3(){
        Predicat verif3_1 = new Predicat("verif3_1", (code) -> code.getSecond() < 3);
        Predicat verif3_2 = new Predicat("verif3_2", (code) -> code.getSecond() == 3);
        Predicat verif3_3 = new Predicat("verif3_3", (code) -> code.getSecond() > 3);
        List<Predicat> verifieurs3 = List.of(verif3_1, verif3_2, verif3_3);
        return new Regle(3, "Carré par rapport à 3", verifieurs3);
    }

    public static @NotNull Regle buildRegle4(){
        Predicat verif4_1 = new Predicat("verif4_1", (code) -> code.getSecond() < 4);
        Predicat verif4_2 = new Predicat("verif4_2", (code) -> code.getSecond() == 4);
        Predicat verif4_3 = new Predicat("verif4_3", (code) -> code.getSecond() > 4);
        List<Predicat> verifieurs4 = List.of(verif4_1, verif4_2, verif4_3);
        return new Regle(4, "Carré par rapport à 4", verifieurs4);
    }

    public static @NotNull Regle buildRegle5(){
        Predicat verif5_1 = new Predicat("verif5_1", (code) -> code.getFirst() % 2 == 0);
        Predicat verif5_2 = new Predicat("verif5_2", (code) -> code.getFirst() % 2 == 1);
        List<Predicat> verifieurs5 = List.of(verif5_1, verif5_2);
        return new Regle(5, "Parité triangle", verifieurs5);
    }

    public static @NotNull Regle buildRegle6(){
        Predicat verif6_1 = new Predicat("verif6_1", (code) -> code.getSecond() % 2 == 0);
        Predicat verif6_2 = new Predicat("verif6_2", (code) -> code.getSecond() % 2 == 1);
        List<Predicat> verifieurs6 = List.of(verif6_1, verif6_2);
        return new Regle(6, "Carré parité", verifieurs6);
    }

    public static @NotNull Regle buildRegle7(){
        Predicat verif7_1 = new Predicat("verif7_1", (code) -> code.getThird() % 2 == 0);
        Predicat verif7_2 = new Predicat("verif7_2", (code) -> code.getThird() % 2 == 1);
        List<Predicat> verifieurs7 = List.of(verif7_1, verif7_2);
        return new Regle(7, "Rond parité", verifieurs7);
    }

    public static @NotNull Regle buildRegle8(){
        Predicat verif8_1 = new Predicat("verif8_1", (code) -> code.getOne() == 0);
        Predicat verif8_2 = new Predicat("verif8_2", (code) -> code.getOne() == 1);
        Predicat verif8_3 = new Predicat("verif8_3", (code) -> code.getOne() == 2);
        Predicat verif8_4 = new Predicat("verif8_4", (code) -> code.getOne() == 3);
        List<Predicat> verifieurs8 = List.of(verif8_1, verif8_2, verif8_3, verif8_4);
        return new Regle(8, "Nombre de un", verifieurs8);
    }

    public static @NotNull Regle buildRegle9(){
        Predicat verif9_1 = new Predicat("verif9_1", (code) -> code.getThree() == 0);
        Predicat verif9_2 = new Predicat("verif9_2", (code) -> code.getThree() == 1);
        Predicat verif9_3 = new Predicat("verif9_3", (code) -> code.getThree() == 2);
        Predicat verif9_4 = new Predicat("verif9_4", (code) -> code.getThree() == 3);
        List<Predicat> verifieurs9 = List.of(verif9_1, verif9_2, verif9_3, verif9_4);
        return new Regle(9, "Nombre de trois", verifieurs9);
    }

    public static @NotNull Regle buildRegle10(){
        Predicat verif10_1 = new Predicat("verif10_1", (code) -> code.getFour() == 0);
        Predicat verif10_2 = new Predicat("verif10_2", (code) -> code.getFour() == 1);
        Predicat verif10_3 = new Predicat("verif10_3", (code) -> code.getFour() == 2);
        Predicat verif10_4 = new Predicat("verif10_4", (code) -> code.getFour() == 3);
        List<Predicat> verifieurs10 = List.of(verif10_1, verif10_2, verif10_3, verif10_4);
        return new Regle(10, "Nombre de quatre", verifieurs10);
    }

    public static @NotNull Regle buildRegle11(){
        Predicat verif11_1 = new Predicat("verif11_1", (code) -> code.getFirst() < code.getSecond());
        Predicat verif11_2 = new Predicat("verif11_2", (code) -> code.getFirst() == code.getSecond());
        Predicat verif11_3 = new Predicat("verif11_3", (code) -> code.getFirst() > code.getSecond());
        List<Predicat> verifieurs11 = List.of(verif11_1, verif11_2, verif11_3);
        return new Regle(11, "Triangle par rapport à Carré", verifieurs11);
    }

    public static @NotNull Regle buildRegle12(){
        Predicat verif12_1 = new Predicat("verif12_1", (code) -> code.getThird() < code.getFirst());
        Predicat verif12_2 = new Predicat("verif12_2", (code) -> code.getThird() == code.getFirst());
        Predicat verif12_3 = new Predicat("verif12_3", (code) -> code.getThird() > code.getFirst());
        List<Predicat> verifieurs12 = List.of(verif12_1, verif12_2, verif12_3);
        return new Regle(12, "Triangle par rapport à Rond", verifieurs12);
    }

    public static @NotNull Regle buildRegle13(){
        Predicat verif13_1 = new Predicat("verif13_1", (code) -> code.getSecond() < code.getFirst());
        Predicat verif13_2 = new Predicat("verif13_2", (code) -> code.getSecond() == code.getFirst());
        Predicat verif13_3 = new Predicat("verif13_3", (code) -> code.getSecond() > code.getFirst());
        List<Predicat> verifieurs13 = List.of(verif13_1, verif13_2, verif13_3);
        return new Regle(13, "Carré par rapport à Rond", verifieurs13);
    }

    public static @NotNull Regle buildRegle14(){
        Predicat verif14_1 = new Predicat("verif14_1", (code) -> code.getFirst() < code.getSecond() && code.getFirst() < code.getThird());
        Predicat verif14_2 = new Predicat("verif14_2", (code) -> code.getSecond() < code.getFirst() && code.getSecond() < code.getThird());
        Predicat verif14_3 = new Predicat("verif14_3", (code) -> code.getThird() < code.getFirst() && code.getThird() < code.getSecond());
        List<Predicat> verifieurs14 = List.of(verif14_1, verif14_2, verif14_3);
        return new Regle(14, "Le plus petit strict", verifieurs14);
    }

    public static @NotNull Regle buildRegle15(){
        Predicat verif15_1 = new Predicat("verif15_1", (code) -> code.getFirst() > code.getSecond() && code.getFirst() > code.getThird());
        Predicat verif15_2 = new Predicat("verif15_2", (code) -> code.getSecond() > code.getFirst() && code.getSecond() > code.getThird());
        Predicat verif15_3 = new Predicat("verif15_3", (code) -> code.getThird() > code.getFirst() && code.getThird() > code.getSecond());
        List<Predicat> verifieurs15 = List.of(verif15_1, verif15_2, verif15_3);
        return new Regle(15, "Le plus grand strict", verifieurs15);
    }

    public static @NotNull Regle buildRegle16(){
        Predicat verif16_1 = new Predicat("verif16_1", (code) -> code.getPair() > code.getImpair());
        Predicat verif16_2 = new Predicat("veri16_2", (code) -> code.getImpair() > code.getPair());
        List<Predicat> verifieurs16 = List.of(verif16_1, verif16_2);
        return new Regle(16, "Compare la différence entre pair et impair", verifieurs16);
    }

    public static @NotNull Regle buildRegle17() {
        Predicat verif17_1 = new Predicat("verif17_1", (code) -> code.getPair() == 0);
        Predicat verif17_2 = new Predicat("verif17_2", (code) -> code.getPair() == 1);
        Predicat verif17_3 = new Predicat("verif17_3", (code) -> code.getPair() == 2);
        Predicat verif17_4 = new Predicat("verif17_4", (code) -> code.getPair() == 3);
        List<Predicat> verifieurs17 = List.of(verif17_1, verif17_2, verif17_3, verif17_4);
        return new Regle(17, "Nombre de valeurs pairs", verifieurs17);
    }

    public static @NotNull Regle buildRegle18() {
        Predicat verif18_1 = new Predicat("verif18_1", (code) -> code.getSomme() % 2 == 0);
        Predicat verif18_2 = new Predicat("verif18_2", (code) -> code.getSomme() % 2 == 1);
        List<Predicat> verifieurs18 = List.of(verif18_1, verif18_2);
        return new Regle(18, "Parité somme totale", verifieurs18);
    }

    public static @NotNull Regle buildRegle19() {
        Predicat verif19_1 = new Predicat("verif19_1", (code) -> code.getSommeFirstSecond() < 6);
        Predicat verif19_2 = new Predicat("verif19_2", (code) -> code.getSommeFirstSecond() == 6);
        Predicat verif19_3 = new Predicat("verif19_3", (code) -> code.getSommeFirstSecond() > 6);
        List<Predicat> verifieurs19 = List.of(verif19_1, verif19_2, verif19_3);
        return new Regle(19, "Somme de Carré et triangle par rapport à 6", verifieurs19);
    }

    public static @NotNull Regle buildRegle20() {
        Predicat verif20_1 = new Predicat("verif20_1", Code::sameValue);
        Predicat verif20_2 = new Predicat("verif20_2", Code::sameTwoValues);
        Predicat verif20_3 = new Predicat("verif20_3", Code::allDifferent);
        List<Predicat> verifieurs20 = List.of(verif20_1, verif20_2, verif20_3);
        return new Regle(20, "Si une valeur se répète dans le code", verifieurs20);
    }

    public static @NotNull Regle buildRegle21() {
        Predicat verif21_1 = new Predicat("verif21_1", (code) -> !code.sameTwoValues());
        Predicat verif21_2 = new Predicat("verif21_2", Code::sameTwoValues);
        List<Predicat> verifieurs21 = List.of(verif21_1, verif21_2);
        return new Regle(21, "Si une valeur jumelle existe", verifieurs21);
    }

    public static @NotNull Regle buildRegle22() {
        Predicat verif22_1 = new Predicat("verif22_1", Code::isCroissant);
        Predicat verif22_2 = new Predicat("verif22_2", Code::isDecroissant);
        Predicat verif22_3 = new Predicat("verif22_3", Code::isNotMonotone);
        List<Predicat> verifieurs22 = List.of(verif22_1, verif22_2, verif22_3);
        return new Regle(22, "Séquence décroissante, croissante stricte ou aucun des deux", verifieurs22);
    }

    public static @NotNull Regle buildRegle23() {
        Predicat verif23_1 = new Predicat("verif23_1", (code) -> code.getSomme() < 6);
        Predicat verif23_2 = new Predicat("verif23_2", (code) -> code.getSomme() == 6);
        Predicat verif23_3 = new Predicat("verif23_3", (code) -> code.getSomme() > 6);
        List<Predicat> verifieurs23 = List.of(verif23_1, verif23_2, verif23_3);
        return new Regle(23, "Somme de toutes les valeurs comparée à six", verifieurs23);
    }

    public static @NotNull Regle buildRegle24() {
        Predicat verif24_1 = new Predicat("verif24_1", Code::allConsecutiveCroissantValues);
        Predicat verif24_2 = new Predicat("verif24_2", Code::twoConsecutiveCroissantValues);
        Predicat verif24_3 = new Predicat("verif24_3", Code::noneConsecutiveCroissantValues);
        List<Predicat> verifieurs24 = List.of(verif24_1, verif24_2, verif24_3);
        return new Regle(24, "Nombre de valeurs consécutives croissantes", verifieurs24);
    }

    public static @NotNull Regle buildRegle25() {
        Predicat verif25_1 = new Predicat("verif25_1", (code) -> code.noneConsecutiveCroissantValues() && code.noneConsecutiveDecroissantValues());
        Predicat verif25_2 = new Predicat("verif25_2", (code) -> code.twoConsecutiveCroissantValues() || code.twoConsecutiveDecroissantValues());
        Predicat verif25_3 = new Predicat("verif25_3", (code) -> code.allConsecutiveCroissantValues() || code.allConsecutiveDecroissantValues());
        List<Predicat> verifieurs25 = List.of(verif25_1, verif25_2, verif25_3);
        return new Regle(25, "Nombre de valeurs consécutives croissantes ou décroissantes", verifieurs25);
    }

    public static @NotNull Regle buildRegle26() {
        Predicat verif26_1 = new Predicat("verif26_1", (code) -> code.getFirst() < 3);
        Predicat verif26_2 = new Predicat("verif26_2", (code) -> code.getSecond() < 3);
        Predicat verif26_3 = new Predicat("verif26_3", (code) -> code.getThird() < 3);
        List<Predicat> verifieurs26 = List.of(verif26_1, verif26_2, verif26_3);
        return new Regle(26, "Une couleur spécifique inférieure à trois", verifieurs26);
    }

    public static @NotNull Regle buildRegle27() {
        Predicat verif27_1 = new Predicat("verif27_1", (code) -> code.getFirst() < 4);
        Predicat verif27_2 = new Predicat("verif27_2", (code) -> code.getSecond() < 4);
        Predicat verif27_3 = new Predicat("verif27_3", (code) -> code.getThird() < 4);
        List<Predicat> verifieurs27 = List.of(verif27_1, verif27_2, verif27_3);
        return new Regle(27, "Une couleur spécifique inférieure à quatre", verifieurs27);
    }

    public static @NotNull Regle buildRegle28() {
        Predicat verif28_1 = new Predicat("verif28_1", (code) -> code.getFirst() == 1);
        Predicat verif28_2 = new Predicat("verif28_2", (code) -> code.getSecond() == 1);
        Predicat verif28_3 = new Predicat("verif28_3", (code) -> code.getThird() == 1);
        List<Predicat> verifieurs28 = List.of(verif28_1, verif28_2, verif28_3);
        return new Regle(28, "Une couleur spécifique égale à un", verifieurs28);
    }

    public static @NotNull Regle buildRegle29() {
        Predicat verif29_1 = new Predicat("verif29_1", (code) -> code.getFirst() == 3);
        Predicat verif29_2 = new Predicat("verif29_2", (code) -> code.getSecond() == 3);
        Predicat verif29_3 = new Predicat("verif29_3", (code) -> code.getThird() == 3);
        List<Predicat> verifieurs29 = List.of(verif29_1, verif29_2, verif29_3);
        return new Regle(29, "Une couleur spécifique égale à trois", verifieurs29);
    }

    public static @NotNull Regle buildRegle30() {
        Predicat verif30_1 = new Predicat("verif30_1", (code) -> code.getFirst() == 4);
        Predicat verif30_2 = new Predicat("verif30_2", (code) -> code.getSecond() == 4);
        Predicat verif30_3 = new Predicat("verif30_3", (code) -> code.getThird() == 4);
        List<Predicat> verifieurs30 = List.of(verif30_1, verif30_2, verif30_3);
        return new Regle(30, "Une couleur spécifique égale à quatre", verifieurs30);
    }

    public static @NotNull Regle buildRegle31() {
        Predicat verif31_1 = new Predicat("verif31_1", (code) -> code.getFirst() > 1);
        Predicat verif31_2 = new Predicat("verif31_2", (code) -> code.getSecond() > 1);
        Predicat verif31_3 = new Predicat("verif31_3", (code) -> code.getThird() > 1);
        List<Predicat> verifieurs31 = List.of(verif31_1, verif31_2, verif31_3);
        return new Regle(31, "Une couleur spécifique supérieure à un", verifieurs31);
    }

    public static @NotNull Regle buildRegle32() {
        Predicat verif32_1 = new Predicat("verif32_1", (code) -> code.getFirst() > 3);
        Predicat verif32_2 = new Predicat("verif32_2", (code) -> code.getSecond() > 3);
        Predicat verif32_3 = new Predicat("verif32_3", (code) -> code.getThird() > 3);
        List<Predicat> verifieurs32 = List.of(verif32_1, verif32_2, verif32_3);
        return new Regle(32, "Une couleur spécifique supérieure à trois", verifieurs32);
    }

    public static @NotNull Regle buildRegle33() {
        Predicat verif33_1 = new Predicat("verif33_1", (code) -> code.getFirst() % 2 == 0);
        Predicat verif33_2 = new Predicat("verif33_2", (code) -> code.getSecond() % 2 == 0);
        Predicat verif33_3 = new Predicat("verif33_3", (code) -> code.getThird() % 2 == 0);
        Predicat verif33_4 = new Predicat("verif33_4", (code) -> code.getFirst() % 2 == 1);
        Predicat verif33_5 = new Predicat("verif33_5", (code) -> code.getSecond() % 2 == 1);
        Predicat verif33_6 = new Predicat("verif33_6", (code) -> code.getThird() % 2 == 1);
        List<Predicat> verifieurs33 = List.of(verif33_1, verif33_2, verif33_3, verif33_4, verif33_5, verif33_6);
        return new Regle(33, "Une couleur spécifique est paire ou impaire", verifieurs33);
    }

    public static @NotNull Regle buildRegle34() {
        Predicat verif34_1 = new Predicat("verif34_1", (code) -> code.getFirst() <= code.getSecond() && code.getFirst() <= code.getThird());
        Predicat verif34_2 = new Predicat("verif34_2", (code) -> code.getSecond() <= code.getFirst() && code.getSecond() <= code.getThird());
        Predicat verif34_3 = new Predicat("verif34_3", (code) -> code.getThird() <= code.getFirst() && code.getThird() <= code.getSecond());
        List<Predicat> verifieurs34 = List.of(verif34_1, verif34_2, verif34_3);
        return new Regle(34, "Une couleur spécifique inférieure ou égale aux autres", verifieurs34);
    }

    public static @NotNull Regle buildRegle35() {
        Predicat verif35_1 = new Predicat("verif35_1", (code) -> code.getFirst() >= code.getSecond() && code.getFirst() >= code.getThird());
        Predicat verif35_2 = new Predicat("verif35_2", (code) -> code.getSecond() >= code.getFirst() && code.getSecond() >= code.getThird());
        Predicat verif35_3 = new Predicat("verif35_3", (code) -> code.getThird() >= code.getFirst() && code.getThird() >= code.getSecond());
        List<Predicat> verifieurs35 = List.of(verif35_1, verif35_2, verif35_3);
        return new Regle(35, "Une couleur spécifique supérieure ou égale aux autres", verifieurs35);
    }

    public static @NotNull Regle buildRegle36() {
        Predicat verif36_1 = new Predicat("verif36_1", (code) -> code.getSomme() % 3 == 0);
        Predicat verif36_2 = new Predicat("verif36_2", (code) -> code.getSomme() % 4 == 0);
        Predicat verif36_3 = new Predicat("verif36_3", (code) -> code.getSomme() % 5 == 0);
        List<Predicat> verifieurs36 = List.of(verif36_1, verif36_2, verif36_3);
        return new Regle(36, "Somme des valeurs multiple de trois, quatre ou cinq", verifieurs36);
    }

    public static @NotNull Regle buildRegle37() {
        Predicat verif37_1 = new Predicat("verif37_1", (code) -> code.getSommeFirstSecond() == 4);
        Predicat verif37_2 = new Predicat("verif37_2", (code) -> code.getSommeFirstThird() == 4);
        Predicat verif37_3 = new Predicat("verif37_3", (code) -> code.getSommeSecondThird() == 4);
        List<Predicat> verifieurs37 = List.of(verif37_1, verif37_2, verif37_3);
        return new Regle(37, "Somme de deux valeurs spécifique égale à quatre", verifieurs37);
    }

    public static @NotNull Regle buildRegle38() {
        Predicat verif38_1 = new Predicat("verif38_1", (code) -> code.getSommeFirstSecond() == 6);
        Predicat verif38_2 = new Predicat("verif38_2", (code) -> code.getSommeFirstThird() == 6);
        Predicat verif38_3 = new Predicat("verif38_3", (code) -> code.getSommeSecondThird() == 6);
        List<Predicat> verifieurs38 = List.of(verif38_1, verif38_2, verif38_3);
        return new Regle(38, "Somme de deux valeurs spécifique égale à six", verifieurs38);
    }

    public static @NotNull Regle buildRegle39() {
        Predicat verif39_1 = new Predicat("verif39_1", (code) -> code.getFirst() == 1);
        Predicat verif39_2 = new Predicat("verif39_2", (code) -> code.getSecond() == 1);
        Predicat verif39_3 = new Predicat("verif39_3", (code) -> code.getThird() == 1);
        Predicat verif39_4 = new Predicat("verif39_4", (code) -> code.getFirst() > 1);
        Predicat verif39_5 = new Predicat("verif39_5", (code) -> code.getSecond() > 1);
        Predicat verif39_6 = new Predicat("verif39_6", (code) -> code.getThird() > 1);
        List<Predicat> verifieurs39 = List.of(verif39_1, verif39_2, verif39_3, verif39_4, verif39_5, verif39_6);
        return new Regle(39, "Une valeur spécifique par rapport à un", verifieurs39);
    }

    public static @NotNull Regle buildRegle45() {
        Predicat verif45_1 = new Predicat("verif45_1", (code) -> code.getOne() == 0);
        Predicat verif45_2 = new Predicat("verif45_2", (code) -> code.getOne() == 1);
        Predicat verif45_3 = new Predicat("verif45_3", (code) -> code.getOne() == 2);
        Predicat verif45_4 = new Predicat("verif45_4", (code) -> code.getOne() == 3);
        Predicat verif45_5 = new Predicat("verif45_5", (code) -> code.getThree() == 0);
        Predicat verif45_6 = new Predicat("verif45_6", (code) -> code.getThree() == 1);
        Predicat verif45_7 = new Predicat("verif45_7", (code) -> code.getThree() == 2);
        Predicat verif45_8 = new Predicat("verif45_8", (code) -> code.getThree() == 3);
        List<Predicat> verifieurs45 = List.of(verif45_1, verif45_2, verif45_3, verif45_4, verif45_5, verif45_6, verif45_7, verif45_8);
        return new Regle(45, "Combien il y a de un OU combien il y a de trois", verifieurs45);
    }

    public static @NotNull Regle buildRegle46() {
        Predicat verif46_1 = new Predicat("verif46_1", (code) -> code.getThree() == 0);
        Predicat verif46_2 = new Predicat("verif46_2", (code) -> code.getThree() == 1);
        Predicat verif46_3 = new Predicat("verif46_3", (code) -> code.getThree() == 2);
        Predicat verif46_4 = new Predicat("verif46_4", (code) -> code.getThree() == 3);
        Predicat verif46_5 = new Predicat("verif46_5", (code) -> code.getFour() == 0);
        Predicat verif46_6 = new Predicat("verif46_6", (code) -> code.getFour() == 1);
        Predicat verif46_7 = new Predicat("verif46_7", (code) -> code.getFour() == 2);
        Predicat verif46_8 = new Predicat("verif46_8", (code) -> code.getFour() == 3);
        List<Predicat> verifieurs46 = List.of(verif46_1, verif46_2, verif46_3, verif46_4, verif46_5, verif46_6, verif46_7, verif46_8);
        return new Regle(46, "Combien il y a de trois OU combien il y a de quatre", verifieurs46);
    }

    public static @NotNull Regle buildRegle48() {
        Predicat verif48_1 = new Predicat("verif48_1", (code) -> code.getFirst() < code.getSecond());
        Predicat verif48_2 = new Predicat("verif48_2", (code) -> code.getFirst() < code.getThird());
        Predicat verif48_3 = new Predicat("verif48_3", (code) -> code.getSecond() < code.getThird());
        Predicat verif48_4 = new Predicat("verif48_4", (code) -> code.getFirst() == code.getSecond());
        Predicat verif48_5 = new Predicat("verif48_5", (code) -> code.getFirst() == code.getThird());
        Predicat verif48_6 = new Predicat("verif48_6", (code) -> code.getSecond() == code.getThird());
        Predicat verif48_7 = new Predicat("verif48_7", (code) -> code.getFirst() > code.getSecond());
        Predicat verif48_8 = new Predicat("verif48_8", (code) -> code.getFirst() > code.getThird());
        Predicat verif48_9 = new Predicat("verif48_9", (code) -> code.getSecond() > code.getThird());
        List<Predicat> verifieurs48 = List.of(verif48_1, verif48_2, verif48_3, verif48_4, verif48_5, verif48_6, verif48_7, verif48_8, verif48_9);
        return new Regle(48, "Une couleur spécifique par rapport à une autre couleur spécifique", verifieurs48);
    }
}
