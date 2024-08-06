package com.rajan.RestTemplateDemo.service;

import com.rajan.RestTemplateDemo.output.PostOfficeResponseBean;

public interface PostalService {
    public PostOfficeResponseBean fetchPostOfficeDetailsByCity(String city);

    public PostOfficeResponseBean fetchPostOfficeDetailsByPincode(String pincode);


}
