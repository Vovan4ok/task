package shared;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDao <T> {
    void create(T t);
    T read(Integer id);
    void update(T t, Integer id);
    void delete(Integer id);
    List<T> readAll();
}
