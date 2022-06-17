package com.csi.dao;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import com.csi.vo.Billing;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerDaoImpl {

    @Autowired
    CustomerRepo customerRepoImpl;

    @Autowired
    RestTemplate restTemplate;

    public Customer saveData(Customer customer){
        return customerRepoImpl.save(customer);
    }

    public RestTemplateVO getDataById(long customerId){
            RestTemplateVO restTemplateVO = new RestTemplateVO();

            Customer customer=customerRepoImpl.findByCustomerId(customerId);

            Billing billing= restTemplate.getForObject("http://BillingService/billings/"+customer.getBillingId(), Billing.class);

            restTemplateVO.setCustomer(customer);
            restTemplateVO.setBilling(billing);



            return restTemplateVO;
    }


}
