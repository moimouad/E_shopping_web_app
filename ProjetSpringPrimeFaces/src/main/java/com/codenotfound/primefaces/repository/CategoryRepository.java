package com.codenotfound.primefaces.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenotfound.primefaces.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
