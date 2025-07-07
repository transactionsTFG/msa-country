package domainevent.command;

import javax.ejb.Local;
import javax.ejb.Stateless;

import business.country.CountryDTO;
import business.qualifier.getcountry.GetCountryByNameQualifier;
import domainevent.command.handler.BaseHandler;
import domainevent.command.handler.EventHandler;
import msa.commons.event.EventData;
import msa.commons.event.EventId;

@Stateless
@GetCountryByNameQualifier
@Local(EventHandler.class)
public class GetCountryByNameEvent extends BaseHandler {

    @Override
    public void handleCommand(String json) {
        EventData eventData = EventData.fromJson(json, String.class);
        final String nameCountry = (String) eventData.getData();
        CountryDTO c = this.countryServices.getCountryByName(nameCountry);
        eventData.setData(c);
        this.jmsEventPublisher.publish(EventId.GET_COUNTRY_BY_NAME, eventData);
    }
    
}
