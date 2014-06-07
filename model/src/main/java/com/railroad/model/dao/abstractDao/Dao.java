package com.railroad.model.dao.abstractDao;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Elena on 4/24/14.
 */
@Transactional(Transactional.TxType.REQUIRED)
public interface Dao<T> {

    void save(T object);

    void update(T object);

    void delete(T object);

    T get(Integer id);

    List<T> getAll();
}
