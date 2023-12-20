package database.conf;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

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
        if (System.getProperty("os.name").equals("Linux"))
            this.PATH = "/home/alexdev/Documents/BootcampAWSoftware/tomcat-jsp-CRUD/src/database/myDB.txt";
        else
            this.PATH = "C:\\Users\\Alex\\Documents\\BootcampAWSoftware\\tomcat-jsp-CRUD\\src\\database\\myDB.txt";

    }

    private void createFile() throws IOException {
        if(!new File(PATH).exists())
            Files.createFile(Paths.get(PATH));
    }

    @Override
    public List<String> getDataSource() {
        List<String> datasource = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null)
                datasource.add(line);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return datasource;
    }

    @Override
    public void refresh(List<String> datasource) {
        try(FileWriter fl = new FileWriter(PATH, false);
            PrintWriter pw = new PrintWriter(fl)){

            for (String data : datasource)
                pw.println(data);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}