package com.kspt.app.repository;

import com.kspt.app.entities.Complaint;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JPARepository<Complaint>  {
}
