package com.bookcode.repository;

import com.bookcode.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @Author EdiMen
 * @Data 2020/9/8--0:07
 * @Version 1.0
 */
@Component
public interface UserRepository extends CrudRepository<User,Long> {
}
