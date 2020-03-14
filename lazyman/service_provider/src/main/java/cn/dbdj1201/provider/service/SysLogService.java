package cn.dbdj1201.provider.service;

import cn.dbdj1201.provider.mapper.ISysLogMapper;
import cn.dbdj1201.provider.pojo.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-03-14 20:25
 **/
@Service
public class SysLogService {

    @Autowired
    private ISysLogMapper sysLogMapper;

    public List<SysLog> findAll() {
        return sysLogMapper.selectAll();
    }

    public SysLog querySysLogById(int id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

}
