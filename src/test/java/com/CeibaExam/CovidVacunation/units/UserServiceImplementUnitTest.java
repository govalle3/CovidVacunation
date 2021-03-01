package com.CeibaExam.CovidVacunation.units;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.CeibaExam.CovidVacunation.model.domain.User;
import com.CeibaExam.CovidVacunation.model.repository.UserRepository;
import com.CeibaExam.CovidVacunation.model.repository.builder.UserBuilder;
import com.CeibaExam.CovidVacunation.service.UserServiceImplement;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplementUnitTest {

  @Mock
  private UserRepository userRepository;
  @Mock
  private UserBuilder userBuilder;
  private UserServiceImplement userServiceImplement;
  private User user;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    this.userServiceImplement = new UserServiceImplement(userRepository, userBuilder);
    this.user = mock(User.class);
  }

  @Test
  public void testExistingId() {
    //Arrange
    when(user.getNationalId()).thenReturn(5L);
    when(userRepository.existsById(5L)).thenReturn(Boolean.TRUE);
    //Act
    Boolean answer = userServiceImplement.save(user);
    //Assert
    Assert.assertFalse(answer);
  }

  @Test
  public void testMinorAge() {
    //Arrange
    Date date = new Date("2015/02/26");
    when(user.getDob()).thenReturn(date);
    //ACt
    Boolean answer = userServiceImplement.save(user);
    //Assert
    Assert.assertFalse(answer);

  }

  @Test
  public void testMajorAge() {
    //Arrange
    Date date = new Date("2000/02/26");
    when(user.getDob()).thenReturn(date);
    //ACt
    Boolean answer = userServiceImplement.save(user);
    //Assert
    Assert.assertTrue(answer);

  }

}
