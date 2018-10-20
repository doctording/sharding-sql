# tips

主要学习参考开源项目：

https://github.com/sharding-sphere/sharding-sphere

实践环境

* Java 1.8
* idea，gradle
* mysql

```bash
mubi@mubideMacBook-Pro sql $ mysql --version
mysql  Ver 14.14 Distrib 5.6.40, for macos10.13 (x86_64) using  EditLine wrapper
```

---

存储过程

`InnoDB`插入数据时很慢，先改成`MyISAM`，然后执行完存储过程再改回`InnoDB`

* db_0.t_order_0

```sql
CREATE DEFINER=`root`@`localhost` PROCEDURE `db_0`.`t_order_0_insert`()
BEGIN 
    DECLARE num int DEFAULT 1;   
    WHILE num <= 2500000 do
        insert into db_0.t_order_0(order_id, user_id) 
       		values(num*2, num*2 );  
        set num=num+1;
    END WHILE;
END
```

* db_0.t_order_1

```sql
CREATE DEFINER=`root`@`localhost` PROCEDURE `db_0`.`t_order_1_insert`()
BEGIN 
    DECLARE num int DEFAULT 1;   
    WHILE num <= 2500000 do
        insert into db_0.t_order_1(order_id, user_id) 
       		values(num*2 - 1, num*2 );  
        set num=num+1;
    END WHILE;
END
```

* db_1.t_order_0

```sql
CREATE DEFINER=`root`@`localhost` PROCEDURE `db_1`.`t_order_0_insert`()
BEGIN 
    DECLARE num int DEFAULT 1;   
    WHILE num <= 2500000 do
        insert into db_1.t_order_0(order_id, user_id) 
       		values(num*2, num*2 - 1);  
        set num=num+1;
    END WHILE;
END
```

* db_1.t_order_1

```sql
CREATE DEFINER=`root`@`localhost` PROCEDURE `db_1`.`t_order_1_insert`()
BEGIN 
    DECLARE num int DEFAULT 1;   
    WHILE num <= 2500000 do
        insert into db_1.t_order_1(order_id, user_id) 
       		values(num*2 - 1, num*2 - 1);  
        set num=num+1;
    END WHILE;
END
```

分库分表策略

分表按照`order_id`奇偶

分库按照`user_id`奇偶

```bash
db0
├── t_order_0  order_id为偶数  user_id为偶数
├── t_order_1  order_id为奇数  user_id为偶数
db1
├── t_order_0  order_id为偶数  user_id为奇数
├── t_order_1  order_id为奇数  user_id为奇数
---------------------
```

---

注：sharding-jdbc 更新为：
https://github.com/sharding-sphere/sharding-sphere