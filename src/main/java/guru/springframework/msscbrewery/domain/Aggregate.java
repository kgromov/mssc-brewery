package guru.springframework.msscbrewery.domain;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
public class Aggregate {
    private String id;
    private Customer customer;
    private Set<Beer> beers = new HashSet<>();
}
