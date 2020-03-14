package cn.dbdj1201.consumer.controller;

import cn.dbdj1201.consumer.pojo.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
@RequestMapping("consumer/syslog")
public class SysLogController {

    @Autowired
    private RestTemplate template;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/test")
    public SysLog querySysLogById(@RequestParam int id) {
        List<ServiceInstance> instances = client.getInstances("service-provider");
        ServiceInstance instance = instances.get(0);
        return this.template.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/syslog/" + id, SysLog.class);
    }

    @GetMapping("list")
    public List queryForAll() {
        List<ServiceInstance> instances = client.getInstances("service-provider");
        ServiceInstance instance = instances.get(0);
        return this.template.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/syslog/list", List.class);

    }
}
