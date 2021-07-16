package majordb.com.service;


import majordb.com.entity.College;

import java.util.List;

/**
 * Created by Hunter on 2021-05-28.
 */
public interface CollegeService {
    List<College> list();
    int add(College college);
    int update(College college);
    int delete(Integer id);
}
