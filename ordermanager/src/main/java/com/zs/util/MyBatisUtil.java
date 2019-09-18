package com.zs.util;

import com.zs.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
    private static final SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
            MyBatisUtil.class.getClassLoader().getResourceAsStream("mybatis.xml")
    );
    public static SqlSession getSqlSession(){
        return factory.openSession(true);/*true 设置自动提交！！！！！！！！！*/
    }
}
