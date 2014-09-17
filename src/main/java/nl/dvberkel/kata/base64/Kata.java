package nl.dvberkel.kata.base64;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Kata {
    public String encode(byte[] source) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < source.length) {
            CharacterValues characterValues = characterValuesFor(source, index);
            characterValues.appendTo(result);
            index += 3;
        }
        return result.toString();
    }

    private CharacterValues characterValuesFor(byte[] source, int index) {
        switch (source.length - index) {
            case 1:
                return new OneByteCharacterValues(source[index]);
            case 2:
                return new TwoByteCharacterValues(source[index], source[index + 1]);
            default:
                return new DefaultCharacterValues(source[index], source[index + 1], source[index + 2]);
        }
    }

    public byte[] decode(String source) {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        int index = 0;
        while (index < source.length()) {
            ByteValues byteValues = byteValuesFor(source, index);
            byteValues.writeTo(result);
            index += 4;
        }
        return result.toByteArray();
    }

    private ByteValues byteValuesFor(String source, int index) {
        String substring = source.substring(index, index + 4);
        if (substring.endsWith("==")) {
            return new EndsInDoubleEqualByteValues(substring);
        } else if (substring.endsWith("=")) {
            return new EndsInSingleEqualByteValues(substring);
        } else {
            return new DefaultByteValues(substring);
        }
    }
}

interface CharacterValues {
    void appendTo(StringBuilder result);
}

class DefaultCharacterValues implements CharacterValues {
    private static final String[] characters = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "+", "/"
    };

    private byte[] part;

    public DefaultCharacterValues(byte first, byte second, byte third) {
        part = new byte[]{first, second, third};
    }

    private String first() {
        return character((part[0] & 0b11111100) >> 2);
    }

    private String second() {
        return character(((part[0] & 0b00000011) << 4) | ((part[1] & 0b11110000) >> 4));
    }

    protected String third() {
        return character(((part[1] & 0b00001111) << 2) | ((part[2] & 0b11000000) >> 6));
    }

    protected String fourth() {
        return character(part[2] & 0b00111111);
    }

    @Override
    public void appendTo(StringBuilder result) {
        result.append(first());
        result.append(second());
        result.append(third());
        result.append(fourth());
    }

    private String character(int index) {
        return characters[index];
    }
}

class TwoByteCharacterValues extends DefaultCharacterValues {
    public TwoByteCharacterValues(byte first, byte second) {
        super(first, second, (byte) 0b0);
    }

    @Override
    protected String fourth() {
        return "=";
    }
}


class OneByteCharacterValues extends TwoByteCharacterValues {

    public OneByteCharacterValues(byte first) {
        super(first, (byte) 0b0);
    }

    @Override
    protected String third() {
        return "=";
    }
}

interface ByteValues {
    public void writeTo(ByteArrayOutputStream outputStream);
}

class DefaultByteValues implements ByteValues {
    private static final Map<String, Byte> characterValues = new HashMap<String, Byte>();

    static {
        characterValues.put("A", (byte) 0b000000);
        characterValues.put("B", (byte) 0b000001);
        characterValues.put("C", (byte) 0b000010);
        characterValues.put("D", (byte) 0b000011);
        characterValues.put("E", (byte) 0b000100);
        characterValues.put("F", (byte) 0b000101);
        characterValues.put("G", (byte) 0b000110);
        characterValues.put("H", (byte) 0b000111);
        characterValues.put("I", (byte) 0b001000);
        characterValues.put("J", (byte) 0b001001);
        characterValues.put("K", (byte) 0b001010);
        characterValues.put("L", (byte) 0b001011);
        characterValues.put("M", (byte) 0b001100);
        characterValues.put("N", (byte) 0b001101);
        characterValues.put("O", (byte) 0b001110);
        characterValues.put("P", (byte) 0b001111);
        characterValues.put("Q", (byte) 0b010000);
        characterValues.put("R", (byte) 0b010001);
        characterValues.put("S", (byte) 0b010010);
        characterValues.put("T", (byte) 0b010011);
        characterValues.put("U", (byte) 0b010100);
        characterValues.put("V", (byte) 0b010101);
        characterValues.put("W", (byte) 0b010110);
        characterValues.put("X", (byte) 0b010111);
        characterValues.put("Y", (byte) 0b011000);
        characterValues.put("Z", (byte) 0b011001);
        characterValues.put("a", (byte) 0b011010);
        characterValues.put("b", (byte) 0b011011);
        characterValues.put("c", (byte) 0b011100);
        characterValues.put("d", (byte) 0b011101);
        characterValues.put("e", (byte) 0b011110);
        characterValues.put("f", (byte) 0b011111);
        characterValues.put("g", (byte) 0b100000);
        characterValues.put("h", (byte) 0b100001);
        characterValues.put("i", (byte) 0b100010);
        characterValues.put("j", (byte) 0b100011);
        characterValues.put("k", (byte) 0b100100);
        characterValues.put("l", (byte) 0b100101);
        characterValues.put("m", (byte) 0b100110);
        characterValues.put("n", (byte) 0b100111);
        characterValues.put("o", (byte) 0b101000);
        characterValues.put("p", (byte) 0b101001);
        characterValues.put("q", (byte) 0b101010);
        characterValues.put("r", (byte) 0b101011);
        characterValues.put("s", (byte) 0b101100);
        characterValues.put("t", (byte) 0b101101);
        characterValues.put("u", (byte) 0b101110);
        characterValues.put("v", (byte) 0b101111);
        characterValues.put("w", (byte) 0b110000);
        characterValues.put("x", (byte) 0b110001);
        characterValues.put("y", (byte) 0b110010);
        characterValues.put("z", (byte) 0b110011);
        characterValues.put("0", (byte) 0b110100);
        characterValues.put("1", (byte) 0b110101);
        characterValues.put("2", (byte) 0b110110);
        characterValues.put("3", (byte) 0b110111);
        characterValues.put("4", (byte) 0b111000);
        characterValues.put("5", (byte) 0b111001);
        characterValues.put("6", (byte) 0b111010);
        characterValues.put("7", (byte) 0b111011);
        characterValues.put("8", (byte) 0b111100);
        characterValues.put("9", (byte) 0b111101);
        characterValues.put("+", (byte) 0b111110);
        characterValues.put("/", (byte) 0b111111);
        characterValues.put("=", (byte) 0b000000);
    }

    private final String[] sources;

    public DefaultByteValues(String source) {
        this.sources = source.split("");
    }

    @Override
    public void writeTo(ByteArrayOutputStream output) {
        output.write(first());
        output.write(second());
        output.write(third());
    }

    protected byte first() {
        return (byte) (((characterValues.get(sources[0]) & 0b111111) << 2) | ((characterValues.get(sources[1]) & 0b110000) >> 4));
    }

    protected byte second() {
        return (byte) (((characterValues.get(sources[1]) & 0b001111) << 4) | ((characterValues.get(sources[2]) & 0b111100) >> 2));
    }

    protected byte third() {
        return (byte) (((characterValues.get(sources[2]) & 0b000011) << 6) | ((characterValues.get(sources[3]) & 0b111111) >> 0));
    }
}

class EndsInSingleEqualByteValues extends DefaultByteValues {
    public EndsInSingleEqualByteValues(String source) {
        super(source);
    }


    @Override
    public void writeTo(ByteArrayOutputStream output) {
        output.write(first());
        output.write(second());
    }
}

class EndsInDoubleEqualByteValues extends DefaultByteValues {
    public EndsInDoubleEqualByteValues(String source) {
        super(source);
    }

    @Override
    public void writeTo(ByteArrayOutputStream output) {
        output.write(first());
    }
}