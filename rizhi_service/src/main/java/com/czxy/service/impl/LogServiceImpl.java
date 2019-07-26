package com.czxy.service.impl;

import com.czxy.dao.LogMapper;
import com.czxy.domain.Log;
import com.czxy.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 添加
     * @param log
     */
    @Override
    public void addLog(Log log) {
        logMapper.insert(log);
    }
}
