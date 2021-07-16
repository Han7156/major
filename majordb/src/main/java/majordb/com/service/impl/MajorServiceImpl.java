package majordb.com.service.impl;


import majordb.com.entity.Major;
import majordb.com.mapper.MajorMapper;
import majordb.com.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hunter on 2021-05-28.
 */
@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    MajorMapper mapper;

    @Override
    public List<Major> list() {
        return mapper.selectAll();
    }

    @Override
    public int add(Major major) {
        return mapper.insert(major);
    }

    @Override
    public int update(Major major) {
        return mapper.updateByPrimaryKey(major);
    }

    @Override
    public int delete(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Major getByid(Integer id) {
        return mapper.getByid(id);
    }
}
