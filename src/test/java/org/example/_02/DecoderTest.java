package org.example._02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private static final String INPUT_DECODE = "src/test/resources/_02/decodeData";
    private static final String INPUT_EXAMPLE = "src/test/resources/_02/example";

    @Test
    void decodeExample() {
        int result = Decoder.decode(INPUT_EXAMPLE);
        assertEquals(2, result);
    }

    @Test
    void decodeInput() {
        int result = Decoder.decode(INPUT_DECODE);
        assertEquals(246, result);
    }

    @Test
    void decodeInputExampleSecondPart() {
        int result = Decoder.decodeSecondPart(INPUT_EXAMPLE);
        assertEquals(4, result);
    }

    @Test
    void decodeInputSecondPart() {
        int result = Decoder.decodeSecondPart(INPUT_DECODE);
        assertEquals(318, result);
    }
}