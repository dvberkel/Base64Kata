package nl.dvberkel.kata.base64;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
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
    public static Collection<Object[]> data() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b0).encodesAs("AAAA")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAAAA")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAAAAAAAA")});
        data.add(new Object[]{verifyThat(0b0, 0b0).encodesAs("AAA=")});
        data.add(new Object[]{verifyThat(0b0).encodesAs("AA==")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAAA=")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAA==")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAAAAAAA=")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0).encodesAs("AAAAAAAAAA==")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00000001).encodesAs("AAAB")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00000010).encodesAs("AAAC")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00000011).encodesAs("AAAD")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00000100).encodesAs("AAAE")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00000101).encodesAs("AAAF")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00000110).encodesAs("AAAG")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00000111).encodesAs("AAAH")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00001000).encodesAs("AAAI")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00001001).encodesAs("AAAJ")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00001010).encodesAs("AAAK")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00001011).encodesAs("AAAL")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00001100).encodesAs("AAAM")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00001101).encodesAs("AAAN")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00001110).encodesAs("AAAO")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00001111).encodesAs("AAAP")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00010000).encodesAs("AAAQ")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00010001).encodesAs("AAAR")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00010010).encodesAs("AAAS")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00010011).encodesAs("AAAT")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00010100).encodesAs("AAAU")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00010101).encodesAs("AAAV")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00010110).encodesAs("AAAW")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00010111).encodesAs("AAAX")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00011000).encodesAs("AAAY")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00011001).encodesAs("AAAZ")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00011010).encodesAs("AAAa")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00011011).encodesAs("AAAb")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00011100).encodesAs("AAAc")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00011101).encodesAs("AAAd")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00011110).encodesAs("AAAe")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00011111).encodesAs("AAAf")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00100000).encodesAs("AAAg")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00100001).encodesAs("AAAh")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00100010).encodesAs("AAAi")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00100011).encodesAs("AAAj")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00100100).encodesAs("AAAk")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00100101).encodesAs("AAAl")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00100110).encodesAs("AAAm")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00100111).encodesAs("AAAn")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00101000).encodesAs("AAAo")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00101001).encodesAs("AAAp")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00101010).encodesAs("AAAq")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00101011).encodesAs("AAAr")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00101100).encodesAs("AAAs")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00101101).encodesAs("AAAt")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00101110).encodesAs("AAAu")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00101111).encodesAs("AAAv")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00110000).encodesAs("AAAw")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00110001).encodesAs("AAAx")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00110010).encodesAs("AAAy")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00110011).encodesAs("AAAz")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00110100).encodesAs("AAA0")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00110101).encodesAs("AAA1")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00110110).encodesAs("AAA2")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00110111).encodesAs("AAA3")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00111000).encodesAs("AAA4")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00111001).encodesAs("AAA5")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00111010).encodesAs("AAA6")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00111011).encodesAs("AAA7")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00111100).encodesAs("AAA8")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00111101).encodesAs("AAA9")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00111110).encodesAs("AAA+")});
        data.add(new Object[]{verifyThat(0b0, 0b0, 0b00111111).encodesAs("AAA/")});
        data.add(new Object[]{verifyThat(0b0, 0b00000000, 0b01000000).encodesAs("AABA")});
        data.add(new Object[]{verifyThat(0b0, 0b00001111, 0b11000000).encodesAs("AA/A")});
        data.add(new Object[]{verifyThat(0b0, 0b00010000, 0b00000000).encodesAs("ABAA")});
        data.add(new Object[]{verifyThat(0b00000011, 0b11110000, 0b00000000).encodesAs("A/AA")});
        data.add(new Object[]{verifyThat(0b00000100, 0b00000000, 0b00000000).encodesAs("BAAA")});
        data.add(new Object[]{verifyThat(0b11111100, 0b00000000, 0b00000000).encodesAs("/AAA")});
        data.add(new Object[]{verifyThat(0b00000001).encodesAs("AQ==")});
        data.add(new Object[]{verifyThat(0b00000000, 0b000000001).encodesAs("AAE=")});
        return data;
    }
}

class Base64EncodeTestCase {
    private final byte[] source;

    private String destination;

    public static Base64EncodeTestCase verifyThat(int... source) {
        byte[] clone = new byte[source.length];
        for (int index = 0; index < source.length; index++) {
            clone[index] = (byte) source[index];
        }
        return verifyThat(clone);
    }

    public static Base64EncodeTestCase verifyThat(byte... source) {
        return new Base64EncodeTestCase(source);
    }

    private Base64EncodeTestCase(byte[] source) {
        this.source = source;
    }

    public Base64EncodeTestCase encodesAs(String destination) {
        this.destination = destination;

        return this;
    }

    public byte[] getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}

