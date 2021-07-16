package majordb.com.service.impl;


import majordb.com.entity.College;
import majordb.com.mapper.CollegeMapper;
import majordb.com.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hunter on 2021-05-28.
 */
@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    CollegeMapper mapper;

    @Override
    public List<College> list() {
        return mapper.selectAll();
    }

    @Override
    public int add(College college) {
        return mapper.insert(college);
    }

    @Override
    public int update(College college) {
        return mapper.updateByPrimaryKey(college);
    }

    @Override
    public int delete(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }
}
