package chapter3.part9_1.web;

import chapter3.part9_1.domain.Player;
import chapter3.part9_1.domain.Reservation;
import chapter3.part9_1.domain.ReservationValidator;
import chapter3.part9_1.domain.SportType;
import chapter3.part9_1.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {
	private ReservationService reservationService;
	private ReservationValidator reservationValidator;

	public ReservationFormController(ReservationService reservationService, ReservationValidator reservationValidator) {
		this.reservationService = reservationService;
		this.reservationValidator = reservationValidator;
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
			@ModelAttribute("reservation") @Validated Reservation reservation, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "reservationForm";
		} else {
			reservationService.make(reservation);
			status.setComplete(); // 세션 종료
			return "redirect:reservationSuccess"; // 중복 폼 전송 방지
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(reservationValidator);
	}
}