package guru.springframework.msscbrewery.domain;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
//@Entity
public class Customer {
    private UUID id;
    private String name;
}
