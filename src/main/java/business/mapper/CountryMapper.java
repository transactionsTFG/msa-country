package business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import business.country.Country;
import business.country.CountryDTO;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
    CountryDTO entityToDto(Country country);
}
