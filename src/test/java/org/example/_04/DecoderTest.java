package org.example._04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private static final String INPUT_DECODE = "src/test/resources/_04/decodeData";
    private static final String INPUT_EXAMPLE = "src/test/resources/_04/example";
    private static final String INPUT_EXAMPLE_TWO = "src/test/resources/_04/exampletwo";

    @Test
    void decodeExample() {
        int result = Decoder.decode(INPUT_EXAMPLE);
        assertEquals(18, result);
    }

    @Test
    void decodeInput() {
        int result = Decoder.decode(INPUT_DECODE);
        assertEquals(2464, result);
    }

    @Test
    void decodeInputExampleSecondPart() {
        int result = Decoder.decodeSecondPart(INPUT_EXAMPLE_TWO);
        assertEquals(9, result);
    }

    @Test
    void decodeInputSecondPart() {
        int result = Decoder.decodeSecondPart(INPUT_DECODE);
        assertEquals(1982, result);
    }
}