package model;

import controller.IController;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StandardCard implements ICard {
    private final int value;
    private final String name;
    private final StandardSuit suit;
}
