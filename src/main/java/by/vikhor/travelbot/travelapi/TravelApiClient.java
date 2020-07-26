package by.vikhor.travelbot.travelapi;

import by.vikhor.travelbot.botconfig.BotConfigurationProperties;
import by.vikhor.travelbot.dto.PlaceInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static by.vikhor.travelbot.travelapi.TravelApiConstants.PLACES_RESOURCE;

@Service
public class TravelApiClient {
    private final RestTemplate restTemplate;

    @Autowired
    public TravelApiClient(RestTemplateBuilder restTemplateBuilder,
                           BotConfigurationProperties configurationProperties) {
        restTemplate = restTemplateBuilder
                .rootUri(configurationProperties.getTravelApiUrl())
                .build();
    }

    public List<PlaceInfoDto> findAllPlacesInfo() {
        ResponseEntity<CollectionModel<PlaceInfoDto>> response = restTemplate.exchange(PLACES_RESOURCE,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<CollectionModel<PlaceInfoDto>>() {
                });
        CollectionModel<PlaceInfoDto> body = response.getBody();
        if (body != null) {
            return new ArrayList<>(body.getContent());
        } else {
            return Collections.emptyList();
        }
    }

    public Optional<PlaceInfoDto> findPlaceInfoByPlaceName(String name) {
        ResponseEntity<EntityModel<PlaceInfoDto>> response = restTemplate.exchange(createFindByNameUrl(name),
                HttpMethod.GET, null,
                new ParameterizedTypeReference<EntityModel<PlaceInfoDto>>() {
                });
        EntityModel<PlaceInfoDto> body = response.getBody();
        if (body != null) {
            return Optional.ofNullable(body.getContent());
        } else {
            return Optional.empty();
        }
    }

    private String createFindByNameUrl(String name) {
        return String.format(TravelApiConstants.FIND_BY_NAME_URL_TEMPLATE, name);
    }
}
