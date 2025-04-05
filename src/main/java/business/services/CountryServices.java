package business.services;

import business.country.CountryDTO;

public interface CountryServices {
    CountryDTO getCountryById(long idCountry);
    CountryDTO getCountryByName(String nameCountry);
}
