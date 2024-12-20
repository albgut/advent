package org.example._09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {
    private static final String INPUT_DECODE = "src/test/resources/_09/decodeData";
    private static final String INPUT_EXAMPLE = "src/test/resources/_09/example";

    @Test
    void decodeExample() {
        long result = Decoder.decode(INPUT_EXAMPLE);
        assertEquals(1928, result);
    }

    @Test
    void decodeInput() {
        long result = Decoder.decode(INPUT_DECODE);
        assertEquals(222, result);
    }

    @Test
    void decodeInputExampleSecondPart() {
        long result = Decoder.decodeSecondPart(INPUT_EXAMPLE);
        assertEquals(34, result);
    }

    @Test
    void decodeInputSecondPart() {
        long result = Decoder.decodeSecondPart(INPUT_DECODE);
        assertEquals(884, result);
    }
}