package com.TravisChenn.j2ee.Seconnect.utils;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MybatisUtil {


    /**
     * Mybatis逆向生成方法    [ DAO + DaoImpl + Mapper + Bean ]
     * 
     * 注意：将指定的配置文件放在src目录下的 mybatis-generator.xml 文件
     */
    public void MyBatisGeneratorEntry() {
        List<String> warnings = new ArrayList<String>();
        File configFile = new File("mybatis-generator");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config;

        try {
            config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
