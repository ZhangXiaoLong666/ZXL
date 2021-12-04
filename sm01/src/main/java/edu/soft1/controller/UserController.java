package edu.soft1.controller;

import edu.soft1.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
    @Controller
    @RequestMapping(value = "/user")

    public class UserController {
        @RequestMapping("/hello")
        public String hello(){
            System.out.println("--hello()--");
            return "hello";
        }
        @RequestMapping(value = "/login")
        public String login(User user, HttpSession session,HttpServletRequest request) {
            System.out.println("----login()----");//进入控制器方法

            int flag = 1;//调用业务层(业务层调用dao层),获取flag的值
            if (flag == 1) {
                System.out.println("username="+user.getUsername());
                session.setAttribute("user", user);//登录对象(名值对的方法)
                return "welcome";//登录成功
            }
            System.out.println("登录失败,返回首页index");
            request.setAttribute("error","账号或密码错误,请重新登录");
            return "forward:/index.jsp";//forward跳转至:/index.jsp
        }

        @RequestMapping("/delete")//被拦截的方法
            public String delete(HttpServletRequest request){
            System.out.println("--delete()--");
            request.setAttribute("CRUDmsg","删除完成！");
            return "hello";
        }

        @RequestMapping("/welcome")
        public String welcome(){
            System.out.println("--welcome()--");
            return "welcome";
        }

        @RequestMapping("/logout")
        public String logout(HttpSession session){
            //清空session
            session.invalidate();
            System.out.println("已登出");
            return "redirect:/index.jsp";
        }
         /* @RequestMapping("reg")
        public String reg(User user){
            System.out.println("username="+user.getUsername());
            System.out.println("pwd="+user.getAge());
            System.out.println("birthday="+user.getBirthday());
            System.out.println("city="+user.getAddress().getCity());
            System.out.println("street="+user.getAddress().getStreet());
            System.out.println("phone="+user.getAddress().getPhone());
            return "hello";
        }*/
    }
