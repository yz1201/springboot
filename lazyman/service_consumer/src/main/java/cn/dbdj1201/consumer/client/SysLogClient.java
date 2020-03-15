package cn.dbdj1201.consumer.client;

import cn.dbdj1201.consumer.pojo.SysLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-03-15 11:23
 **/
@FeignClient(value = "service-provider", fallback = SysLogClientFallBack.class)
public interface SysLogClient {

    @GetMapping("syslog/{id}")
    SysLog querySysLogById(@PathVariable("id") int id);


    @GetMapping("syslog/list")
    List<SysLog> queryForAll();
}
