package org.cynic.megaapplication.controller;

import org.cynic.megaapplication.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

  @Autowired
  private SampleService sampleService;

  @GetMapping("/echo/{text}")
  public int echo(@PathVariable String text) {
    LOGGER.info("response", text);

    String result = text == "banana" ? sampleService.process(text) : "cacosa";
    LOGGER.info("result is " + result);

    return result.length();
  }
}
