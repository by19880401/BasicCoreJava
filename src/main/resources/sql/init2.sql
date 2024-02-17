/*创建main表*/
CREATE TABLE basic_core_java_account
(
    id           INT         NOT NULL,
    user_id      varchar(32) NOT NULL,
    country      varchar(32),
    access       varchar(32),
    address      varchar(32),
    signature    varchar(32),
    unread_count INT,
    avatar       varchar(500),
    title        varchar(32),
    tag_id       varchar(50),
    notify_count INT,
    phone        varchar(32),
    name         varchar(32),
    email        varchar(20),
    department   varchar(200),
    PRIMARY KEY (id)
);

/*生成一条数据*/
INSERT INTO basic_core_java_account
VALUES (1, '00000001', 'China', 'admin', '西湖区工专路 77 号', '海纳百川，有容乃大', 2,
        'https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png',
        '交互专家', '3c496a9cac5986b5e9dc876f4f0401ff', 12, '0752-268888888', 'Serati Ma', 'antdesign@alipay.com',
        '蚂蚁金服－某某某事业群－某某平台部－某某技术部－UED');

/*创建main表*/
CREATE TABLE tags_item
(
    id      INT NOT NULL,
    label   varchar(200),
    ftag_id varchar(32),
    PRIMARY KEY (id)
);


insert
into tags_item
values (0, '很有想法的',
        '3c496a9cac5986b5e9dc876f4f0401ff'),
       (1, '很有想法的',
        '3c496a9cac5986b5e9dc876f4f0401ff'),
       (2, '很有想法的',
        '3c496a9cac5986b5e9dc876f4f0401ff'),
       (3, '很有想法的',
        '3c496a9cac5986b5e9dc876f4f0401ff'),
       (4, '很有想法的',
        '3c496a9cac5986b5e9dc876f4f0401ff'),
       (5, '很有想法的',
        '3c496a9cac5986b5e9dc876f4f0401ff');