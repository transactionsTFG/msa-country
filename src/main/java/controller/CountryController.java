package controller;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import business.country.CountryDTO;
import business.services.CountryServices;

@Path("/country")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CountryController {
    
    private CountryServices countryServices;

    @GET
    @Path("/name/{countryName}")
    public CountryDTO getCountry(@PathParam("countryName") String countryName) {
        return countryServices.getCountryByName(countryName);
    }

    @EJB
    public void setCountryServices(CountryServices countryServices) {
        this.countryServices = countryServices;
    }

}
