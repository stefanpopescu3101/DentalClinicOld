package com.example.dentalclinic.repoInterfaces;

import com.example.dentalclinic.Models.Lottery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILotteryRepository extends JpaRepository<Lottery, Integer> {

    @Query(value = "SELECT * FROM `lottery` as l INNER JOIN customer_lotteries as c WHERE c.client_id = ?1 ", nativeQuery = true)
    List<Lottery> findClientLotteries(Integer clientId);
}
