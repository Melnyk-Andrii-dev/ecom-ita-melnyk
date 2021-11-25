package enums.elements;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RegistrationPageInputField {
    FIRSTNAME("firstname"),
    LASTNAME("lastname"),
    EMAIL("email"),
    TELEPHONE("telephone"),
    PASSWORD("password"),
    PASSWORD_CONFIRMATION("confirm");


    private final String xpathField;

    public String toString(){
        return xpathField;
    }


}
