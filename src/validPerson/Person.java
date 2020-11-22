package validPerson;

public class Person {
    private String firstName;
    private String lastname;
    private int age;

    public Person (String firstName, String lastname, int age) {
        this.setFirstName(firstName);
        this.setLastname(lastname);
        this.setAge(age);
    }


    private void setFirstName(String firstName) {
        if (isNullOrEmpty(firstName)) {
            throw new IllegalArgumentException("The first name cannot be null or empty");
        }
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    private void setLastname(String lastname) {
        if (isNullOrEmpty(lastname)) {
            throw new IllegalArgumentException("The last name cannot be null or empty");
        }
        this.lastname = lastname;
    }

    public String getLastname() {
        return this.lastname;
    }

    private void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("The age must be in the range [0...120]");
        }
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isNullOrEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            return true;
        }

        return false;
    }

}
