package nl.dvberkel.kata.base64;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static nl.dvberkel.kata.base64.Base64DecodeTestCase.verifyThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class Base64DecodeTest {
    private final String source;
    private final byte[] destination;
    private Kata kata;

    public Base64DecodeTest(Base64DecodeTestCase testCase) {
        this.source = testCase.getSource();
        this.destination = testCase.getDestination();
    }

    @Before
    public void createKata() throws Exception {
        kata = new Kata();
    }

    @Test
    public void shouldDecodeCorrectly() {
        assertThat(kata.decode(source), is(destination));
    }

    @Parameterized.Parameters
    public static Collection<Base64DecodeTestCase[]> data() {
        List<Base64DecodeTestCase[]> data = new ArrayList<>();
        data.add(verifyThat("AAAA").decodesTo(0b0, 0b0, 0b0));
        data.add(verifyThat("AAAAAAAA").decodesTo(0b0, 0b0, 0b0, 0b0, 0b0, 0b0));
        data.add(verifyThat("AAAAAAAAAAAA").decodesTo(0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0, 0b0));
        data.add(verifyThat("AAA=").decodesTo(0b0, 0b0));
        data.add(verifyThat("AA==").decodesTo(0b0));
        data.add(verifyThat("AAAAAAA=").decodesTo(0b0, 0b0, 0b0, 0b0, 0b0));
        data.add(verifyThat("AAAAAA==").decodesTo(0b0, 0b0, 0b0, 0b0));
        data.add(verifyThat("AAAB").decodesTo(0b0, 0b0, 0b00000001));
        data.add(verifyThat("AAA/").decodesTo(0b0, 0b0, 0b00111111));
        data.add(verifyThat("AABA").decodesTo(0b0, 0b0, 0b01000000));
        data.add(verifyThat("AA//").decodesTo(0b0, 0b00001111, 0b11111111));
        data.add(verifyThat("ABAA").decodesTo(0b0, 0b00010000, 0b00000000));
        data.add(verifyThat("A///").decodesTo(0b00000011, 0b11111111, 0b11111111));
        data.add(verifyThat("BAAA").decodesTo(0b00000100, 0b00000000, 0b00000000));
        data.add(verifyThat("////").decodesTo(0b11111111, 0b11111111, 0b11111111));
        data.add(verifyThat("AQ==").decodesTo(0b00000001));
        data.add(verifyThat("AAE=").decodesTo(0b00000000, 0b00000001));
        return data;
    }
}

class Base64DecodeTestCase {
    private final String source;
    private byte[] destination;

    public static Base64DecodeTestCase verifyThat(String source) {
        return new Base64DecodeTestCase(source);
    }

    private Base64DecodeTestCase(String source) {
        this.source = source;
    }


    public Base64DecodeTestCase[] decodesTo(int... destination) {
        this.destination = new byte[destination.length];
        for (int index = 0; index < destination.length; index++) {
            this.destination[index] = (byte) destination[index];
        }

        return new Base64DecodeTestCase[]{this};
    }

    public String getSource() {
        return source;
    }

    public byte[] getDestination() {
        return destination;
    }
}
