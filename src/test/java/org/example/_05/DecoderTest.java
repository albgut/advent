package org.example._05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private static final String INPUT_DECODE = "src/test/resources/_05/decodeData";
    private static final String INPUT_EXAMPLE = "src/test/resources/_05/example";

    @Test
    void decodeExample() {
        int result = Decoder.decode(INPUT_EXAMPLE);
        assertEquals(143, result);
    }

    @Test
    void decodeInput() {
        int result = Decoder.decode(INPUT_DECODE);
        assertEquals(5964, result);
    }

    @Test
    void decodeInputExampleSecondPart() {
        int result = Decoder.decodeSecondPart(INPUT_EXAMPLE);
        assertEquals(123, result);
    }

    @Test
    void decodeInputSecondPart() {
        int result = Decoder.decodeSecondPart(INPUT_DECODE);
        assertEquals(4719, result);
    }
}