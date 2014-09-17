package nl.dvberkel.kata.base64;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static nl.dvberkel.kata.base64.Base64EncodeTestCase.verifyThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class Base64EncodeTest {
    private final byte[] source;
    private final String destination;

    private Kata kata;

    public Base64EncodeTest(Base64EncodeTestCase testCase) {
        this.source = testCase.getSource();
        this.destination = testCase.getDestination();
    }

    @Before
    public void createKata() {
        kata = new Kata();
    }

    @Test
    public void shouldEncodeValuesCorrectly() {
        assertThat(kata.encode(source), is(destination));
    }

    @Parameterized.Parameters
    public static Collection<Base64EncodeTestCase[]> data() {
        List<Base64EncodeTestCase[]> data = new ArrayList<>();
        data.add(verifyThat(0b0, 0b0, 0b0).encodesAs("AAAA"));
        data.add(verifyThat(0b0, 0b0, 0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAAAA"));
        data.add(verifyThat(0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAAAAAAAA"));
        data.add(verifyThat(0b0, 0b0).encodesAs("AAA="));
        data.add(verifyThat(0b0).encodesAs("AA=="));
        data.add(verifyThat(0b0, 0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAAA="));
        data.add(verifyThat(0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAA=="));
        data.add(verifyThat(0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAAAAAAA="));
        data.add(verifyThat(0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAAAAAA=="));
        data.add(verifyThat(0b0, 0b0, 0b00000001).encodesAs("AAAB"));
        data.add(verifyThat(0b0, 0b0, 0b00000010).encodesAs("AAAC"));
        data.add(verifyThat(0b0, 0b0, 0b00000011).encodesAs("AAAD"));
        data.add(verifyThat(0b0, 0b0, 0b00000100).encodesAs("AAAE"));
        data.add(verifyThat(0b0, 0b0, 0b00000101).encodesAs("AAAF"));
        data.add(verifyThat(0b0, 0b0, 0b00000110).encodesAs("AAAG"));
        data.add(verifyThat(0b0, 0b0, 0b00000111).encodesAs("AAAH"));
        data.add(verifyThat(0b0, 0b0, 0b00001000).encodesAs("AAAI"));
        data.add(verifyThat(0b0, 0b0, 0b00001001).encodesAs("AAAJ"));
        data.add(verifyThat(0b0, 0b0, 0b00001010).encodesAs("AAAK"));
        data.add(verifyThat(0b0, 0b0, 0b00001011).encodesAs("AAAL"));
        data.add(verifyThat(0b0, 0b0, 0b00001100).encodesAs("AAAM"));
        data.add(verifyThat(0b0, 0b0, 0b00001101).encodesAs("AAAN"));
        data.add(verifyThat(0b0, 0b0, 0b00001110).encodesAs("AAAO"));
        data.add(verifyThat(0b0, 0b0, 0b00001111).encodesAs("AAAP"));
        data.add(verifyThat(0b0, 0b0, 0b00010000).encodesAs("AAAQ"));
        data.add(verifyThat(0b0, 0b0, 0b00010001).encodesAs("AAAR"));
        data.add(verifyThat(0b0, 0b0, 0b00010010).encodesAs("AAAS"));
        data.add(verifyThat(0b0, 0b0, 0b00010011).encodesAs("AAAT"));
        data.add(verifyThat(0b0, 0b0, 0b00010100).encodesAs("AAAU"));
        data.add(verifyThat(0b0, 0b0, 0b00010101).encodesAs("AAAV"));
        data.add(verifyThat(0b0, 0b0, 0b00010110).encodesAs("AAAW"));
        data.add(verifyThat(0b0, 0b0, 0b00010111).encodesAs("AAAX"));
        data.add(verifyThat(0b0, 0b0, 0b00011000).encodesAs("AAAY"));
        data.add(verifyThat(0b0, 0b0, 0b00011001).encodesAs("AAAZ"));
        data.add(verifyThat(0b0, 0b0, 0b00011010).encodesAs("AAAa"));
        data.add(verifyThat(0b0, 0b0, 0b00011011).encodesAs("AAAb"));
        data.add(verifyThat(0b0, 0b0, 0b00011100).encodesAs("AAAc"));
        data.add(verifyThat(0b0, 0b0, 0b00011101).encodesAs("AAAd"));
        data.add(verifyThat(0b0, 0b0, 0b00011110).encodesAs("AAAe"));
        data.add(verifyThat(0b0, 0b0, 0b00011111).encodesAs("AAAf"));
        data.add(verifyThat(0b0, 0b0, 0b00100000).encodesAs("AAAg"));
        data.add(verifyThat(0b0, 0b0, 0b00100001).encodesAs("AAAh"));
        data.add(verifyThat(0b0, 0b0, 0b00100010).encodesAs("AAAi"));
        data.add(verifyThat(0b0, 0b0, 0b00100011).encodesAs("AAAj"));
        data.add(verifyThat(0b0, 0b0, 0b00100100).encodesAs("AAAk"));
        data.add(verifyThat(0b0, 0b0, 0b00100101).encodesAs("AAAl"));
        data.add(verifyThat(0b0, 0b0, 0b00100110).encodesAs("AAAm"));
        data.add(verifyThat(0b0, 0b0, 0b00100111).encodesAs("AAAn"));
        data.add(verifyThat(0b0, 0b0, 0b00101000).encodesAs("AAAo"));
        data.add(verifyThat(0b0, 0b0, 0b00101001).encodesAs("AAAp"));
        data.add(verifyThat(0b0, 0b0, 0b00101010).encodesAs("AAAq"));
        data.add(verifyThat(0b0, 0b0, 0b00101011).encodesAs("AAAr"));
        data.add(verifyThat(0b0, 0b0, 0b00101100).encodesAs("AAAs"));
        data.add(verifyThat(0b0, 0b0, 0b00101101).encodesAs("AAAt"));
        data.add(verifyThat(0b0, 0b0, 0b00101110).encodesAs("AAAu"));
        data.add(verifyThat(0b0, 0b0, 0b00101111).encodesAs("AAAv"));
        data.add(verifyThat(0b0, 0b0, 0b00110000).encodesAs("AAAw"));
        data.add(verifyThat(0b0, 0b0, 0b00110001).encodesAs("AAAx"));
        data.add(verifyThat(0b0, 0b0, 0b00110010).encodesAs("AAAy"));
        data.add(verifyThat(0b0, 0b0, 0b00110011).encodesAs("AAAz"));
        data.add(verifyThat(0b0, 0b0, 0b00110100).encodesAs("AAA0"));
        data.add(verifyThat(0b0, 0b0, 0b00110101).encodesAs("AAA1"));
        data.add(verifyThat(0b0, 0b0, 0b00110110).encodesAs("AAA2"));
        data.add(verifyThat(0b0, 0b0, 0b00110111).encodesAs("AAA3"));
        data.add(verifyThat(0b0, 0b0, 0b00111000).encodesAs("AAA4"));
        data.add(verifyThat(0b0, 0b0, 0b00111001).encodesAs("AAA5"));
        data.add(verifyThat(0b0, 0b0, 0b00111010).encodesAs("AAA6"));
        data.add(verifyThat(0b0, 0b0, 0b00111011).encodesAs("AAA7"));
        data.add(verifyThat(0b0, 0b0, 0b00111100).encodesAs("AAA8"));
        data.add(verifyThat(0b0, 0b0, 0b00111101).encodesAs("AAA9"));
        data.add(verifyThat(0b0, 0b0, 0b00111110).encodesAs("AAA+"));
        data.add(verifyThat(0b0, 0b0, 0b00111111).encodesAs("AAA/"));
        data.add(verifyThat(0b0, 0b00000000, 0b01000000).encodesAs("AABA"));
        data.add(verifyThat(0b0, 0b00001111, 0b11000000).encodesAs("AA/A"));
        data.add(verifyThat(0b0, 0b00010000, 0b00000000).encodesAs("ABAA"));
        data.add(verifyThat(0b00000011, 0b11110000, 0b00000000).encodesAs("A/AA"));
        data.add(verifyThat(0b00000100, 0b00000000, 0b00000000).encodesAs("BAAA"));
        data.add(verifyThat(0b11111100, 0b00000000, 0b00000000).encodesAs("/AAA"));
        data.add(verifyThat(0b00000001).encodesAs("AQ=="));
        data.add(verifyThat(0b00000000, 0b000000001).encodesAs("AAE="));
        return data;
    }
}

class Base64EncodeTestCase {
    private final byte[] source;

    private String destination;

    public static Base64EncodeTestCase verifyThat(int... source) {
        byte[] bytes = new byte[source.length];
        for (int index = 0; index < source.length; index++) {
            bytes[index] = (byte) source[index];
        }
        return verifyThat(bytes);
    }

    public static Base64EncodeTestCase verifyThat(byte... source) {
        return new Base64EncodeTestCase(source);
    }

    private Base64EncodeTestCase(byte[] source) {
        this.source = source;
    }

    public Base64EncodeTestCase[] encodesAs(String destination) {
        this.destination = destination;

        return  new Base64EncodeTestCase[] { this };
    }

    public byte[] getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}

