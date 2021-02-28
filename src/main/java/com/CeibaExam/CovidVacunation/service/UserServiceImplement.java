package com.CeibaExam.CovidVacunation.service;

import com.CeibaExam.CovidVacunation.model.domain.User;
import com.CeibaExam.CovidVacunation.model.repository.UserRepository;
import com.CeibaExam.CovidVacunation.model.repository.builder.UserBuilder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService{

  @Autowired
  protected UserRepository userRepository;

  @Autowired
  private UserBuilder userBuilder;

  @Override
  public void save(User user) {  // debe ser la misma que esta en la interfaz o viceversa.
    this.userRepository.save(userBuilder.convertToEntity(user));
  }

  @Override
  public List<User> findAllUser() {
    return userBuilder.convertToListDomain(this.userRepository.findAll());
  }
}
