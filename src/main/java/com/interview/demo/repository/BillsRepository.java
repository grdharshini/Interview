package com.interview.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.demo.entity.Bills;

@Repository
public interface BillsRepository extends JpaRepository<Bills, UUID> {

}
