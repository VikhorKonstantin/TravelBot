package by.vikhor.travelbot.travelapi;

import by.vikhor.travelbot.botconfig.BotConfigurationProperties;
import by.vikhor.travelbot.dto.PlaceInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static by.vikhor.travelbot.travelapi.TravelApiConstants.PLACES_RESOURCE;

@Service
public class TravelApiClient {
    private final RestTemplateBuilder restTemplateBuilder;
    private final BotConfigurationProperties configurationProperties;

    @Autowired
    public TravelApiClient(RestTemplateBuilder restTemplateBuilder,
                           BotConfigurationProperties configurationProperties) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.configurationProperties = configurationProperties;
    }

    public List<PlaceInfoDto> findAllPlacesInfo() {
        RestTemplate restTemplate = restTemplateBuilder
                .rootUri(configurationProperties.getTravelApiUrl())
                .build();
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
}