package com.capgemini.moviemgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviemgt.model.Seat;


@Repository
public interface SeatDao extends JpaRepository<Seat, Integer>{

}
