

public class BSTfromObject implements Comparable<BSTfromObject> {
    private String name;
    private int age;

    public BSTfromObject(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(BSTfromObject bsTfromObject) {
        return name.compareTo(bsTfromObject.getName());
    }

    @Override
    public String toString() {
        return this.name + "-" + this.age;
    }


}
