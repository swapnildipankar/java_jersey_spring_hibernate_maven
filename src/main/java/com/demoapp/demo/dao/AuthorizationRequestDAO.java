package com.demoapp.demo.dao;

import com.demoapp.demo.model.authorization.AuthorizationRequest;
import com.demoapp.demo.model.authorization.AuthorizationSearchCriteria;
import com.demoapp.demo.model.error.PaymentServiceException;
import com.demoapp.demo.util.mongodb.MongoBroker;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 3/25/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AuthorizationRequestDAO {
    @Autowired
    MongoBroker mongoBroker;

    public AuthorizationRequest add(AuthorizationRequest authorizationRequest) throws PaymentServiceException {
        System.out.println("AuthorizationRequestDAO.add");

        try {
            mongoBroker.getTemplate().save(authorizationRequest);
        } catch(Exception exception) {
            System.out.println("Exception [" + exception.getMessage() + "]");
            throw new PaymentServiceException(500, exception.getMessage());
        }
        return authorizationRequest;
    }

    public AuthorizationRequest update(String id, AuthorizationRequest authorizationRequest) throws PaymentServiceException {
        System.out.println("AuthorizationRequestDAO.update");

        AuthorizationRequest updatedRequest = null;
        try {
            AuthorizationRequest fetchedRequest = get(id);
            updatedRequest = getUpdatedRequest(fetchedRequest, authorizationRequest);
            mongoBroker.getTemplate().save(updatedRequest);
        } catch(Exception exception) {
            System.out.println("Exception [" + exception.getMessage() + "]");
            throw new PaymentServiceException(500, exception.getMessage());
        }
        return updatedRequest;
    }

    public AuthorizationRequest get(String id) throws PaymentServiceException {
        System.out.println("AuthorizationRequestDAO.get");
        AuthorizationRequest response = null;
        try {
            response = mongoBroker.getTemplate().findById(id, AuthorizationRequest.class);
        } catch(Exception exception) {
            System.out.println("Exception [" + exception.getMessage() + "]");
            throw new PaymentServiceException(500, exception.getMessage());
        }
        if(response == null) {
            response = new AuthorizationRequest();
        }
        return response;
    }

    public List<AuthorizationRequest> getAll() throws PaymentServiceException {
        System.out.println("AuthorizationRequestDAO.getAll");
        List<AuthorizationRequest> response = null;
        try {
            response = mongoBroker.getTemplate().findAll(AuthorizationRequest.class);
        } catch(Exception exception) {
            System.out.println("Exception [" + exception.getMessage() + "]");
            throw new PaymentServiceException(500, exception.getMessage());
        }
        if(response == null) {
            response = new ArrayList<AuthorizationRequest>();
        }
        return response;
    }

    public List<AuthorizationRequest> search(AuthorizationSearchCriteria authorizationSearchCriteria) throws PaymentServiceException {
        System.out.println("AuthorizationRequestDAO.search");
        List<AuthorizationRequest> response = null;
        try {
            Query query = getQueryFromSearchCriteria(authorizationSearchCriteria);
            response = mongoBroker.getTemplate().find(query, AuthorizationRequest.class);
        } catch(Exception exception) {
            System.out.println("Exception [" + exception.getMessage() + "]");
            throw new PaymentServiceException(500, exception.getMessage());
        }
        if(response == null) {
            response = new ArrayList<AuthorizationRequest>();
        }
        return response;
    }

    // TODO: Throw exceptions in error cases
    private AuthorizationRequest getUpdatedRequest(AuthorizationRequest fetchedRequest, AuthorizationRequest updatedRequest) throws PaymentServiceException {
        updatedRequest.setId(fetchedRequest.getId());
        // TODO: Other checks go here. Only update the fields that need to be updated
        return updatedRequest;
    }

    private Query getQueryFromSearchCriteria(AuthorizationSearchCriteria authorizationSearchCriteria) {
        System.out.println("AuthorizationRequestDAO.getQueryFromSearchCriteria => authorizationSearchCriteria [" + authorizationSearchCriteria.toString() + "]");

        Query query = new Query();
        if(!StringUtils.isEmpty(authorizationSearchCriteria.getAuthorizationRequestId())) {
            query.addCriteria(Criteria.where("authorizationRequestId").is(authorizationSearchCriteria.getAuthorizationRequestId()));
        }
        if(!StringUtils.isEmpty(authorizationSearchCriteria.getCustomerIPAddress())) {
            query.addCriteria(Criteria.where("customerIPAddress").is(authorizationSearchCriteria.getCustomerIPAddress()));
        }
        if(!StringUtils.isEmpty(authorizationSearchCriteria.getEmail())) {
            query.addCriteria(Criteria.where("email").is(authorizationSearchCriteria.getEmail()));
        }
        if(!StringUtils.isEmpty(authorizationSearchCriteria.getPaymentClientId())) {
            query.addCriteria(Criteria.where("paymentClientId").is(authorizationSearchCriteria.getPaymentClientId()));
        }
        if(!StringUtils.isEmpty(authorizationSearchCriteria.getWebOrderNumber())) {
            query.addCriteria(Criteria.where("webOrderNumber").is(authorizationSearchCriteria.getWebOrderNumber()));
        }
        return query;
    }
}
