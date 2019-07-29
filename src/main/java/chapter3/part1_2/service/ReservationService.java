package chapter3.part1_2.service;

import chapter3.part1_2.domain.Reservation;

import java.util.List;

public interface ReservationService {
	public List<Reservation> query(String courtName);
}
