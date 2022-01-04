package guru.springframework.msscbrewery.web.mappers;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by jt on 2019-05-25.
 */
@Mapper
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    @Mapping(target = "id", ignore = true)
    Beer beerDtoToBeer(BeerDto dto);
}
