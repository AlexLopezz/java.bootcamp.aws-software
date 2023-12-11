package com.alexdev.springboot_CRUD.database.conf;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

public interface IConnectable {
    void init() throws IOException;
    List<String> getDataSource() throws IOException;

    void refresh(List<String> data) throws IOException;
}
