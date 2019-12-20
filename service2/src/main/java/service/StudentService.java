package service;

import entity.Student;
import mapper.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentMapper {//复制过来就报错

  /*  @Autowired
    StudentMapper sm;*/

    @Override
    public Student getInfo() {
       // return sm.getInfo();//就孩不用数据库没什么意义
        return  new Student("张三2",20,"男");//正常应该是一样的或者就是打印当前的端口号

    }
}
