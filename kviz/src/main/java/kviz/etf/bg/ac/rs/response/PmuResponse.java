package kviz.etf.bg.ac.rs.response;

import lombok.Data;

@Data
public class PmuResponse <T>{
    T dto;
    String errorMessage;
    Boolean isValid;
}
