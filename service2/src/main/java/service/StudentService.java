package service;

import entity.Student;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//使用mapping就是要配置这个,不然就是找不到
@Service
public class StudentService  {//复制过来就报错

  @Autowired
    StudentMapper sm;

    public Student getInfo() {
       // return sm.getInfo();//就孩不用数据库没什么意义
        return  new Student("张三2",20,"男");//正常应该是一样的或者就是打印当前的端口号

    }

    //返回数据就是要指定返回的路径,返回数数据的格式,不然页面就是结束不了
    @RequestMapping(value="/insert",produces = "application/json;charset=UTF-8")//做好事在这个类面写路径,不要在启动类里面写
    public  int  insert(Student student){
        student = new Student("意义2",21,"nan");//这个一般是页面给他的,么有页面就是要自己new
        return sm.insert(student);
    }



}
