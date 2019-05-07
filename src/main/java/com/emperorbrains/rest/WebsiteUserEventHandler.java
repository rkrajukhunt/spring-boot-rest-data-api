
package com.emperorbrains.rest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@RepositoryEventHandler(WebsiteUser.class)
@Slf4j
public class WebsiteUserEventHandler {
  
  RestTemplate restTemplate = new RestTemplate();
   
  @Autowired
  private HttpServletRequest request;

  @HandleBeforeCreate
  public void handleAuthorBeforeCreate(WebsiteUser author) {
    String remoteAddress = request.getRemoteAddr();
    String forwardedFor = request.getHeader("X-Forwarded-For");
    String realIP = request.getHeader("X-Real-IP");
    
    if( realIP == null )
      realIP = forwardedFor;
    if( realIP == null )
      realIP = remoteAddress;

    String ip = "43.242.116.253"; // paste realIP when application can host;
    IPDetails details = restTemplate.getForObject("http://ip-api.com/json/"+ip,IPDetails.class);
    log.info("{}",details.toString());
  }
}
