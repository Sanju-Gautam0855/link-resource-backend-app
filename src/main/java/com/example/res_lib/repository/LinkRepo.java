package com.example.res_lib.repository;

import com.example.res_lib.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepo extends JpaRepository<Link, Long> {
}
