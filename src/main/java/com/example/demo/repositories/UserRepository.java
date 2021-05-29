package com.example.demo.repositories;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.remote.rmi._RMIConnection_Stub;

public interface UserRepository extends JpaRepository<User, Long> {

}
