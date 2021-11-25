package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TableFields {
    INPUT_DATA("inputData"),
    FIELD_NAME("fieldName"),
    FIELD("field"),
    TEXT("text");

    private final String name;

    @Override
    public String toString(){
        return name;
    }
}
