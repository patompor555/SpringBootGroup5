package com.pim.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pim.domain.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
