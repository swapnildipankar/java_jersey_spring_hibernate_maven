package com.demoapp.demo.controller;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 9/24/12
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */

import com.demoapp.demo.manager.UserManager;
import com.demoapp.demo.model.error.WebServiceError;
import com.demoapp.demo.model.error.WebServiceException;
import com.demoapp.demo.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserManager userManager;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public User addUser(@RequestBody User user) throws Exception {
        return userManager.add(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public User updateUser(@PathVariable Long id, @RequestBody User user) throws Exception {
        return userManager.update(id, user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User fetchUser(@PathVariable Long id) {
        return userManager.fetch(id);
    }

    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User fetchUserByUsername(@PathVariable String username) {
        return userManager.fetchByUsername(username);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> fetchAllUsers(@RequestParam(value = "include_all", required = false) boolean includeAll) {
        return userManager.fetchAll(includeAll);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public User deleteUser(@PathVariable Long id, @RequestBody User user) throws Exception {
        return userManager.delete(id, user);
    }

    // Exception handler for WebServiceException cases
    @ExceptionHandler(WebServiceException.class)
    public ResponseEntity<WebServiceError> handleWebServiceException(WebServiceException webServiceException) {
        System.out.println("UserController.handleWebServiceException");
        WebServiceError webServiceError = new WebServiceError(webServiceException.getExceptionCode(), webServiceException.getExceptionMessage());

        // This should happen in case of input constraint validations
        if(webServiceException.getExceptionMessageList() != null) {
            webServiceError.setErrorMessageList(webServiceException.getExceptionMessageList());
        }
        return new ResponseEntity<WebServiceError>(webServiceError, HttpStatus.BAD_REQUEST);
    }

    // Exception handler for generic Exception cases
    @ExceptionHandler(Exception.class)
    public ResponseEntity<WebServiceError> handleException(Exception exception) {
        System.out.println("UserController.handleException");
        WebServiceError webServiceError = new WebServiceError(400, exception.getMessage());
        return new ResponseEntity<WebServiceError>(webServiceError, HttpStatus.BAD_REQUEST);
    }
}
