package com.zzu.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "person")
public class PersonCopy  {
    @TableId(value="id",type= IdType.AUTO)//不使用，插入时不设置id，会报错；这样设置是根据数据库id自增
    private Integer id;
    private String name;
    private Integer age;
    private Integer hurt;
}
