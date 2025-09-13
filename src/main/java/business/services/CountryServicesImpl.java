package business.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import business.country.Country;
import business.country.CountryDTO;
import business.mapper.CountryMapper;

@Stateless
public class CountryServicesImpl implements CountryServices {
    private EntityManager entityManager;

    @Override
    public CountryDTO getCountryById(long idCountry) {
        Country c = this.entityManager.find(Country.class, idCountry, LockModeType.OPTIMISTIC);
        if(c == null) return null;
        return CountryMapper.INSTANCE.entityToDto(c);
    }

    @Override
    public CountryDTO getCountryByName(String nameCountry) {
        List<Country> listCountries = this.entityManager.createNamedQuery("Country.findByName", Country.class)
                .setParameter("name", nameCountry)
                .setLockMode(LockModeType.OPTIMISTIC)
                .getResultList();
        if(listCountries.isEmpty()) return null;
            else return CountryMapper.INSTANCE.entityToDto(listCountries.get(0));
    }

    @Inject
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
