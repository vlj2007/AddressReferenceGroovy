package ru.eltex_co.AddressReferenceGroovy


class User {

    String id
    String name
    String email
    double salary

    User() {
    }

    User(String id, String name, String email, double salary) {
        this.id = id
        this.name = name
        this.email = email
        this.salary = salary
    }

    @Override
    boolean equals(Object o) {
        if (this == o) return true
        if (!(o instanceof User)) return false
        User user = (User) o
        return salary == user.salary && id == user.id && name == user.name && email == user.email
    }

    @Override
    int hashCode() {
        return Objects.hash(id, name, email, salary)
    }

    @Override
    String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}'
    }
}
