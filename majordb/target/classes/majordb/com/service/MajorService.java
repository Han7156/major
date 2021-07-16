package majordb.com.service;



import majordb.com.entity.Major;

import java.util.List;

/**
 * Created by Hunter on 2021-05-28.
 */
public interface MajorService {

    List<Major> list();
    int add(Major major);
    int update(Major major);
    int delete(Integer id);
    Major getByid(Integer id);
}
