package nl.dvberkel.kata.base64;

import org.junit.Before;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


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
    public static byte[] input = new byte[] {0b0};

    @Theory
    public void decodeIsTheInverseOfEncode(byte[] input) {
        assumeThat(input.length, is(greaterThan(0)));

        assertThat(kata.decode(kata.encode(input)), is(input));
    }
}
