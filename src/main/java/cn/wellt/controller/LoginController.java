package cn.wellt.controller;

import cn.wellt.common.domain.rest.FailureResult;
import cn.wellt.common.domain.rest.Result;
import cn.wellt.common.domain.rest.SuccessResult;
import cn.wellt.system.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by caojingchen on 2018/4/19.
 */
@RestController
@Api(tags = "用户登录")
public class LoginController {
    /**
     * 登录操作
     * @return
     */
    @PostMapping(value = "login")
    @ApiOperation("通过用户名和密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "string", paramType = "query")
    })
    public Result doLogin(String username,String password,HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            User user =(User) subject.getPrincipal();
            session.setAttribute("username",user.getUsername());
            return new SuccessResult("登录成功");
        }catch (UnknownAccountException ex1){
            System.out.println("账号不存在");
            return new FailureResult("账号不存在");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return new FailureResult("密码错误");
        } catch (LockedAccountException e) {
            System.out.println("登录失败，该用户已被冻结");
            return new FailureResult("登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            System.out.println("该用户不存在");
            return new FailureResult("该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
            return new FailureResult("未知错误");
        }
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping(value = "logout")
    @ApiOperation("退出登录")
    public Result logout(HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        session.removeAttribute("username");
        subject.logout();
        return new SuccessResult("退出成功");
    }
}
