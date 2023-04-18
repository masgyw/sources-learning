package cn.gyw.linkcode;

import cn.gyw.linkcode.tx.TxStarter;

/**
 * @date 2023/4/18
 */
public class LinkCodeMain {

    public static void main(String[] args) throws Exception{

        // 数据库事务测试
        TxStarter.start();
    }
}
