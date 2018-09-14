package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.JobTitle;

@Repository
@Transactional
public interface JobTitleRepository<P> extends JpaRepository<JobTitle, Long>{

}
