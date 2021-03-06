package com.germaine.lumbarRobot.controller;

import com.germaine.lumbarRobot.entity.JsonResult;
import com.germaine.lumbarRobot.entity.User;
import com.germaine.lumbarRobot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gateway/user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    /**
     * 用户登入
     * @param
     * @return
     */
    @RequestMapping(value = "userLogin", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> userLogin (@RequestParam("mobile") String mobile){
        JsonResult r = new JsonResult();
        try {
            User user = userService.getUserByMobile(mobile);
            r.setResult(user);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 用户登出
     * @param
     * @return
     */
    @RequestMapping(value = "userLogout", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> userLogout (@RequestParam("mobile") String mobile){
        JsonResult r = new JsonResult();
        try {
            r.setResult("logout success");
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "getUsers", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserList (){
        JsonResult r = new JsonResult();
        try {
            List<User> users = userService.getUserList();
            r.setResult(users);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            int orderId = userService.add(user);
            if (orderId < 0) {
                r.setResult(orderId);
                r.setStatus("fail");
            } else {
                r.setResult(orderId);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id删除用户
     * @param mobile
     * @return
     */
    @RequestMapping(value = "user/{mobile}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "mobile") String mobile){
        JsonResult r = new JsonResult();
        try {
            int ret = userService.delete(mobile);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "user/{mobile}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("mobile") String mobile, @RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            int ret = userService.update(mobile, user);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

}
