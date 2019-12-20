package service;

import entity.Student;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class StudentService {

   @Autowired
   StudentMapper sm;



//  这个是需要实现 studentMapper
    public Student getInfo() {
       // return sm.getInfo();//就孩不用数据库没什么意义
        return  new Student("张三",20,"男");

    }

//返回数据就是要指定返回的路径,返回数数据的格式,不然页面就是结束不了
    @RequestMapping(value="/insert",produces = "application/json;charset=UTF-8")//做好事在这个类面写路径,不要在启动类里面写
    public  int  insert(Student student){
    student = new Student("意义",21,"nan");//这个一般是页面给他的,有页面就是要new
     return sm.insert(student);
 }


}
