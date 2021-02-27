package com.CeibaExam.CovidVacunation.model.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class UserEntity {

  @Id
  private Long nationalId;
  private String firstName;
  private String lastName;
  private Date dob;

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
}
