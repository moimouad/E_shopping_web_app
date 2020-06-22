package com.codenotfound.primefaces.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenotfound.primefaces.model.Card;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
