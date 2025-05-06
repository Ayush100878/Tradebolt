package com.example.tradebolt.repository;

import com.example.tradebolt.Modal.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, String> {
}
