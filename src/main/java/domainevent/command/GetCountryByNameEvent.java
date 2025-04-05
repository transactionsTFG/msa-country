package domainevent.command;

import javax.ejb.Local;
import javax.ejb.Stateless;

import business.country.CountryDTO;
import domainevent.command.handler.BaseHandler;
import domainevent.command.handler.EventHandler;
import msa.commons.event.EventId;
import msa.commons.event.EventResponse;
import msa.commons.microservices.country.qualifier.GetCountryByNameQualifier;

@Stateless
@GetCountryByNameQualifier
@Local(EventHandler.class)
public class GetCountryByNameEvent extends BaseHandler {

    @Override
    public void handleCommand(EventResponse eventResponse) {
        String nameCountry = (String) eventResponse.getData();
        CountryDTO c = this.countryServices.getCountryByName(nameCountry);
        this.jmsEventPublisher.publish(EventId.GET_COUNTRY_BY_NAME, EventResponse.success(c));
    }
    
}
