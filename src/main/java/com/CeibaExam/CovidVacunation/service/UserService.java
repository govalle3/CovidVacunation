package com.CeibaExam.CovidVacunation.service;

import com.CeibaExam.CovidVacunation.model.domain.User;
import java.util.List;

public interface UserService {
  Boolean save(User user);
  List<User> findAllUser();


}
