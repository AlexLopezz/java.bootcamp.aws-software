package com.ar.alexdev.cxfspringbootrs_CRUD.mappers;

import java.text.ParseException;

public interface Mapper <U,D> {
    D castToDTO(U u);
    U castToPOJO(D d) throws ParseException;
}
