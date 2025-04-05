package domainevent.command.handler;

import javax.ejb.EJB;
import javax.inject.Inject;

import com.google.gson.Gson;

import business.services.CountryServices;
import domainevent.publisher.IJMSEventPublisher;

public abstract class BaseHandler implements EventHandler {
    protected CountryServices countryServices;
    protected IJMSEventPublisher jmsEventPublisher;
    protected Gson gson;
    @EJB
    public void setTypeUserServices(CountryServices countryServices) {
        this.countryServices = countryServices;
    }

    @EJB
    public void setJmsEventPublisher(IJMSEventPublisher jmsEventPublisher) {
        this.jmsEventPublisher = jmsEventPublisher;
    }

    @Inject
    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
