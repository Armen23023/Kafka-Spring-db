package com.example.KafkaSpringdb.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User,Long> {
}
