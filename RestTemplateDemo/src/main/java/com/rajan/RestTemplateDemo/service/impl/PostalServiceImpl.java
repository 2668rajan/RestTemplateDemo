package com.rajan.RestTemplateDemo.service.impl;

import com.rajan.RestTemplateDemo.output.PostOfficeDetailsBean;
import com.rajan.RestTemplateDemo.output.PostOfficeResponseBean;
import com.rajan.RestTemplateDemo.service.PostalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("postalServiceImpl")
public class PostalServiceImpl implements PostalService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public PostOfficeResponseBean fetchPostOfficeDetailsByCity(String cityValue) {

        String url = "https://api.postalpincode.in/postoffice/{city}";
        url = url.replace("{city}", cityValue);
        System.out.println("URL is : " + url);

        ResponseEntity<PostOfficeResponseBean[]> postalResponseEntity =
                restTemplate.getForEntity(url, PostOfficeResponseBean[].class);

        System.out.println("Response status code is : " + postalResponseEntity.getStatusCode());

        PostOfficeResponseBean[] responseBeanArray = postalResponseEntity.getBody();

        for(PostOfficeResponseBean responseBean : responseBeanArray){
            List<PostOfficeDetailsBean> postOfficeList = responseBean.getPostOffice();
                for(PostOfficeDetailsBean pob : postOfficeList){
                    System.out.println(pob.getName()+"--" + pob.getCircle()+ "--" + pob.getDistrict() + "--" + pob.getPincode());
                }
        }

        return responseBeanArray[0];
    }

    @Override
    public PostOfficeResponseBean fetchPostOfficeDetailsByPincode(String pincode) {

        String url = "https://api.postalpincode.in/pincode/{pincode}";
        url = url.replace("{pincode}", pincode);
        System.out.println("URL is : " + url);

        ResponseEntity<PostOfficeResponseBean[]> postalResponseEntity =
                restTemplate.getForEntity(url, PostOfficeResponseBean[].class);

        System.out.println("Response status code is : " + postalResponseEntity.getStatusCode());
        PostOfficeResponseBean[] responseBeanArray = postalResponseEntity.getBody();

        for(PostOfficeResponseBean responseBean : responseBeanArray){
            List<PostOfficeDetailsBean> postOfficeList = responseBean.getPostOffice();
            for(PostOfficeDetailsBean pob : postOfficeList){
                System.out.println(pob.getName()+"--" + pob.getCircle()+ "--" + pob.getDistrict() + "--" + pob.getPincode());
            }
        }

        return responseBeanArray[0];
    }

}
