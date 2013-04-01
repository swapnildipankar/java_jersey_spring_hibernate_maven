package com.demoapp.demo.dao;

import com.demoapp.demo.model.purchase.PurchaseRequest;
import com.demoapp.demo.model.purchase.PurchaseSearchCriteria;
import com.demoapp.demo.model.error.WebServiceException;
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
public class PurchaseRequestDAO {
    @Autowired
    MongoBroker mongoBroker;

    public PurchaseRequest add(PurchaseRequest purchaseRequest) throws WebServiceException {
        System.out.println("AuthorizationRequestDAO.add");

        try {
            mongoBroker.getTemplate().save(purchaseRequest);
        } catch(Exception exception) {
            System.out.println("Exception [" + exception.getMessage() + "]");
            throw new WebServiceException(500, exception.getMessage());
        }
        return purchaseRequest;
    }

    public PurchaseRequest update(String id, PurchaseRequest purchaseRequest) throws WebServiceException {
        System.out.println("AuthorizationRequestDAO.update");

        PurchaseRequest updatedRequest = null;
        try {
            PurchaseRequest fetchedRequest = get(id);
            updatedRequest = getUpdatedRequest(fetchedRequest, purchaseRequest);
            mongoBroker.getTemplate().save(updatedRequest);
        } catch(Exception exception) {
            System.out.println("Exception [" + exception.getMessage() + "]");
            throw new WebServiceException(500, exception.getMessage());
        }
        return updatedRequest;
    }

    public PurchaseRequest get(String id) throws WebServiceException {
        System.out.println("AuthorizationRequestDAO.get");
        PurchaseRequest response = null;
        try {
            response = mongoBroker.getTemplate().findById(id, PurchaseRequest.class);
        } catch(Exception exception) {
            System.out.println("Exception [" + exception.getMessage() + "]");
            throw new WebServiceException(500, exception.getMessage());
        }
        if(response == null) {
            response = new PurchaseRequest();
        }
        return response;
    }

    public List<PurchaseRequest> getAll() throws WebServiceException {
        System.out.println("AuthorizationRequestDAO.getAll");
        List<PurchaseRequest> response = null;
        try {
            response = mongoBroker.getTemplate().findAll(PurchaseRequest.class);
        } catch(Exception exception) {
            System.out.println("Exception [" + exception.getMessage() + "]");
            throw new WebServiceException(500, exception.getMessage());
        }
        if(response == null) {
            response = new ArrayList<PurchaseRequest>();
        }
        return response;
    }

    public List<PurchaseRequest> search(PurchaseSearchCriteria purchaseSearchCriteria) throws WebServiceException {
        System.out.println("AuthorizationRequestDAO.search");
        List<PurchaseRequest> response = null;
        try {
            Query query = getQueryFromSearchCriteria(purchaseSearchCriteria);
            response = mongoBroker.getTemplate().find(query, PurchaseRequest.class);
        } catch(Exception exception) {
            System.out.println("Exception [" + exception.getMessage() + "]");
            throw new WebServiceException(500, exception.getMessage());
        }
        if(response == null) {
            response = new ArrayList<PurchaseRequest>();
        }
        return response;
    }

    // TODO: Throw exceptions in error cases
    private PurchaseRequest getUpdatedRequest(PurchaseRequest fetchedRequest, PurchaseRequest updatedRequest) throws WebServiceException {
        updatedRequest.setId(fetchedRequest.getId());
        // TODO: Other checks go here. Only update the fields that need to be updated
        return updatedRequest;
    }

    private Query getQueryFromSearchCriteria(PurchaseSearchCriteria purchaseSearchCriteria) {
        System.out.println("AuthorizationRequestDAO.getQueryFromSearchCriteria => purchaseSearchCriteria [" + purchaseSearchCriteria.toString() + "]");

        Query query = new Query();
        if(!StringUtils.isEmpty(purchaseSearchCriteria.getUserIPAddress())) {
            query.addCriteria(Criteria.where("userIPAddress").is(purchaseSearchCriteria.getUserIPAddress()));
        }
        if(!StringUtils.isEmpty(purchaseSearchCriteria.getEmail())) {
            query.addCriteria(Criteria.where("email").is(purchaseSearchCriteria.getEmail()));
        }
        if(!StringUtils.isEmpty(purchaseSearchCriteria.getClientId())) {
            query.addCriteria(Criteria.where("clientId").is(purchaseSearchCriteria.getClientId()));
        }
        if(!StringUtils.isEmpty(purchaseSearchCriteria.getOrderNumber())) {
            query.addCriteria(Criteria.where("orderNumber").is(purchaseSearchCriteria.getOrderNumber()));
        }
        return query;
    }
}
