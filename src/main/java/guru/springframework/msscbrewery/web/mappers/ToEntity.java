package guru.springframework.msscbrewery.web.mappers;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "id", ignore = true)
public @interface ToEntity {
}
