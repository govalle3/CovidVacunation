package com.CeibaExam.CovidVacunation.model.repository;

import com.CeibaExam.CovidVacunation.model.domain.User;
import com.CeibaExam.CovidVacunation.model.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  @SuppressWarnings("unchecked")
  UserEntity save(UserEntity userEntity);  // ya tenemos el metodo save (registrar)

  @Override
  List<UserEntity> findAll();
}
