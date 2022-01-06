package guru.springframework.msscbrewery;

import guru.springframework.msscbrewery.domain.Aggregate;
import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.domain.Customer;
import guru.springframework.msscbrewery.web.mappers.AggregateMapper;
import guru.springframework.msscbrewery.web.mappers.BeerMapper;
import guru.springframework.msscbrewery.web.mappers.CustomerMapper;
import guru.springframework.msscbrewery.web.model.AggregateDto;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsscBreweryApplicationTests {
    @Autowired CustomerMapper customerMapper;
    @Autowired BeerMapper beerMapper;
    @Autowired AggregateMapper aggregateMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void customerDtoToCustomer() {
        CustomerDto dto = CustomerDto.builder()
            .id(UUID.randomUUID())
            .name("Some name")
            .build();
        Customer customer = customerMapper.customerDtoToCustomer(dto);
        assertThat(customer.getId()).isNull();;
        assertThat(customer.getName()).isEqualTo(dto.getName());
    }

    @Test
    public void toAggregateMapping() {
        CustomerDto customer = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Some name")
                .build();

        BeerDto beer = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Paulaner")
                .beerStyle(BeerStyleEnum.PISLSNER)
                .upc(2L)
                .build();

        AggregateDto aggregateDto = AggregateDto.builder()
                .id(UUID.randomUUID().toString())
                .customer(customer)
                .beers(Set.of(beer))
                .build();

        Aggregate aggregate = aggregateMapper.aggregateDtoToAggregate(aggregateDto);
        assertThat(aggregate.getId()).isNull();
        assertThat(aggregate.getCustomer().getId()).isNull();
        assertThat(aggregate.getCustomer().getName()).isEqualTo(customer.getName());
        assertThat(aggregate.getBeers()).extracting(Beer::getId).containsOnlyNulls();
        assertThat(aggregate.getBeers()).extracting(Beer::getBeerName).contains(beer.getBeerName());
    }

}
