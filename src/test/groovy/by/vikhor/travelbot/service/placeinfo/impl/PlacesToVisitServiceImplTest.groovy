package by.vikhor.travelbot.service.placeinfo.impl

import by.vikhor.travelbot.dto.PlaceInfoDto
import by.vikhor.travelbot.travelapi.TravelApiClient
import spock.lang.Specification

class PlacesToVisitServiceImplTest extends Specification {

    def "should return moscow place info"() {
        given:
            def placeInfoDto = new PlaceInfoDto()
            def moscowName = "Moscow"
            def rating = 5
            def description = "Москва хороший город"
            placeInfoDto.name = moscowName
            placeInfoDto.description = description
            placeInfoDto.rating = rating
            TravelApiClient travelApiClient = Mock {
                findPlaceInfoByPlaceName(moscowName) >> Optional.of(placeInfoDto)
            }
            PlacesToVisitServiceImpl placesToVisitService = new PlacesToVisitServiceImpl(travelApiClient)
        when:
            def placeInfoOptional = placesToVisitService.findPlaceInfoByName(moscowName)
        then:
            placeInfoOptional.isPresent() && placeInfoOptional.get() == placeInfoDto
    }

    def "should return list of names"() {
        given:
            PlaceInfoDto placeInfoDto1 = new PlaceInfoDto()
            def minskName = "Minsk"
            def rating1 = 3
            def description1 = "Минск хороший город"
            placeInfoDto1.name = minskName
            placeInfoDto1.description = description1
            placeInfoDto1.rating = rating1
            PlaceInfoDto placeInfoDto2 = new PlaceInfoDto()
            def moscowName = "Moscow"
            def rating2 = 3
            def description2 = "Москва хороший город"
            placeInfoDto2.name = moscowName
            placeInfoDto2.description = description2
            placeInfoDto2.rating = rating2
            TravelApiClient travelApiClient = Mock {
                findAllPlacesInfo() >> List.of(placeInfoDto1, placeInfoDto2)
            }
            PlacesToVisitServiceImpl placesToVisitService = new PlacesToVisitServiceImpl(travelApiClient)
        when:
            def listOfNames = placesToVisitService.findListOfSupportedPlaces()
        then:
            listOfNames == List.of(minskName, moscowName)
    }


}