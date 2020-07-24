package by.vikhor.travelbot.infoservice.impl;

import by.vikhor.travelbot.dto.PlaceInfoDto;
import by.vikhor.travelbot.infoservice.PlacesToVisitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesToVisitServiceImpl implements PlacesToVisitService {
    @Override
    public PlaceInfoDto findPlaceInfoByName(String name) {
        PlaceInfoDto placeInfoDto = new PlaceInfoDto();
        placeInfoDto.setDescription("Norm place");
        placeInfoDto.setName("Place");
        placeInfoDto.setRating(5);
        return placeInfoDto;
    }

    @Override
    public List<String> findListOfSupportedPlaces() {
        return List.of("Place", "Norm Place");
    }
}
