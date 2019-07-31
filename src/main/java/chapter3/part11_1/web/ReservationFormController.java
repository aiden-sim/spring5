package chapter3.part11_1.web;

import chapter3.part11_1.domain.Player;
import chapter3.part11_1.domain.Reservation;
import chapter3.part11_1.domain.SportType;
import chapter3.part11_1.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {

	private final ReservationService reservationService;

	public ReservationFormController(ReservationService reservationService) {
		this.reservationService = reservationService;
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
			@ModelAttribute("reservation") @Valid Reservation reservation,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "reservationForm";
		} else {
			reservationService.make(reservation);
			status.setComplete();
			return "redirect:reservationSuccess";
		}
	}
}
