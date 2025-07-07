package domainevent.registry;

import java.util.EnumMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import domainevent.command.handler.EventHandler;

import msa.commons.event.EventId;
import business.qualifier.getcountry.GetCountryByIdQualifier;
import business.qualifier.getcountry.GetCountryByNameQualifier;


@Singleton
@Startup
public class EventHandlerRegistry {
    private Map<EventId, EventHandler> handlers = new EnumMap<>(EventId.class);
    private EventHandler getCountryByIdHandler;
    private EventHandler getCountryByNameHandler;

    @PostConstruct
    public void init(){
        this.handlers.put(EventId.GET_COUNTRY_BY_ID, getCountryByIdHandler);
        this.handlers.put(EventId.GET_COUNTRY_BY_NAME, getCountryByNameHandler);
    }

    public EventHandler getHandler(EventId eventId) {
        return this.handlers.get(eventId);
    }

    @Inject
    public void setGetCountryByIdHandler(@GetCountryByIdQualifier EventHandler getCountryByIdHandler) {
        this.getCountryByIdHandler = getCountryByIdHandler;
    }

    @Inject
    public void setGetCountryByNameHandler(@GetCountryByNameQualifier EventHandler getCountryByNameHandler) {
        this.getCountryByNameHandler = getCountryByNameHandler;
    }
}
