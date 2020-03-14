package cn.dbdj1201.lazyman.service.impl;

import cn.dbdj1201.lazyman.mapper.ISysLogMapper;
import cn.dbdj1201.lazyman.pojo.SysLog;
import cn.dbdj1201.lazyman.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-03-14 10:43
 **/
@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogMapper sysLogMapper;

    @Override
    public List<SysLog> findAll() {
        return this.sysLogMapper.selectAll();
    }

    @Override
    public void save(SysLog sysLog) {
        System.out.println("i need save ?");
        this.sysLogMapper.insert(sysLog);
    }

    @Override
    public SysLog findSysLogById(int id) {
        return this.sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void deleteSysLogById(int id) {
        this.sysLogMapper.deleteByPrimaryKey(id);
    }
}
