package guru.springframework.msscbrewery;

import guru.springframework.msscbrewery.domain.Customer;
import guru.springframework.msscbrewery.web.mappers.CustomerMapper;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsscBreweryApplicationTests {
    @Autowired CustomerMapper customerMapper;

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
    }

}
