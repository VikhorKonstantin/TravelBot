package by.vikhor.travelbot.infoservice;

import by.vikhor.travelbot.dto.PlaceInfoDto;

import java.util.List;

public interface PlacesToVisitService {
    PlaceInfoDto findPlaceInfoByName(String name);

    List<String> findListOfSupportedPlaces();
}
