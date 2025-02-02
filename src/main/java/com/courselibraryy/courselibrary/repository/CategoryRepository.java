package com.courselibraryy.courselibrary.repository;

import com.courselibraryy.courselibrary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {


}
