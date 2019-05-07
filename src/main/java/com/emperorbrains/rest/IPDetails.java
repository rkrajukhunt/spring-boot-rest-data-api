package com.emperorbrains.rest;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.lang.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPDetails {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  @JsonProperty("query")
  @Nullable
  private String ip;
  
  @JsonProperty("mobile")
  @Nullable
  private String mobile;
  
  @JsonProperty("country")
  @Nullable
  private String country_name;
  
  @JsonProperty("regionName")
  @Nullable
  private String region_name;
  
  @JsonProperty("city")
  @Nullable
  private String city;
  
  @JsonProperty("zip")
  @Nullable
  private String zip;
  
  @JsonProperty("lat")
  @Nullable
  private String latitude;
  
  @JsonProperty("lon")
  @Nullable
  private String longitude;
  
  @JsonProperty("isp")
  @Nullable
  private String isp;
  
  @JsonProperty("as")
  @Nullable
  private String as;
  
  @JsonProperty("org") 
  @Nullable
  private String org;
  
  @Temporal(TemporalType.TIMESTAMP)
  Date timestamp;
}
