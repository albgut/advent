package org.example._11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {
    private static final String INPUT_DECODE = "src/test/resources/_11/decodeData";
    private static final String INPUT_EXAMPLE = "src/test/resources/_11/example";

    @Test
    void decodeExample() {
        long result = Decoder.decode(INPUT_EXAMPLE);
        assertEquals(55312, result);
    }

    @Test
    void decodeInput() {
        long result = Decoder.decode(INPUT_DECODE);
        assertEquals(199982, result);
    }

    @Test
    void decodeInputExampleSecondPart() {
        long result = Decoder.decodeSecondPart(INPUT_EXAMPLE);
        assertEquals(81, result);
    }

    @Test
    void decodeInputSecondPart() {
        long result = Decoder.decodeSecondPart(INPUT_DECODE);
        assertEquals(1786, result);
    }
}