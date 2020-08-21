package learnBuilder;

import lombok.Builder;
import lombok.ToString;


@Builder
@ToString
public class User {

    private Integer id;
    private String name;
    private String address;

}
