package org.example._10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {
    private static final String INPUT_DECODE = "src/test/resources/_10/decodeData";
    private static final String INPUT_EXAMPLE = "src/test/resources/_10/example";

    @Test
    void decodeExample() {
        long result = Decoder.decode(INPUT_EXAMPLE);
        assertEquals(36, result);
    }

    @Test
    void decodeInput() {
        long result = Decoder.decode(INPUT_DECODE);
        assertEquals(820, result);
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