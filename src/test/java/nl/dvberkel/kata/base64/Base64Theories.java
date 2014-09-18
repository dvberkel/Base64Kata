package nl.dvberkel.kata.base64;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class Base64Theories {
    private Kata kata;

    @Before
    public void createKata() {
        kata = new Kata();
    }

    @DataPoints
    public static byte[][] dataPoints = new byte[][]{
            new byte[]{0b0},
            new byte[]{0b0, 0b0},
            new byte[]{0b0, 0b0, 0b0},
            new byte[]{0b0, 0b0, 0b0, 0b0},
            new byte[]{0b0, 0b0, 0b0, 0b0, 0b0},
            new byte[]{0b0, 0b0, 0b0, 0b0, 0b0, 0b0},
            new byte[]{0b111111},
            new byte[]{0b111111, 0b111111},
            new byte[]{0b111111, 0b111111, 0b111111},
            new byte[]{0b111111, 0b111111, 0b111111, 0b111111},
            new byte[]{0b111111, 0b111111, 0b111111, 0b111111, 0b111111},
            new byte[]{0b111111, 0b111111, 0b111111, 0b111111, 0b111111, 0b111111}
    };

    @Theory
    public void decodeIsTheInverseOfEncode(byte[] input) {
        assumeThat(input.length, is(greaterThan(0)));

        assertThat(kata.decode(kata.encode(input)), is(input));
    }

    @Theory
    public void encodeAndConcatenationAreCommutative(byte[] a, byte[] b) throws IOException {
        assumeThat(a.length % 3, is(0));
        assumeThat(a.length, is(greaterThan(0)));
        assumeThat(b.length, is(greaterThan(0)));

        ByteArrayOutputStream s = new ByteArrayOutputStream();
        s.write(a);
        s.write(b);
        byte[] concat = s.toByteArray();

        assertThat(kata.encode(a).concat(kata.encode(b)), is(kata.encode(concat)));
    }
}
