package com.example.dentalclinic.repoInterfaces;

import com.example.dentalclinic.Models.Lottery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILotteryRepository extends JpaRepository<Lottery, Integer> {
}
