package com.demoapp.demo.manager;

import com.demoapp.demo.dao.AuthorizationRequestDAO;
import com.demoapp.demo.model.authorization.AuthorizationRequest;
import com.demoapp.demo.model.authorization.AuthorizationSearchCriteria;
import com.demoapp.demo.model.error.PaymentServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 3/25/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AuthorizationRequestManager {
    @Autowired
    AuthorizationRequestDAO authorizationRequestDAO;

    public AuthorizationRequest add(AuthorizationRequest authorizationRequest) throws PaymentServiceException {
        System.out.println("AuthorizationRequestManager.add");
        validate(authorizationRequest, POST.class);

        AuthorizationRequest response = authorizationRequestDAO.add(authorizationRequest);
        return response;
    }

    public AuthorizationRequest update(String id, AuthorizationRequest authorizationRequest) throws PaymentServiceException {
        System.out.println("AuthorizationRequestManager.update");
        validate(authorizationRequest, PUT.class);

        if(!authorizationRequest.getId().equals(id)) {
            throw new PaymentServiceException(400, "AuthorizationRequest ID Mismatch");
        }
        AuthorizationRequest response = authorizationRequestDAO.update(id, authorizationRequest);
        return response;
    }

    public AuthorizationRequest get(String id) throws PaymentServiceException {
        System.out.println("AuthorizationRequestManager.get");
        AuthorizationRequest response = authorizationRequestDAO.get(id);
        return response;
    }

    public List<AuthorizationRequest> getAll() throws PaymentServiceException {
        System.out.println("AuthorizationRequestManager.getAll");
        List<AuthorizationRequest> response = authorizationRequestDAO.getAll();
        return response;
    }

    public List<AuthorizationRequest> search(AuthorizationSearchCriteria authorizationSearchCriteria) throws PaymentServiceException {
        System.out.println("AuthorizationRequestManager.search");
        List<AuthorizationRequest> response = authorizationRequestDAO.search(authorizationSearchCriteria);
        return response;
    }

    private <T> void validate(AuthorizationRequest request, Class<T> T) throws PaymentServiceException {
        System.out.println("AuthorizationRequestDAO.validate");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<AuthorizationRequest>> violationSet = validator.validate(request, T);
        if(violationSet.size() > 0) {
            List<String> violationMessageList = new ArrayList<String>();
            for(ConstraintViolation<AuthorizationRequest> violation : violationSet) {
                System.out.println("Violation [" + violation.getMessage() + "]");
                violationMessageList.add(violation.getMessage());
            }
            throw new PaymentServiceException(400, "Bad Input Request", violationMessageList);
        }
    }
}
