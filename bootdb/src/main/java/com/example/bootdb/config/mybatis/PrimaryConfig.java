///**
// * @description:
// * @author: Andy
// * @time: 2021/03/08 16:06
// */
//package com.example.bootdb.config.mybatis;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * Created by fanyuexin on 2021/03/08
// */
//@Configuration
//@MapperScan(
//        basePackages = "com.didispace.chapter39.p",
//        sqlSessionFactoryRef = "sqlSessionFactoryPrimary",
//        sqlSessionTemplateRef = "sqlSessionTemplatePrimary")
//public class PrimaryConfig {
//
//    private DataSource primaryDataSource;
//
//    public PrimaryConfig(@Qualifier("primaryDataSource") DataSource primaryDataSource) {
//        this.primaryDataSource = primaryDataSource;
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryPrimary() throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(primaryDataSource);
//        return bean.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplatePrimary() throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactoryPrimary());
//    }
//
//}
