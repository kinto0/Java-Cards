package model.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class StandardCard implements ICard {
    private final int value;
    private final String name;
    private final StandardSuit suit;
}
