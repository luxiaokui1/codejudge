# 鏁版嵁搴撳垵濮嬪寲
# CodeJudge database schema`r`n
-- 鍒涘缓搴?
create database if not exists codejudge;

-- 鍒囨崲搴?
use codejudge;

-- 鐢ㄦ埛琛?
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                           not null comment '璐﹀彿',
    userPassword varchar(512)                           not null comment '瀵嗙爜',
    unionId      varchar(256)                           null comment '寰俊寮€鏀惧钩鍙癷d',
    mpOpenId     varchar(256)                           null comment '鍏紬鍙穙penId',
    userName     varchar(256)                           null comment '鐢ㄦ埛鏄电О',
    userAvatar   varchar(1024)                          null comment '鐢ㄦ埛澶村儚',
    userProfile  varchar(512)                           null comment '鐢ㄦ埛绠€浠?,
    userRole     varchar(256) default 'user'            not null comment '鐢ㄦ埛瑙掕壊锛歶ser/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '鍒涘缓鏃堕棿',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '鏇存柊鏃堕棿',
    isDelete     tinyint      default 0                 not null comment '鏄惁鍒犻櫎',
    index idx_unionId (unionId)
) comment '鐢ㄦ埛' collate = utf8mb4_unicode_ci;

-- 棰樼洰琛?
create table if not exists question
(
    id          bigint auto_increment comment 'id' primary key,
    title       varchar(512)                       null comment '鏍囬',
    content     text                               null comment '鍐呭',
    tags        varchar(1024)                      null comment '鏍囩鍒楄〃锛坖son 鏁扮粍锛?,
    answer      text                               null comment '棰樼洰绛旀',
    submitNum   int      default 0                 not null comment '棰樼洰鎻愪氦鏁?,
    acceptedNum int      default 0                 not null comment '棰樼洰閫氳繃鏁?,
    judgeCase   text                               null comment '鍒ら鐢ㄤ緥锛坖son 鏁扮粍锛?,
    judgeConfig text                               null comment '鍒ら閰嶇疆锛坖son 瀵硅薄锛?,
    thumbNum    int      default 0                 not null comment '鐐硅禐鏁?,
    favourNum   int      default 0                 not null comment '鏀惰棌鏁?,
    userId      bigint                             not null comment '鍒涘缓鐢ㄦ埛 id',
    createTime  datetime default CURRENT_TIMESTAMP not null comment '鍒涘缓鏃堕棿',
    updateTime  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '鏇存柊鏃堕棿',
    isDelete    tinyint  default 0                 not null comment '鏄惁鍒犻櫎',
    index idx_userId (userId)
) comment '棰樼洰' collate = utf8mb4_unicode_ci;

-- 棰樼洰鎻愪氦琛?
create table if not exists question_submit
(
    id         bigint auto_increment comment 'id' primary key,
    language   varchar(128)                       not null comment '缂栫▼璇█',
    code       text                               not null comment '鐢ㄦ埛浠ｇ爜',
    judgeInfo  text                               null comment '鍒ら淇℃伅锛坖son 瀵硅薄锛?,
    status     int      default 0                 not null comment '鍒ら鐘舵€侊紙0 - 寰呭垽棰樸€? - 鍒ら涓€? - 鎴愬姛銆? - 澶辫触锛?,
    questionId bigint                             not null comment '棰樼洰 id',
    userId     bigint                             not null comment '鍒涘缓鐢ㄦ埛 id',
    createTime datetime default CURRENT_TIMESTAMP not null comment '鍒涘缓鏃堕棿',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '鏇存柊鏃堕棿',
    isDelete   tinyint  default 0                 not null comment '鏄惁鍒犻櫎',
    index idx_questionId (questionId),
    index idx_userId (userId)
) comment '棰樼洰鎻愪氦';

-- 甯栧瓙琛?
create table if not exists post
(
    id         bigint auto_increment comment 'id' primary key,
    title      varchar(512)                       null comment '鏍囬',
    content    text                               null comment '鍐呭',
    tags       varchar(1024)                      null comment '鏍囩鍒楄〃锛坖son 鏁扮粍锛?,
    thumbNum   int      default 0                 not null comment '鐐硅禐鏁?,
    favourNum  int      default 0                 not null comment '鏀惰棌鏁?,
    userId     bigint                             not null comment '鍒涘缓鐢ㄦ埛 id',
    createTime datetime default CURRENT_TIMESTAMP not null comment '鍒涘缓鏃堕棿',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '鏇存柊鏃堕棿',
    isDelete   tinyint  default 0                 not null comment '鏄惁鍒犻櫎',
    index idx_userId (userId)
) comment '甯栧瓙' collate = utf8mb4_unicode_ci;

-- 甯栧瓙鐐硅禐琛紙纭垹闄わ級
create table if not exists post_thumb
(
    id         bigint auto_increment comment 'id' primary key,
    postId     bigint                             not null comment '甯栧瓙 id',
    userId     bigint                             not null comment '鍒涘缓鐢ㄦ埛 id',
    createTime datetime default CURRENT_TIMESTAMP not null comment '鍒涘缓鏃堕棿',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '鏇存柊鏃堕棿',
    index idx_postId (postId),
    index idx_userId (userId)
) comment '甯栧瓙鐐硅禐';

-- 甯栧瓙鏀惰棌琛紙纭垹闄わ級
create table if not exists post_favour
(
    id         bigint auto_increment comment 'id' primary key,
    postId     bigint                             not null comment '甯栧瓙 id',
    userId     bigint                             not null comment '鍒涘缓鐢ㄦ埛 id',
    createTime datetime default CURRENT_TIMESTAMP not null comment '鍒涘缓鏃堕棿',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '鏇存柊鏃堕棿',
    index idx_postId (postId),
    index idx_userId (userId)
) comment '甯栧瓙鏀惰棌';

