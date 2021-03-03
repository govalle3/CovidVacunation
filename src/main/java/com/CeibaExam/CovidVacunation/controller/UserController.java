package com.CeibaExam.CovidVacunation.controller;

import com.CeibaExam.CovidVacunation.model.domain.User;
import com.CeibaExam.CovidVacunation.service.UserService;
import com.CeibaExam.CovidVacunation.util.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  protected UserService userService;

  protected ObjectMapper mapper; // Convertir un json que nos envia como parametro.

  @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
  public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException,
      IOException {
    this.mapper = new ObjectMapper();
    User user = this.mapper.readValue(userJson, User.class);
    if (!this.validate(user)) {
      return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
          "The mandatory fields are not filled out");
    }

    if (this.userService.save(user)) {
      return new RestResponse(HttpStatus.OK.value(), "Successful transaction");
    }
    return new RestResponse(HttpStatus.BAD_REQUEST.value(), "Existing user or User under age");
  }

  private boolean validate(User user) {
    boolean isValid = true;

    if (user.getFirstName() == null) {
      isValid = false;
    }
    if (user.getNationalId() == null) {
      isValid = false;
    }
    if (user.getDob() == null) {
      isValid = false;
    }
    return isValid;
  }

  @RequestMapping(value = "/findUsers", method = RequestMethod.GET)
  public List<User> findUsers() throws JsonParseException {
    return this.userService.findAllUser();
  }

}
