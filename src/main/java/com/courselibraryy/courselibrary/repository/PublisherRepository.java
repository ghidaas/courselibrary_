package com.courselibraryy.courselibrary.repository;

import com.courselibraryy.courselibrary.entity.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publishers, Integer> {
}