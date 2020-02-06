package com.epam.engx.cleancode.naming.task4.service;


import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContact;

public interface CustomerContactService {

    CustomerContact getContactDetailsByCustomerId(Long id);

    void updateContactDetails(CustomerContact contactDetails);

}
