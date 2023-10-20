package services;

import java.util.List;

public interface IService <T>{
    List<T> getAll();
    void save(T t);
    void delete(T t);
    void saveAll(List<T> tts);
}
