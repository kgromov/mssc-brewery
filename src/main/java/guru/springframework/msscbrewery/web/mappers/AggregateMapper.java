package guru.springframework.msscbrewery.web.mappers;

import guru.springframework.msscbrewery.domain.Aggregate;
import guru.springframework.msscbrewery.web.model.AggregateDto;
import org.mapstruct.Mapper;

@Mapper(uses = {CustomerMapper.class, BeerMapper.class})
public interface AggregateMapper {

    AggregateDto aggregateToAggregateDto(Aggregate aggregate);

    @ToEntity
    Aggregate aggregateDtoToAggregate(AggregateDto aggregate);
}
