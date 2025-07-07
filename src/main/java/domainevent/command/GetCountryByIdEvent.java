package domainevent.command;

import javax.ejb.Local;
import javax.ejb.Stateless;

import business.country.CountryDTO;
import business.qualifier.getcountry.GetCountryByIdQualifier;
import domainevent.command.handler.BaseHandler;
import domainevent.command.handler.EventHandler;
import msa.commons.event.EventData;
import msa.commons.event.EventId;
import msa.commons.parser.NumberParser;

@Stateless
@GetCountryByIdQualifier
@Local(EventHandler.class)
public class GetCountryByIdEvent extends BaseHandler {

    @Override
    public void handleCommand(String json) {
        EventData eventData = EventData.fromJson(json, Long.class);
        long idCountry = (Long) eventData.getData();
        CountryDTO c = this.countryServices.getCountryById(idCountry);
        eventData.setData(c);
        this.jmsEventPublisher.publish(EventId.GET_COUNTRY_BY_ID, eventData);
    }
    
}
