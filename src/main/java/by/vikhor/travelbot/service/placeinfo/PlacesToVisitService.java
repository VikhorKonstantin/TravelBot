package by.vikhor.travelbot.service.placeinfo;

import by.vikhor.travelbot.dto.PlaceInfoDto;

import java.util.List;
import java.util.Optional;

public interface PlacesToVisitService {
    Optional<PlaceInfoDto> findPlaceInfoByName(String name);

    List<String> findListOfSupportedPlaces();
}
