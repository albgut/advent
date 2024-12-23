package org.example._12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecoderTest {
    private static final String INPUT_DECODE = "src/test/resources/_12/decodeData";
    private static final String INPUT_EXAMPLE = "src/test/resources/_12/example";
    private static final String INPUT_EXAMPLE_SIMPLE = "src/test/resources/_12/exampleSimple";
    private static final String INPUT_EXAMPLE_SIMPLE_BIS = "src/test/resources/_12/exampleSimpleBis";

    @Test
    void decodeExample() {
        long result = Decoder.decode(INPUT_EXAMPLE);
        assertEquals(1930, result);
    }

    @Test
    void decodeExampleSimple() {
        long result = Decoder.decode(INPUT_EXAMPLE_SIMPLE);
        assertEquals(772, result);
    }

    /*@Test
    void decodeExampleSimpleBis() {
        long result = Decoder.decode(INPUT_EXAMPLE_SIMPLE_BIS);
        assertEquals(140, result);
    }*/

    @Test
    void decodeExampleSimpleBis() {
        long result = Decoder.decode(INPUT_EXAMPLE_SIMPLE_BIS);
        assertEquals(148, result);
    }

    @Test
    void decodeInput() {
        long result = Decoder.decode(INPUT_DECODE);
        assertEquals(1483212, result);
    }

    @Test
    void decodeInputExampleSecondPart() {
        long result = Decoder.decodeSecondPart(INPUT_EXAMPLE);
        assertEquals(81, result);
    }

    @Test
    void decodeInputSecondPart() {
        long result = Decoder.decodeSecondPart(INPUT_DECODE);
        assertEquals(199982, result);
    }
}