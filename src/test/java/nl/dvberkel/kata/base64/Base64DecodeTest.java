package nl.dvberkel.kata.base64;


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

    public Base64DecodeTest(Base64DecodeTestCase testCase) {
        this.source = testCase.getSource();
        this.destination = testCase.getDestination();
    }

    @Test
    public void shouldDecodeCorrectly() {
        assertThat((new Kata()).decode(source), is(destination));
    }

    @Parameterized.Parameters
    public static Collection<Base64DecodeTestCase[]> data() {
        List<Base64DecodeTestCase[]> data = new ArrayList<>();
        data.add(verifyThat("AAAA").decodesTo(0b0, 0b0, 0b0));
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

        return new Base64DecodeTestCase[] { this };
    }

    public String getSource() {
        return source;
    }

    public byte[] getDestination() {
        return destination;
    }
}
