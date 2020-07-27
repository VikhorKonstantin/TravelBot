package by.vikhor.travelbot.handler

import by.vikhor.travelbot.service.placeinfo.PlacesToVisitService
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import spock.lang.Specification

class ListSupportedPlacesCommandHandlerTest extends Specification {
    def "should return list of names each on new line"() {
        given:
            PlacesToVisitService placesToVisitService = Mock {
                findListOfSupportedPlaces() >> List.of("Minsk", "Moscow")
            }
            ListSupportedPlacesCommandHandler listSupportedPlacesCommandHandler =
                    new ListSupportedPlacesCommandHandler(placesToVisitService)
        when:
            SendMessage resp = listSupportedPlacesCommandHandler.handleUpdate(Mock(Update) {
                getMessage() >> Mock(Message) {
                    getChatId() >> 1L
                }
            })
        then:
            resp.getText() == "Minsk\nMoscow"
    }
}
