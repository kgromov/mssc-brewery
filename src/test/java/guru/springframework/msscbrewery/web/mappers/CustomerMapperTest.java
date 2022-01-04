package guru.springframework.msscbrewery.web.mappers;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

//@RunWith(MockitoJUnitRunner.class)
class CustomerMapperTest {

    @Test
    void customerToCustomerDto() {

    }

    @Test
    void customerDtoToCustomer() {
        CustomerDto dto = CustomerDto.builder()
            .id(UUID.randomUUID())
            .name("Some name")
            .build();
    }
}
