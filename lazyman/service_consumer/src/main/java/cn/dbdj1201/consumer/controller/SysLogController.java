package cn.dbdj1201.consumer.controller;

import cn.dbdj1201.consumer.client.SysLogClient;
import cn.dbdj1201.consumer.pojo.SysLog;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-03-14 21:09
 **/
@RestController
@RequestMapping("syslog")
//@DefaultProperties(defaultFallback = "querySysLogByIdFallBack") //定义全局的熔断方法。
public class SysLogController {

//    @Autowired
//    private RestTemplate template;

//    @Autowired
//    private DiscoveryClient client;

    @Autowired
    private SysLogClient sysLogClient;

    @GetMapping
    @HystrixCommand
    public SysLog querySysLogById(@RequestParam("id") int id) {
//        List<ServiceInstance> instances = client.getInstances("service-provider");
//        ServiceInstance instance = instances.get(0);
//        return this.template.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/syslog/" + id, SysLog.class);
//        return this.template.getForObject("http://service-provider/syslog/" + id, String.class);
        return this.sysLogClient.querySysLogById(id);
    }

    @GetMapping("list")
    public List queryForAll() {
//        List<ServiceInstance> instances = client.getInstances("service-provider");
//        ServiceInstance instance = instances.get(0);
//        return this.template.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/syslog/list", List.class);
//        return this.template.getForObject("http://service-provider/syslog/list", List.class);
        return sysLogClient.queryForAll();

    }

//    public String querySysLogByIdFallBack() {
//        return "服务器正忙，请稍后再试。";
//    }
}
