package database.conf;

import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

@Component
public class Connection implements IConnectable{
    private String PATH;

    public Connection() throws IOException {
        init();
    }

    @Override
    public void init() throws IOException {
        initPath();
        createFile();
    }

    private void initPath(){
        switch (System.getProperty("os.name")){
            case "Windows 10" -> this.PATH = "C:\\Users\\Alex\\Documents\\BootcampAWSoftware\\Activities\\maven_CRUD\\src\\main\\java\\database\\myDB.txt";
            case "Linux"   -> this.PATH =  "/home/alex/Documents/BootcampAWSoftware/Activities/maven_CRUD/src/main/java/database/myDB.txt";
        }
    }
    private void createFile() throws IOException {
        if(!new File(PATH).exists())
            Files.createFile(Paths.get(PATH));
    }

    /**
     *  Return our current data source.
     * @return List<String> w/ data </String>
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    @Override
    public List<String> getDataSource() throws IOException {
        List<String> datasource = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null)
                datasource.add(line);
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
        try(FileWriter fl = new FileWriter(PATH, false);
            PrintWriter pw = new PrintWriter(fl)){

            for (String data : datasource)
                pw.println(data);
        }
    }

}