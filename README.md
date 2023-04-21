# 实习后端作业（2023.4）

## 接口文档

- swagger接口文档
    - http://localhost:8080/swagger-ui/index.html
    - http://localhost:8080/doc.html

## 数据库表结构

```sql
-- course.student_info definition

CREATE TABLE `student_info`
(
    `id`                 bigint(20) NOT NULL AUTO_INCREMENT,
    `stu_id`             varchar(7)  NOT NULL COMMENT '学号',
    `stu_name`           varchar(20) NOT NULL COMMENT '姓名',
    `stu_sex`            varchar(1)  NOT NULL DEFAULT '男' COMMENT '性别',
    `stu_birthday`       datetime    NOT NULL COMMENT '出生日期',
    `stu_eng_grade`      varchar(4)           DEFAULT NULL COMMENT '英语等级',
    `stu_class_id`       varchar(10)          DEFAULT NULL COMMENT '班级代码',
    `stu_height`         decimal(4, 1)        DEFAULT NULL COMMENT '身高',
    `stu_intro`          varchar(1000)        DEFAULT NULL COMMENT '自我介绍',
    `stu_phone`          varchar(11)          DEFAULT NULL COMMENT '手机号码',
    `stu_address`        varchar(100)         DEFAULT NULL COMMENT '联系地址',
    `stu_admission_date` datetime    NOT NULL COMMENT '入学日期',
    `stu_piny`           varchar(20)          DEFAULT NULL COMMENT '拼音',
    PRIMARY KEY (`id`),
    UNIQUE KEY `student_info_UN` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- course.class_info definition

CREATE TABLE `class_info`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT,
    `class_id`   varchar(20) DEFAULT NULL COMMENT '班级代码',
    `class_name` varchar(20) DEFAULT NULL COMMENT '班级名称',
    PRIMARY KEY (`id`),
    UNIQUE KEY `class_info_UN` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;


-- course.course_info definition

CREATE TABLE `course_info`
(
    `id`                bigint(20) NOT NULL AUTO_INCREMENT,
    `course_id`         varchar(10) NOT NULL COMMENT '课程ID',
    `course_name`       varchar(50) NOT NULL COMMENT '课程名',
    `course_limit`      int(10) unsigned NOT NULL DEFAULT '0' COMMENT '课程报选人数上线',
    `course_week_day`   int(10) unsigned NOT NULL COMMENT '上课时间（星期）',
    `course_start_time` time        NOT NULL COMMENT '上课时间（开始时刻）',
    `course_end_time`   time        NOT NULL COMMENT '上课时间（结束时刻）',
    PRIMARY KEY (`id`),
    UNIQUE KEY `course_info_UN` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COMMENT='选修课程信息表';

-- course.student_course_info definition

CREATE TABLE `student_course_info`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `stu_id`    varchar(7)  NOT NULL,
    `course_id` varchar(10) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `student_course_info_UN` (`stu_id`,`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='学生选课结果表';
```

## 项目结构

- course-system
    - CourseSystemApplication 项目启动类入口
    - resources: 项目配置文件
- common-module: 公共功能模块
    - config: 缓存，MyBatisPlus，Swagger配置
    - enums: 通用枚举类
    - logging: 基于AOP切面的日志管理
    - response: 通用的API返回接口封装，状态码
    - mq: 消息队列服务
    - utils: 通用工具类
- student-module: 学生、班级信息管理功能模块
- course-select-module: 选课功能模块

