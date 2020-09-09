//package com.bookcode.dao;
//
//import java.util.List;
//
//import com.bookcode.entity.Person;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//@RepositoryRestResource(collectionResourceRel = "people", path = "people")     //访问路径
//public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
//    List<Person> findByLastName(@Param("name") String name);
//}
