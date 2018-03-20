package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.util.StaxonUtils;


@RestController
public class RestAPIController {

    @RequestMapping(value="/xml2json",
    		method=RequestMethod.POST,
    		consumes="application/xml",
    		produces="application/json")
    public ResponseEntity<String> xtoj(HttpServletRequest request, 
			@RequestBody String xml) {
    	//@RequestBody는 HTTP 요청의 body 내용을 자바 객체로 매핑
    	
    	String xml_to_json = StaxonUtils.xml2json(xml);
        System.out.println("xml2json success \n"+xml_to_json);
       
        //HTTP 상태코드와 HTTP 응답에 담을 내용 지정
        return new ResponseEntity<String>(xml_to_json, HttpStatus.OK);
    }
    
    @RequestMapping(value="/json2xml",
    		method=RequestMethod.POST,
    		consumes="application/json",
    		produces="application/xml")
    public ResponseEntity<String> jtox(HttpServletRequest request, 
			@RequestBody String json) {
    	
    	
    	//String xml_header = "<?xml version='1.0' encoding='utf-8'?>"; 
    	String json_to_xml = StaxonUtils.json2xml(json);
        json_to_xml ="<XML>" + json_to_xml + "</XML>";
        
        //HTTP 상태코드와 HTTP 응답에 담을 내용 지정
        return new ResponseEntity<String>(json_to_xml, HttpStatus.OK);
    }
    

    @RequestMapping(value="/status",
    		method=RequestMethod.GET,
    		produces="application/json")
    public ResponseEntity<Map<String,Object>> status() {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("status", "success");
        
        return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
    }
    
    @RequestMapping(value="/uploadFile",
    		method=RequestMethod.POST,
    		produces="application/xml")
    public ResponseEntity<String> uploadJsonFile(HttpServletRequest request,
    		@RequestParam("file") MultipartFile file) throws IOException {
    	String json = new String(file.getBytes());
    	System.out.println("uploadJsonFile success \n" + json);
    	
        return new ResponseEntity<String>(json, HttpStatus.OK);
    }

}
