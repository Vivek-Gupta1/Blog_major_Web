package com.dmw.blogrepository;


import com.dmw.blogentity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserTable,Integer> {
 public Optional<UserTable> findByEmail(String email);

}
