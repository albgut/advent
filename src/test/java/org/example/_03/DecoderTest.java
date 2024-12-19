package org.example._03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private static final String INPUT_DECODE = "src/test/resources/_03/decodeData";
    private static final String INPUT_EXAMPLE = "src/test/resources/_03/example";
    private static final String INPUT_EXAMPLE_TWO = "src/test/resources/_03/exampletwo";

    @Test
    void decodeExample() {
        int result = org.example._03.Decoder.decode(INPUT_EXAMPLE);
        assertEquals(161, result);
    }

    @Test
    void decodeInput() {
        int result = org.example._03.Decoder.decode(INPUT_DECODE);
        assertEquals(185797128, result);
    }

    @Test
    void decodeInputExampleSecondPart() {
        int result = org.example._03.Decoder.decodeSecondPart(INPUT_EXAMPLE_TWO);
        assertEquals(48, result);
    }

    @Test
    void decodeInputSecondPart() {
        int result = Decoder.decodeSecondPart(INPUT_DECODE);
        assertEquals(89798695, result);
    }
}