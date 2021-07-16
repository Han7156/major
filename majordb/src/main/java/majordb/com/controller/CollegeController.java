package majordb.com.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import majordb.com.entity.College;
import majordb.com.service.CollegeService;
import majordb.com.tools.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hunter on 2021-05-28.
 */
@RestController
@RequestMapping("/college")
@CrossOrigin
public class CollegeController {

    @Autowired
    CollegeService service;

    @RequestMapping("/list")
    public CommonResult list(){
        List<College> list = service.list();
        return CommonResult.ok(list);
    }

    @RequestMapping("/page")
    public CommonResult page(@RequestParam(defaultValue = "1") int pageNo,
                             @RequestParam(defaultValue = "5")int  pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<College> list = service.list();
        PageInfo<College> pageInfo = new PageInfo<>(list);
        return CommonResult.ok(pageInfo);
    }
    @GetMapping ("/add")
    public CommonResult add(@RequestBody  College college){
        System.out.println(college);
        int add = service.add(college);
        return CommonResult.ok(add);
    }
}
