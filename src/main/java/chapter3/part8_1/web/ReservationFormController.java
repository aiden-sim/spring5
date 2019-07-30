package chapter3.part8_1.web;

import chapter3.part8_1.domain.Player;
import chapter3.part8_1.domain.Reservation;
import chapter3.part8_1.domain.ReservationValidator;
import chapter3.part8_1.domain.SportType;
import chapter3.part8_1.service.ReservationNotAvailableException;
import chapter3.part8_1.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {

	private final ReservationService reservationService;
	private final ReservationValidator validator;

	public ReservationFormController(ReservationService reservationService,
			ReservationValidator validator) {
		this.reservationService = reservationService;
		this.validator = validator;
	}

	@ModelAttribute("sportTypes")
	public List<SportType> populateSportTypes() {
		return reservationService.getAllSportTypes();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(
			@RequestParam(required = false, value = "username") String username,
			Model model) {

		Reservation reservation = new Reservation();
		reservation.setPlayer(new Player(username, null));

		model.addAttribute("reservation", reservation);

		return "reservationForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
			@ModelAttribute("reservation") Reservation reservation,
			BindingResult result, SessionStatus status) {

		validator.validate(reservation, result);
		if (result.hasErrors()) {
			return "reservationForm";
		} else {
			reservationService.make(reservation);
			status.setComplete();

			return "redirect:reservationSuccess";
		}
	}

	@ExceptionHandler(ReservationNotAvailableException.class)
	public String handle(ReservationNotAvailableException ex) {
		return "reservationNotAvailable";
	}

	@ExceptionHandler
	public String handleDefault(Exception e) {
		return "error";
	}
}
