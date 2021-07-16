package majordb.com.mapper;


import majordb.com.entity.Major;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface MajorMapper extends Mapper<Major> {
 Major getByid(@Param("id") Integer id);
}