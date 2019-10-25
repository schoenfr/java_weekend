package schoenfr.java.weekend.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BookDto {

    String name;

    int year;

    String authorName;

    String coverImageUrl;

}
