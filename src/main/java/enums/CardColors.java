package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CardColors {
    YELLOW("yellow"),
    PURPLE("purple"),
    BLUE("blue"),
    RED("red"),
    GREEN("green"),
    ORANGE("orange"),
    BLACK("black"),
    SKY("sky"),
    PINK("pink"),
    LIME("lime");

    private final String name;

    @Override
    public String toString(){
        return name;
    }
}
