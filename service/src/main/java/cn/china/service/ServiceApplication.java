package cn.china.service;

import entity.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.StudentService;

@RestController//就是在service掉用给别人一个入口,不认别人也办法使用这个服务

@EnableEurekaClient //启用Eureka可以客户端,让他注册服务,告诉service层可以向注册中心注册服务,不注册中心汇报,注册中心没有记录,用户访问的时候是回去不到这个服务

@SpringBootApplication //就是不用数据库,就是用自己的就要下面的配置
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan("service")//@ComponentScan 的作用就是根据定义的扫描路径，把符合扫描规则的类装配到spring容器中
@MapperScan("mapper")// 解释:@MapperScan 配置一个或多个包路径(接口)，自动的扫描这些包路径下的类，自动的为它们生成代理类。//@MapperScan 扫描包路径下的类,@Mapper 一般用在接口上
public class ServiceApplication {

    @Autowired
    StudentService ss;

@RequestMapping("/getInfo")//给外面一个访问的入口
public  Student getInfo(){
    return ss.getInfo();
}

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

}
