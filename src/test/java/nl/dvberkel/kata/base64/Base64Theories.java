package nl.dvberkel.kata.base64;

import org.junit.Before;
import org.junit.experimental.theories.DataPoint;
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

    @DataPoint
    public static byte[] singleByte = new byte[] {0b0};

    @DataPoint
    public static byte[] tripleBytes = new byte[] {0b0, 0b0, 0b0};

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
