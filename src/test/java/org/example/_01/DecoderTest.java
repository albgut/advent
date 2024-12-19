package org.example._01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DecoderTest {

    private static final String INPUT_FILE_NAME = "src/test/resources/_01/inputSimple";
    private static final String INPUT_FILE_NAME_1 = "src/test/resources/_01/inputSimple-01";
    private static final String INPUT_FILE_NAME_ALL = "src/test/resources/_01/input1";

    @Test
    void twoListDistancesGoodResult() {
        int result = Decoder.decode(INPUT_FILE_NAME);
        Assertions.assertEquals(11, result);
    }

    @Test
    void twoListDistancesGoodResultLess() {
        int result = Decoder.decode(INPUT_FILE_NAME_1);
        Assertions.assertEquals(5, result);
    }

    @Test
    void twoListDistancesGoodResultAll() {
        int result = Decoder.decode(INPUT_FILE_NAME_ALL);
        Assertions.assertEquals(1110981, result);
    }

    @Test
    void SetwoListDistancesGoodResultAllSecond() {
        int result = Decoder.decodeSecondPart(INPUT_FILE_NAME_ALL);
        Assertions.assertEquals(24869388, result);
    }
}