package chapter3.part8_2.service;

import chapter3.part8_2.domain.PeriodicReservation;
import chapter3.part8_2.domain.Reservation;
import chapter3.part8_2.domain.SportType;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

	List<Reservation> query(String courtName);

	void make(Reservation reservation)
			throws ReservationNotAvailableException;

	List<SportType> getAllSportTypes();

	SportType getSportType(int sportTypeId);

	List<Reservation> findByDate(LocalDate summaryDate);

	void makePeriodic(PeriodicReservation periodicReservation)
			throws ReservationNotAvailableException;
}
