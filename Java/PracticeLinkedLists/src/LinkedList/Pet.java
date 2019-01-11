package LinkedList;

public class Pet implements Comparable<Pet> {
    private String name;
    private int age;

    public Pet(int age, String name) {
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
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Pet pet) {
        return Integer.compare(this.age, pet.getAge());
    }
}
