package com.CeibaExam.CovidVacunation.model.repository;

import com.CeibaExam.CovidVacunation.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  @SuppressWarnings("unchecked")
  User save(User user);
}
