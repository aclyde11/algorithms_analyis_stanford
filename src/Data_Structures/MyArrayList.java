package Data_Structures;

/**
 * Created by austin on 8/28/16.
 */

public class MyArrayList<T> {

    private Object[] list;
    private int count;


    public void add (T obj) {
        ensureCapacity();
        list[count+1] = (Object) obj;
        count++;
    }

    public void add (T obj, int index) {
        ensureCapacity();
        for (int i = index; i <= count; i++) {
            list[i+1] = list[i];
        }
        list[index] = (Object) obj;
        count++;
    }

    public void delete (int index) {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = count; i > index; i--) {
            list[i-1] = list[i];
        }
        count--;
    }

    public void remove (T obj) {
        for (int i = 0; i < count; i++) {
            if (obj.equals(list[i])){
                delete(i);
            }
        }
    }

    public T get (int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) list[index];
    }

    public void ensureCapacity () {
        ensureCapacity((int) (list.length * 1.5));
    }

    public void ensureCapacity (int addition) {
        if ((count + addition) / list.length > .67) {
            resize((int) ((list.length + addition)*1.5));
        }
    }

    private void resize (int size) {
        Object[] temp = new Object[size];
        System.arraycopy(list, 0, temp, 0, count);
        list = temp;
    }

    public MyArrayList (T[] arr) {
        list = (Object[]) arr;
        ensureCapacity();
    }

    public MyArrayList (int size) {
        list = new Object[size];
    }

    public MyArrayList () {
        list = new Object[16];
    }
}