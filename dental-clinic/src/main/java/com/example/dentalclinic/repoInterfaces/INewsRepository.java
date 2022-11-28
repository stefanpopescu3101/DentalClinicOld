package com.example.dentalclinic.repoInterfaces;

import com.example.dentalclinic.Models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewsRepository extends JpaRepository<News, Integer> {
}
