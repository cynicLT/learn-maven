package org.cynic.megaapplication.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import org.springframework.stereotype.Component;

@Component
public class SampleService {

  public String process(String text) {
    URL url = getClass().getClassLoader().getResource("application.properties");
    try {
      File file = new File(url.toURI());

      FileReader fileReader = new FileReader(file);
      char[] data = new char[1000];

      fileReader.read(data);

      return new StringBuilder(new String(data)).reverse().toString() + text;
    } catch (IOException | URISyntaxException e) {
      return null;
    }
  }

  public String processFile(String fileName) throws URISyntaxException, IOException {
    URL url = getClass().getClassLoader().getResource(fileName);
    File file = new File(url.toURI());
    FileReader fileReader = new FileReader(file);
    char[] data = new char[1000];
    fileReader.read(data);
    return new String(data);
  }
}
