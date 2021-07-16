package majordb.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import majordb.com.entity.College;
import majordb.com.entity.Major;
import majordb.com.service.CollegeService;
import majordb.com.service.MajorService;
import majordb.com.tools.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/major")
@CrossOrigin
public class MajorController {
    @Autowired
    MajorService service;

    @RequestMapping("/list")
    public CommonResult list(){
        List<Major> list = service.list();
        return CommonResult.ok(list);
    }
    @RequestMapping("/page")
    public CommonResult page(@RequestParam(defaultValue = "1") int pageNo,
                             @RequestParam(defaultValue = "5")int  pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<Major> list = service.list();
        PageInfo<Major> pageInfo = new PageInfo<>(list);
        return CommonResult.ok(pageInfo);
    }
    @RequestMapping("/delete")
    public CommonResult delete(Integer id){
        int delete = service.delete(id);
        if (delete>0){
            return CommonResult.ok("删除成功");
        }else {
            return CommonResult.error("删除失败");
        }

    }
    @PostMapping("/add")
    public CommonResult add( @RequestBody  Major major){
        int add = service.add(major);
        if (add>0){
            return CommonResult.ok("添加成功");
        }else {
            return CommonResult.ok("添加失败");
        }

    }
    @RequestMapping("/getByid")
    public CommonResult getByid(Integer id){
        Major major = service.getByid(id);
        return  CommonResult.ok(major);
    }
    @PostMapping("/update")
    public CommonResult update(@RequestBody  Major major){
        int update = service.update(major);
        if (update>0){
            return CommonResult.ok("添加成功");
        }else {
            return CommonResult.error("添加失败");
        }
    }

}
