package kviz.etf.bg.ac.rs.Response;

import lombok.Data;

@Data
public class PmuResponse <T>{
    T dto;
    String errorMessage;
    Boolean isValid;
}
