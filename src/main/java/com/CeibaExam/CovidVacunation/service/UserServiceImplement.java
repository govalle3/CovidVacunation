package com.CeibaExam.CovidVacunation.service;

import com.CeibaExam.CovidVacunation.model.domain.User;
import com.CeibaExam.CovidVacunation.model.repository.UserRepository;
import com.CeibaExam.CovidVacunation.model.repository.builder.UserBuilder;
import java.util.Calendar;
import java.util.Date;
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
  public Boolean save(User user) {  // debe ser la misma que esta en la interfaz o viceversa.
    if(userRepository.existsById(user.getNationalId())){
      return Boolean.FALSE;
    }

    if(validYear(user)){
      return Boolean.FALSE;
    }
    this.userRepository.save(userBuilder.convertToEntity(user));
    return Boolean.TRUE;
  }

  private Boolean validYear(User user){
    Date dob = user.getDob();
    Date now = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dob);
    Integer anioUser = calendar.get(Calendar.YEAR);
    Calendar calendarNow = Calendar.getInstance();
    calendarNow.setTime(now);
    Integer anioNow = calendarNow.get(calendarNow.YEAR);
    return (anioNow - anioUser <18);
  }

  @Override
  public List<User> findAllUser() {
    return userBuilder.convertToListDomain(this.userRepository.findAll());
  }
}
