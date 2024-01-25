package com.ecomerce.ecomerce.repository;

import com.ecomerce.ecomerce.model.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
