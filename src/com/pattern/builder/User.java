package com.pattern.builder;

public class User {

  // Mandatory Fields
  private final String firstName;
  private final String lastName;

  // Optional Fields
  private final Integer age;
  private final Integer income;

  private User(UserBuilder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.age = builder.age;
    this.income = builder.income;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Integer getAge() {
    return age;
  }

  public Integer getIncome() {
    return income;
  }

  @Override
  public String toString() {
    return "User{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        ", income=" + income +
        '}';
  }

  public static final class UserBuilder {

    private final String firstName;
    private final String lastName;
    private Integer age;
    private Integer income;

    public UserBuilder(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public UserBuilder withAge(Integer age) {
      this.age = age;
      return this;
    }

    public UserBuilder withIncome(Integer income) {
      this.income = income;
      return this;
    }

    public User build() {
      return new User(this);
    }
  }
}
