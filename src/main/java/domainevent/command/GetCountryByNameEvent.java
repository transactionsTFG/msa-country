package domainevent.command;

import javax.ejb.Local;
import javax.ejb.Stateless;

import business.country.CountryDTO;
import domainevent.command.handler.BaseHandler;
import domainevent.command.handler.EventHandler;
import msa.commons.event.EventId;
import msa.commons.microservices.country.qualifier.GetCountryByNameQualifier;

@Stateless
@GetCountryByNameQualifier
@Local(EventHandler.class)
public class GetCountryByNameEvent extends BaseHandler {

    @Override
    public void handleCommand(Object event) {
        String nameCountry = (String) event;
        CountryDTO c = this.countryServices.getCountryByName(nameCountry);
        this.jmsEventPublisher.publish(EventId.GET_COUNTRY_BY_NAME, c);
    }
    
}
