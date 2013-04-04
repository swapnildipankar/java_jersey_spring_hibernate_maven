package com.demoapp.demo.manager;

import com.demoapp.demo.dao.PurchaseRequestDAO;
import com.demoapp.demo.model.purchase.PurchaseRequest;
import com.demoapp.demo.model.purchase.PurchaseSearchCriteria;
import com.demoapp.demo.model.error.WebServiceException;
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
public class PurchaseRequestManager {
    @Autowired
	PurchaseRequestDAO purchaseRequestDAO;

    public PurchaseRequest add(PurchaseRequest purchaseRequest) throws WebServiceException {
        System.out.println("AuthorizationRequestManager.add");
        validate(purchaseRequest, POST.class);

        PurchaseRequest response = purchaseRequestDAO.add(purchaseRequest);
        return response;
    }

    public PurchaseRequest update(String id, PurchaseRequest purchaseRequest) throws WebServiceException {
        System.out.println("AuthorizationRequestManager.update");
        validate(purchaseRequest, PUT.class);

        if(!purchaseRequest.getId().equals(id)) {
            throw new WebServiceException(400, "PurchaseRequest ID Mismatch");
        }
        PurchaseRequest response = purchaseRequestDAO.update(id, purchaseRequest);
        return response;
    }

    public PurchaseRequest get(String id) throws WebServiceException {
        System.out.println("AuthorizationRequestManager.get");
        PurchaseRequest response = purchaseRequestDAO.get(id);
        return response;
    }

    public List<PurchaseRequest> getAll() throws WebServiceException {
        System.out.println("AuthorizationRequestManager.getAll");
        List<PurchaseRequest> response = purchaseRequestDAO.getAll();
        return response;
    }

    public List<PurchaseRequest> search(PurchaseSearchCriteria purchaseSearchCriteria) throws WebServiceException {
        System.out.println("AuthorizationRequestManager.search");
        List<PurchaseRequest> response = purchaseRequestDAO.search(purchaseSearchCriteria);
        return response;
    }

    private <T> void validate(PurchaseRequest request, Class<T> T) throws WebServiceException {
        System.out.println("PurchaseRequestManager.validate");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<PurchaseRequest>> violationSet = validator.validate(request, T);
        if(violationSet.size() > 0) {
            List<String> violationMessageList = new ArrayList<String>();
            for(ConstraintViolation<PurchaseRequest> violation : violationSet) {
                System.out.println("Violation [" + violation.getMessage() + "]");
                violationMessageList.add(violation.getMessage());
            }
            throw new WebServiceException(400, "Bad Input Request", violationMessageList);
        }
    }
}
