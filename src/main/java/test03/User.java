package test03;

public class User {
    private String name;
    private int age;
    private String height;

    public User(String name, int age, String height) {
        super();
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(super.toString());
        str.append(" ");
        str.append("name:" + name);
        str.append(",age:" + age);
        str.append(",height:" + height);
        return str.toString();
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
