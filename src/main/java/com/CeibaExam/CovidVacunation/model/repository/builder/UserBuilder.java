package com.CeibaExam.CovidVacunation.model.repository.builder;
import com.CeibaExam.CovidVacunation.model.domain.User;
import com.CeibaExam.CovidVacunation.model.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder {

  public UserEntity convertToEntity(User user)
  {
    UserEntity userEntity = new UserEntity(); // creacion del objeto entity user pero vacio
    userEntity.setDob(user.getDob());
    userEntity.setFirstName(user.getFirstName());
    userEntity.setLastName(user.getLastName());
    userEntity.setNationalId(user.getNationalId());
    return userEntity;
  }

  public User convertToDomain(UserEntity userEntity) {
    User user = null;
    if (userEntity != null) {
      user = new User(userEntity.getNationalId(), userEntity.getFirstName(),
          userEntity.getLastName(), userEntity.getDob());
    }
    return user;
  }

    public List<User> convertToListDomain(List<UserEntity> newUserEntityList )
  {
      List<User> userList = new ArrayList<>();
      for(UserEntity userEntity : newUserEntityList){
        userList.add(convertToDomain(userEntity));
      }
      return userList;
    }


  }

