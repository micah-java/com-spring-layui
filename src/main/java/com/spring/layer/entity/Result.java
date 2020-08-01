package com.spring.layer.entity;

import java.io.Serializable;

/**
 * layui有自己的一套特定的数据格式交互（这很重要）
 * 必须参数code：0，msg：""，count：数据size（int）,data: 数据List
 */
public class Result<T> implements Serializable {

     private Integer code;
     private String msg;
     private Integer count;
     private T data;

    public Result() {
    }

    public static Result ok(){
        return new Result(0,0,null);
    }

    public Result(Integer code, Integer count, T data) {
        this.code = code;
        this.count = count;
        this.data = data;
    }

    public Result(Integer code, String msg, Integer count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
