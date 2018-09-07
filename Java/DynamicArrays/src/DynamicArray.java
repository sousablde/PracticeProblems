public class DynamicArray<String> {
    private Object[] data;
    private int size;
    private int initialCapacity;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    //get and set are part of the killer features of arrays O(1)
    public String get(int index) {
        return (String) data[index];
    }

    public void set(int index, String value) {
        data[index] = value;
    }

    public void insert(int index, String value) {
        //has 2 steps first check size, second copy up third do insertion O(n)
        //check size
        if (size == initialCapacity) {
            resize();
        }

        //copy up
        for (int j = size; j > size; j--) {
            data[j] = data[j - 1];
        }

        //insert
        data[index] = value;
        size++;
    }

    public void delete(int index) {
        //copy down
        for (int j = size; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        //decrement size
        size--;
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public boolean Contains(String value) {
        for (int i = 0; i <= size - 1; i++) {
            String currentValue = (String) data[i];
            if (currentValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    private void resize() {
        Object[] newData = new Object[initialCapacity * 2];
        for (int i = 0; i < initialCapacity; i++) {
            //copying the values to a new array
            newData[i] = data[i];
        }
        //making the old array point to the new array
        data = newData;
        initialCapacity = initialCapacity * 2;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("data[i]= " + data[i]);
        }

    }

    //some array implementations offer methods like add (pushBack) like insert but at end of array
    public void add(String value) {
        if (size == initialCapacity) {
            resize();
        }
        data[size] = value;
        size++;
    }
}
