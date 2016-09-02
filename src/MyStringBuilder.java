/**
 * Created by austin on 8/28/16.
 */
public class MyStringBuilder{

    private char[] chars;
    private int index;

    public MyStringBuilder() {
        chars = new char[16];
    }

    public MyStringBuilder(String str) {
        chars = new char[str.length()];
        this.append(str);
    }

    public void append (String str) {
        int addlen = str.length();
        ensureCapacity(length() + addlen);
        System.arraycopy(str.toCharArray(), 0, chars, index, addlen);
        index =+ addlen;
    }

    public void insert (String str, int at) {
        char[] s = str.toCharArray();
        ensureCapacity(length() + s.length);

        //shift elements @at over s.length
        for(int i = at; i < length(); i++) {
            chars[i + s.length] = chars[i];
        }

        //write in elements
        for(int i = at; i < s.length+at; i++) {
            chars[i] = s[i-at];
        }

        index += s.length;
    }

    public int capacity () {
        return chars.length;
    }

    public void ensureCapacity (int min) {
        resize(Math.max(min, capacity() * 2 + 2));
    }

    private void resize (int newsize) {
        char[] temp = new char[newsize];
        System.arraycopy(chars, 0, temp, 0, chars.length);
        chars = temp;
    }

    public int length () {
        return index + 1;
    }

    public String substring (int start) {
        return substring(start, length());
    }

    public String substring (int start, int end) {
        char[] temp = new char[start + end - 1];
        System.arraycopy(chars, start, temp, 0, temp.length);
        return new String(temp);
    }

    public void trimToSize () {
        resize(length());
    }

    @Override
    public String toString () {
        return substring (0, length());
    }
}