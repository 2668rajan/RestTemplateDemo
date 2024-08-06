package com.rajan.RestTemplateDemo.controller;

import com.rajan.RestTemplateDemo.output.PostOfficeResponseBean;
import com.rajan.RestTemplateDemo.service.impl.PostalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;

@RestController
@RequestMapping("/postal")
public class PostalDetailsController {

    @Autowired
    private PostalServiceImpl postalService;

    //by city
    @RequestMapping(value = "/byCity", method = RequestMethod.GET,
                    consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostOfficeResponseBean getPostalByCity(@RequestParam String city){

        PostOfficeResponseBean postResponse =
                postalService.fetchPostOfficeDetailsByCity(city);
        return postResponse;
    }

    //byPincode
    @RequestMapping(value = "/byPincode", method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostOfficeResponseBean getPostalByPincode(@RequestParam String pincode){

        PostOfficeResponseBean postResponse =
                postalService.fetchPostOfficeDetailsByPincode(pincode);
        return postResponse;
    }


}
