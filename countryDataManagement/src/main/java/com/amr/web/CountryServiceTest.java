/*
@author: agohar
since : 6/19/2019
*/
package com.amr.web;

import com.amr.web.service.CommonConstants;
import com.amr.web.service.CountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CountryServiceTest {

    @Autowired
    CountryService countryService;

    @Test
    public void testCountryCodeExist() throws Exception {
        assertEquals(CommonConstants.ERROR_INVALID_COUNTRY_CODE, countryService.getData("THULD").getReplyMessage());
    }

    @Test
    public void testDataBaseFailed() throws Exception {
        assertEquals(CommonConstants.INTERNAL_ERROR, countryService.getData("BHR").getReplyMessage());
    }
}

