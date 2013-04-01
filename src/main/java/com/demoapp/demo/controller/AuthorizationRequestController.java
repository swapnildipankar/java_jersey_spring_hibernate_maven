package com.demoapp.demo.controller;

import com.demoapp.demo.manager.AuthorizationRequestManager;
import com.demoapp.demo.model.authorization.AuthorizationRequest;
import com.demoapp.demo.model.authorization.AuthorizationSearchCriteria;
import com.demoapp.demo.model.error.PaymentServiceError;
import com.demoapp.demo.model.error.PaymentServiceException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 3/25/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/authorization_request")
public class AuthorizationRequestController {
    @Autowired
    AuthorizationRequestManager authorizationRequestManager;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public AuthorizationRequest add(@RequestBody AuthorizationRequest authorizationRequest) throws PaymentServiceException {
        System.out.println("AuthorizationRequestController.add [" + authorizationRequest.toString() + "]");
        AuthorizationRequest response = authorizationRequestManager.add(authorizationRequest);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public AuthorizationRequest update(
            @PathVariable String id,
            @RequestBody AuthorizationRequest authorizationRequest) throws PaymentServiceException
    {
        System.out.println("AuthorizationRequestController.update [" + authorizationRequest.toString() + "]");
        AuthorizationRequest response = authorizationRequestManager.update(id, authorizationRequest);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public AuthorizationRequest get(@PathVariable String id) throws PaymentServiceException {
        System.out.println("AuthorizationRequestController.get");
        AuthorizationRequest response = authorizationRequestManager.get(id);
        return response;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<AuthorizationRequest> getAll() throws PaymentServiceException {
        System.out.println("AuthorizationRequestController.getAll");
        List<AuthorizationRequest> response = authorizationRequestManager.getAll();
        return response;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<AuthorizationRequest> search(
            @RequestParam(value = "authorization_request_id", required = false) String authorizationRequestId,
            @RequestParam(value = "customer_ip_address", required = false) String customerIPAddress,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "payment_client_id", required = false) String paymentClientId,
            @RequestParam(value = "web_order_number", required = false) String webOrderNumber) throws PaymentServiceException
    {
        System.out.println("AuthorizationRequestController.search");

        AuthorizationSearchCriteria authorizationSearchCriteria = new AuthorizationSearchCriteria();
        if(!StringUtils.isEmpty(authorizationRequestId)) {
            authorizationSearchCriteria.setAuthorizationRequestId(authorizationRequestId);
        }
        if(!StringUtils.isEmpty(customerIPAddress)) {
            authorizationSearchCriteria.setCustomerIPAddress(customerIPAddress);
        }
        if(!StringUtils.isEmpty(email)) {
            authorizationSearchCriteria.setEmail(email);
        }
        if(!StringUtils.isEmpty(paymentClientId)) {
            authorizationSearchCriteria.setPaymentClientId(paymentClientId);
        }
        if(!StringUtils.isEmpty(webOrderNumber)) {
            authorizationSearchCriteria.setWebOrderNumber(webOrderNumber);
        }

        List<AuthorizationRequest> response = authorizationRequestManager.search(authorizationSearchCriteria);
        return response;
    }

    // Exception handler for PaymentServiceException cases
    @ExceptionHandler(PaymentServiceException.class)
    public ResponseEntity<PaymentServiceError> handlePaymentServiceException(PaymentServiceException paymentServiceException) {
        System.out.println("AuthorizationRequestController.handlePaymentServiceException");
        PaymentServiceError paymentServiceError = new PaymentServiceError(paymentServiceException.getExceptionCode(), paymentServiceException.getExceptionMessage());

        // This should happen in case of input constraint validations
        if(paymentServiceException.getExceptionMessageList() != null) {
            paymentServiceError.setErrorMessageList(paymentServiceException.getExceptionMessageList());
        }
        return new ResponseEntity<PaymentServiceError>(paymentServiceError, HttpStatus.BAD_REQUEST);
    }

    // Exception handler for generic Exception cases
    @ExceptionHandler(Exception.class)
    public ResponseEntity<PaymentServiceError> handleException(Exception exception) {
        System.out.println("AuthorizationRequestController.handleException");
        PaymentServiceError paymentServiceError = new PaymentServiceError(400, exception.getMessage());
        return new ResponseEntity<PaymentServiceError>(paymentServiceError, HttpStatus.BAD_REQUEST);
    }
}
