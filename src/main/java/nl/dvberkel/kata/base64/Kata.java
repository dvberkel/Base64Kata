package nl.dvberkel.kata.base64;

public class Kata {
    public String encode(byte[] source) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < source.length) {
            CharacterValues characterValues = characterValuesFor(source, index);
            result.append(characterValues.first());
            result.append(characterValues.second());
            result.append(characterValues.third());
            result.append(characterValues.fourth());
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
}

interface CharacterValues {
    public String first();

    public String second();

    public String third();

    public String fourth();
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

    @Override
    public String first() {
        return character((part[0] & 0b11111100) >> 2);
    }

    @Override
    public String second() {
        return character(((part[0] & 0b00000011) << 4) | ((part[1] & 0b11110000) >> 4));
    }

    @Override
    public String third() {
        return character(((part[1] & 0b00001111) << 2) | ((part[2] & 0b11000000) >> 6));
    }

    @Override
    public String fourth() {
        return character(part[2] & 0b00111111);
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
    public String fourth() {
        return "=";
    }
}


class OneByteCharacterValues extends TwoByteCharacterValues {

    public OneByteCharacterValues(byte first) {
        super(first, (byte) 0b0);
    }

    @Override
    public String third() {
        return "=";
    }
}
