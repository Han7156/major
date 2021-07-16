package majordb.com.controller;

import majordb.com.tools.CommonResult;
import org.springframework.web.bind.annotation.*;

@RestController

@CrossOrigin
public class LoginController {
    @RequestMapping("/login")
    public CommonResult login(String username,String password){
        if ("admin".equals(username)&&"admin".equals(password)) {
            return CommonResult.ok();
        }else {
            return CommonResult.error("密码或者用户名错误");
        }
    }
}
