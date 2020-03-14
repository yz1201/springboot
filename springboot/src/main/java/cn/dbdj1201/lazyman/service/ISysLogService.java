package cn.dbdj1201.lazyman.service;

import cn.dbdj1201.lazyman.pojo.SysLog;

import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-03-14 10:42
 **/
public interface ISysLogService {

    /**
     * @return
     */
    List<SysLog> findAll();

    /**
     * @param sysLog
     */
    void save(SysLog sysLog);

    SysLog findSysLogById(int id);

    void deleteSysLogById(int id);
}
