package com.CeibaExam.CovidVacunation.service;

import com.CeibaExam.CovidVacunation.model.domain.User;
import com.CeibaExam.CovidVacunation.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService{

  @Autowired
  protected UserRepository userRepository;

  @Override
  public User save(User user) {
    return this.userRepository.save(user);
  }

}
