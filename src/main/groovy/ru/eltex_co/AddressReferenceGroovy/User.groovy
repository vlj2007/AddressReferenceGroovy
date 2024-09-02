package ru.eltex_co.AddressReferenceGroovy

class User {


    private String id;
    private String name;
    private String email;
    private double salary;

    User() {
    }

    User(String id, String name, String email, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(salary, user.salary) == 0 && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    int hashCode() {
        return Objects.hash(id, name, email, salary);
    }

    @Override
    String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }


}
