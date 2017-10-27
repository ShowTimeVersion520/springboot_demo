package com.example.demo.dao;

import com.example.demo.model.Gril;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GrilDao extends JpaRepository<Gril, Integer>, JpaSpecificationExecutor<Gril> {
}
