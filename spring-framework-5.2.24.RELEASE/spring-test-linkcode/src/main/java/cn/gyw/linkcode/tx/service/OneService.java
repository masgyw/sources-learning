package cn.gyw.linkcode.tx.service;

import cn.gyw.linkcode.tx.dao.BaseDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @date 2023/4/18
 */
@Service
public class OneService {

    @Resource
    private BaseDao baseDao;

    public void add() {
        baseDao.insertByStatement(1, "test");
    }
}
