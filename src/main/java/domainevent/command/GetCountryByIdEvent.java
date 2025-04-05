package domainevent.command;

import javax.ejb.Local;
import javax.ejb.Stateless;

import business.country.CountryDTO;
import domainevent.command.handler.BaseHandler;
import domainevent.command.handler.EventHandler;
import msa.commons.event.EventId;
import msa.commons.microservices.country.qualifier.GetCountryByIdQualifier;
import msa.commons.parser.NumberParser;

@Stateless
@GetCountryByIdQualifier
@Local(EventHandler.class)
public class GetCountryByIdEvent extends BaseHandler {

    @Override
    public void handleCommand(Object event) {
        long idCountry = NumberParser.toLong(event);
        CountryDTO c = this.countryServices.getCountryById(idCountry);
        this.jmsEventPublisher.publish(EventId.GET_COUNTRY_BY_ID, c);
    }
    
}
