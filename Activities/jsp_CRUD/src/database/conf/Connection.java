package database.conf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Connection implements IConnectable{
    private String PATH;
    private File file;

    public Connection() throws IOException {
        init();
    }

    @Override
    public void init() throws IOException {
        this.PATH =  "/home/alex/Documents/BootcampAWSoftware/Activities/jsp_CRUD/src/database/myDB.txt";
        file = new File(PATH);
        addColumnsDB();
    }


    /**
     *  Return our current data source.
     * @return List<String> w/ data </String>
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    @Override
    public List<String> getDataSource() throws IOException {
        Path dataPath = Paths.get(PATH);

        List<String> datasource = Arrays.stream(String.valueOf(Files.readAllLines(dataPath))
                .replace("[", "")
                .replace("]", "")
                .split(",")).toList();

        return datasource.stream().skip(1).toList();
    }

    /**
     *  Refresh our data source... it's used when we make changes into data source
     * @param datasource updated
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    @Override
    public void refresh(List<String> datasource) throws IOException {
        addColumnsDB();
        try(FileWriter fl = new FileWriter(PATH, true)){
            for(String d : datasource){
                fl.write(d);
            }
        }
    }

    /**
     *  Adds the columns of our data source
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    private void addColumnsDB() throws IOException {
        deleteContent();
        try(FileWriter fl = new FileWriter(file)){
            fl.write("DNI;NAME;LASTNAME;DATE_BIRTH;PROFESSION"+System.lineSeparator());
        }
    }

    /**
     * Deletes the file where our data source is located
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    private void deleteContent() throws IOException { Files.deleteIfExists(Paths.get(PATH)); }
}
