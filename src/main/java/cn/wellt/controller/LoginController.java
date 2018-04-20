package cn.wellt.controller;

import cn.wellt.system.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by caojingchen on 2018/4/19.
 */
@Controller
public class LoginController {
    /**
     * 登录界面
     * @return
     */
    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }

    /**
     * 登录操作
     * @return
     */
    @RequestMapping(value = "doLogin")
    public String doLogin(String username,String password,HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            User userInfo =(User) subject.getPrincipal();
            session.setAttribute("username",userInfo.getUsername());
            return "index";
        }catch (UnknownAccountException ex1){
            System.out.println("账号不存在");
            return "403";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return "403";
        } catch (LockedAccountException e) {
            System.out.println("登录失败，该用户已被冻结");
            return "403";
        } catch (AuthenticationException e) {
            System.out.println("该用户不存在");
            return "403";
        } catch (Exception e) {
            e.printStackTrace();
            return "403";
        }
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value = "logout")
    @ResponseBody
    public String logout(HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        session.removeAttribute("username");
        subject.logout();
        return "login";
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "index")
    public String index(){
        return "main";
    }

}
