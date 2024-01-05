package com.ar.alexdev.cxfspringbootws_CRUD.mappers;

import java.text.ParseException;

public interface Mapper <U,D> {
    D castToDTO(U u);
    U castToPOJO(D d) throws ParseException;
}
