package database.conf;

import java.io.IOException;
import java.util.List;

public interface IConnectable {
    void init() throws IOException;
    List<String> getDataSource();

    void refresh(List<String> data);
}
