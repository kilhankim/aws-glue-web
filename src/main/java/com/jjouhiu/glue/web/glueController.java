package com.jjouhiu.glue.web;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.context.annotation.PropertySource;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.*;
import java.util.*;
import java.net.*;
import com.amazonaws.services.glue.AWSGlueClient;
import com.amazonaws.services.glue.model.GetDatabaseRequest;
import com.amazonaws.services.glue.model.GetCrawlerRequest;
import com.amazonaws.services.glue.AWSGlue;


 
 



@Controller
@CrossOrigin(origins = "*")
public class glueController {

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/test" , method=RequestMethod.GET)
    public @ResponseBody Map test(){
        HashMap resultmap = new HashMap();     
        String databaseName = "jjouhiu-glue-database";
//        GetDatabaseRequest databasesRequest = GetDatabaseRequest
//                  .builder()
//				  .withName(databaseName);
//				  .build();

        GetDatabaseRequest databasesRequest  = new GetDatabaseRequest();
       // databasesRequest.withName(databaseName);

        AWSGlue awsGlueClient = AWSGlueClient.builder().withRegion("us-east-1").build();

        System.out.println(awsGlueClient.getDatabase(new GetDatabaseRequest().withName(databaseName)));
        System.out.println(awsGlueClient.getCrawler(new GetCrawlerRequest().withName("jjouhiu-crawler-kkh")));

         return resultmap;

    }
}