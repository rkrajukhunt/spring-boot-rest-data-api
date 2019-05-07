package com.emperorbrains.rest;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

//@CrossOrigin(origins= "http://localhost:1214",methods=RequestMethod.GET,allowedHeaders="origin",exposedHeaders="custom-header1")

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<WebsiteUser, Long>{
  List<WebsiteUser> findByName(@Param("name") String name);
  
}
