/*创建主表**/
CREATE TABLE bfs_nota
(
    id               INT          NOT NULL,
    f_notaunikey     char(32)     NOT NULL,
    f_head           char(12)     NOT NULL,
    f_msgtype        varchar(100) NOT NULL,
    f_drivercode     char(9)      NOT NULL,
    f_qr_cdrivercode varchar(9)   NOT NULL,
    f_qr_fdatetime   timestamp    NOT NULL,
    f_qr_randomnum   char(5)      NOT NULL,
    PRIMARY KEY (id)
);

/*生成一条数据*/
INSERT INTO bfs_nota
VALUES (1, '3c496a9cac5986b5e9dc876f4f0401ff', 'GDAP20200527', '1001', 'M02000930', 'M02000429', '2020-05-27 09:28:39',
        '20022');

/*创建子表*/
CREATE TABLE bfs_nota_detail
(
    id             INT         NOT NULL,
    f_notaunikey   char(32)    NOT NULL,
    f_detailunikey char(32)    NOT NULL,
    f_moneyslogan  char(2)     NOT NULL,
    f_keynum       char(5)     NOT NULL,
    f_backcode     char(5)     NOT NULL,
    f_detailbacksx char(9)     NOT NULL,
    f_drvercode    char(9)     NOT NULL,
    f_btime        timestamp   NOT NULL,
    f_coupons      char(3)     NOT NULL,
    f_couponcount  INT         NOT NULL,
    f_couponvalue  INT         NOT NULL,
    f_revision     varchar(10) NOT NULL,
    PRIMARY KEY (id)
);

/*插入detail数据*/
insert
into bfs_nota_detail
values (1,
        '3c496a9cac5986b5e9dc876f4f0401ff',
        'e5d73440e633b7783eb3fb957ae60e3',
        '02',
        '00019',
        '51000',
        '771600110',
        'M02000429',
        '2020-05-27 09:27:49',
        '100',
        100,
        10000,
        '2015FIT   '),
       (2,
        '3c496a9cac5986b5e9dc876f4f0401ff',
        'ad2a34af3038a87f263b8f9ea771e4f1',
        '02',
        '00016',
        '51000',
        '771600110',
        'M02000429',
        '2020-05-27 09:27:51',
        '100',
        100,
        10000,
        '2015FIT   '),
       (3,
        '3c496a9cac5986b5e9dc876f4f0401ff',
        '75a42347de99ece9d706dbb7c804ca0d',
        '02',
        '00018',
        '51000',
        '771600110',
        'M02000429',
        '2020-05-27 09:27:54',
        '100',
        100,
        10000,
        '2015FIT   '),
       (4,
        '3c496a9cac5986b5e9dc876f4f0401ff',
        '92e78b01edb6e03f3746c284e80ebc73',
        '02',
        '00014',
        '51000',
        '771600110',
        'M02000429',
        '2020-05-27 09:27:56',
        '100',
        100,
        10000,
        '2015FIT   '),
       (5,
        '3c496a9cac5986b5e9dc876f4f0401ff',
        'b95e2e493947c5f522546b6fa4d3ba3d',
        '01',
        '00022',
        '51000',
        '771600110',
        'M02000429',
        '2020-05-27 09:27:59',
        '100',
        100,
        10000,
        '2015FIT   '),
       (6,
        '3c496a9cac5986b5e9dc876f4f0401ff',
        'a5efae152a9da726807e5c9a743c1b6d',
        '01',
        '00025',
        '51000',
        '771600110',
        'M02000429',
        '2020-05-27 09:28:01',
        '100',
        100,
        10000,
        '2015FIT   '),
       (7,
        '3c496a9cac5986b5e9dc876f4f0401ff',
        '68cb897a34180f92a606aa5a73f20a0b',
        '02',
        '00015',
        '51000',
        '771600110',
        'M02000429',
        '2020-05-27 09:28:04',
        '100',
        100,
        10000,
        '2015FIT   '),
       (8,
        '3c496a9cac5986b5e9dc876f4f0401ff',
        '24ffd138d550e59243b1c65504c24d6a',
        '01',
        '00017',
        '51000',
        '771600110',
        'M02000429',
        '2020-05-27 09:28:06',
        '100',
        100,
        10000,
        '2015FIT   '),
       (9,
        '3c496a9cac5986b5e9dc876f4f0401ff',
        'ff9b18003d7f730a77deabeba6fd453d',
        '02',
        '00012',
        '51000',
        '771600110',
        'M02000429',
        '2020-05-27 09:28:09',
        '100',
        100,
        10000,
        '2015FIT   '),
       (10,
        '3c496a9cac5986b5e9dc876f4f0401ff',
        'c9ab32450ec9154b84b3ad98918030e2',
        '01',
        '00024',
        '51000',
        '771600110',
        'M02000429',
        '2020-05-27 09:28:12',
        '100',
        100,
        10000,
        '2015FIT   ');
