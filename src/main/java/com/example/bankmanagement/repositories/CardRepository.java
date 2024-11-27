package com.example.bankmanagement.repositories;

import com.example.bankmanagement.entity.Account;
import com.example.bankmanagement.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
