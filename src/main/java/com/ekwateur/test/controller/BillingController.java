package com.ekwateur.test.controller;

import com.ekwateur.test.service.BillingService;
import com.ekwateur.test.util.CSVreader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("/billing")
public class BillingController {
    @Autowired
    private BillingService billingService;

    @GetMapping("/{id}/{date}")
    public ResponseEntity getBillingInformation(@PathVariable String id, @PathVariable String date) {
        String billingInformation = billingService.getBillofMonth(id, date);
        return new ResponseEntity(billingInformation, HttpStatus.OK);
    }

}
