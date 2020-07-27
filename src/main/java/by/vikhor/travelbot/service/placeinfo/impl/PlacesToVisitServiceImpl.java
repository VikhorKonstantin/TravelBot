package by.vikhor.travelbot.service.placeinfo.impl;

import by.vikhor.travelbot.dto.PlaceInfoDto;
import by.vikhor.travelbot.service.placeinfo.PlacesToVisitService;
import by.vikhor.travelbot.travelapi.TravelApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlacesToVisitServiceImpl implements PlacesToVisitService {

    private final TravelApiClient travelApiClient;

    @Autowired
    public PlacesToVisitServiceImpl(TravelApiClient travelApiClient) {
        this.travelApiClient = travelApiClient;
    }

    @Override
    public Optional<PlaceInfoDto> findPlaceInfoByName(String name) {
        return travelApiClient.findPlaceInfoByPlaceName(name.trim());
    }

    @Override
    public List<String> findListOfSupportedPlaces() {
        return travelApiClient.findAllPlacesInfo().stream()
                .map(PlaceInfoDto::getName)
                .collect(Collectors.toList());
    }
}
