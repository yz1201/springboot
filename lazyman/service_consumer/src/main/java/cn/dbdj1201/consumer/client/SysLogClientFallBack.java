package cn.dbdj1201.consumer.client;

import cn.dbdj1201.consumer.pojo.SysLog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-03-15 11:58
 **/
@Component
public class SysLogClientFallBack implements SysLogClient {
    @Override
    public SysLog querySysLogById(int id) {
        SysLog sysLog = new SysLog();
        sysLog.setUsername("????");
        return sysLog;
    }

    @Override
    public List<SysLog> queryForAll() {
        System.out.println("???");
        return new ArrayList<>();
    }
}
