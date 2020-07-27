package by.vikhor.travelbot.handler

import by.vikhor.travelbot.dto.PlaceInfoDto
import by.vikhor.travelbot.service.placeinfo.PlacesToVisitService
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import spock.lang.Specification

class PlaceInfoRequestHandlerTest extends Specification {

    def "should return SendMessage with Moscow info"() {
        given:
            def placeInfoDto = new PlaceInfoDto()
            def moscowName = "Moscow"
            def chatId = 1L
            def rating = 5
            def description = "Москва хороший город"
            placeInfoDto.name = moscowName
            placeInfoDto.description = description
            placeInfoDto.rating = rating
            PlacesToVisitService placesToVisitService = Mock {
                findPlaceInfoByName(moscowName) >> Optional.of(placeInfoDto)
            }
            PlaceInfoRequestHandler placeInfoRequestHandler = new PlaceInfoRequestHandler(placesToVisitService)
        when:
            SendMessage resp = placeInfoRequestHandler.handleUpdate(Mock(Update) {
                getMessage() >> Mock(Message) {
                    getText() >> moscowName
                    getChatId() >> chatId
                }
            })
        then:
            resp.getText() == String.format("Name: %s%nRating: %d%nDescription: %s", moscowName, rating, description)
            resp.getChatId() == chatId.toString()
    }

    def "should return SendMessage with not found message"() {
        given:
            def minskName = "Minsk"
            def chatId = 1L
            PlacesToVisitService placesToVisitService = Mock {
                findPlaceInfoByName(minskName) >> Optional.empty()
            }
            PlaceInfoRequestHandler placeInfoRequestHandler = new PlaceInfoRequestHandler(placesToVisitService)
        when:
            SendMessage resp = placeInfoRequestHandler.handleUpdate(Mock(Update) {
                getMessage() >> Mock(Message) {
                    getText() >> minskName
                    getChatId() >> chatId
                }
            })
        then:
            resp.getText() == HandlersConstants.PLACE_NOT_FOUND_MSG
    }
}
