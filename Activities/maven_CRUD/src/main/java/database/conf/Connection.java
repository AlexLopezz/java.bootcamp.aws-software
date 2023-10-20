package database.conf;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Connection implements IConnectable{
    private String PATH;
    private File file;

    public Connection() throws IOException {
        init();
    }

    @Override
    public void init() throws IOException {
        this.PATH =  "/home/alex/Documents/BootcampAWSoftware/Activities/maven_CRUD/src/main/java/database/myDB.txt";
        file = new File(PATH);
    }


    /**
     *  Return our current data source.
     * @return List<String> w/ data </String>
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    @Override
    public List<String> getDataSource() throws IOException {
        if(!containsContentDB())
            addColumnsDB();

        List<String> datasource = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int numberLine=0;
            String line;
            while ((line = br.readLine()) != null) {
                if(numberLine > 0)
                    datasource.add(line);

                numberLine++;
            }
        }

        return datasource;
    }

    /**
     *  Refresh our data source... it's used when we make changes into data source
     * @param datasource updated
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    @Override
    public void refresh(List<String> datasource) throws IOException {
        try(FileWriter fl = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fl)){

            for (String data : datasource)
                pw.println(data);

        }
    }

    /**
     *  Adds the columns of our data source
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    private void addColumnsDB() throws IOException {
        try(FileWriter fl = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fl)){

            pw.println("DNI;NAME;LASTNAME;DATE_BIRTH;PROFESSION");
        }
    }

    /**
     * Deletes the file where our data source is located
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    private void deleteContentDB() throws IOException { Files.deleteIfExists(Paths.get(PATH)); }

    private boolean containsContentDB() throws IOException {
        return Files.exists(Paths.get(PATH)) && !Files.readAllLines(Paths.get(PATH)).isEmpty();
    }
}
