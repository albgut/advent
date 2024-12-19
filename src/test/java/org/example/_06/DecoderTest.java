package org.example._06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private static final String INPUT_DECODE = "src/test/resources/_06/decodeData";
    private static final String INPUT_EXAMPLE = "src/test/resources/_06/example";

    @Test
    void decodeExample() {
        int result = Decoder.decode(INPUT_EXAMPLE);
        assertEquals(41, result);
    }

    @Test
    void decodeInput() {
        int result = Decoder.decode(INPUT_DECODE);
        assertEquals(5199, result);
    }

    @Test
    void decodeInputExampleSecondPart() {
        int result = Decoder.decodeSecondPart(INPUT_EXAMPLE);
        assertEquals(6, result);
    }

    @Test
    void decodeInputSecondPart() {
        int result = Decoder.decodeSecondPart(INPUT_DECODE);
        assertEquals(1915, result);
    }
}