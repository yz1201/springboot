package cn.dbdj1201.provider.controller;

import cn.dbdj1201.provider.pojo.SysLog;
import cn.dbdj1201.provider.service.SysLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-03-14 20:30
 **/
@RestController
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @GetMapping("{id}")
    public SysLog querySysLogById(@PathVariable("id") int id) throws JsonProcessingException {
//        System.out.println(new ObjectMapper().writeValueAsString(sysLogService.findAll()));
        return sysLogService.querySysLogById(id);
    }

    @GetMapping("list")
    public List<SysLog> queryForAll() {
        return sysLogService.findAll();
    }
}
