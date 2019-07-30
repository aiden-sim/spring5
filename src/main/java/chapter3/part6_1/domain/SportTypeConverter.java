package chapter3.part6_1.domain;

import chapter3.part6_1.service.ReservationService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SportTypeConverter implements Converter<String, SportType> {

    private final ReservationService reservationService;

    public SportTypeConverter(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public SportType convert(String source) {
        int sportTypeId = Integer.parseInt(source);
        SportType sportType = reservationService.getSportType(sportTypeId);
        return sportType;
    }
}
