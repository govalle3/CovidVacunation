package com.CeibaExam.CovidVacunation.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class User {

  private Long nationalId;
  private String firstName;
  private String lastName;
  @JsonFormat(pattern="yyyy/MM/dd")
  private Date dob;

  public User(Long nationalId, String firstName, String lastName, Date dob) {
    this.nationalId = nationalId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
  }

  public User() {
  }

  public Long getNationalId() {
    return nationalId;
  }

  public void setNationalId(Long nationalId) {
    this.nationalId = nationalId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  @Override
  public String toString() {
    return "User{" +
        "nationalId=" + nationalId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", dob=" + dob +
        '}';
  }
}
