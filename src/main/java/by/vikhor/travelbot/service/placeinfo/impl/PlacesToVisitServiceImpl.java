package by.vikhor.travelbot.service.placeinfo.impl;

import by.vikhor.travelbot.dto.PlaceInfoDto;
import by.vikhor.travelbot.service.placeinfo.PlacesToVisitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacesToVisitServiceImpl implements PlacesToVisitService {
    @Override
    public Optional<PlaceInfoDto> findPlaceInfoByName(String name) {
        PlaceInfoDto placeInfoDto = new PlaceInfoDto();
        placeInfoDto.setDescription("Norm place");
        placeInfoDto.setName("Place");
        placeInfoDto.setRating(5);
        return Optional.of(placeInfoDto);
    }

    @Override
    public List<String> findListOfSupportedPlaces() {
        return List.of("Place", "Norm Place");
    }
}
