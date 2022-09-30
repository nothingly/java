package com.woniu.controller;

import com.woniu.entity.Result;

public class BaseController {

    /**
     * 返回成功的消息
     * @return
     */
    public Result success(){
        return new Result(true, "操作成功");
    }

    /**
     * 返回失败的消息
     * @return
     */
    public Result error(){
        return new Result(false, "操作失败");
    }

    /**
     * 返回失败的消息
     * @return
     */
    public Result error(String message){
        return new Result(false, message);
    }

    /**
     * 当执行增删改操作的时候，需要根据返回值来判断操作成功还是失败
     *  返回值为int类型
     * @param row
     * @return
     */
    public Result toResult(Integer row){
        return row > 0 ? success() : error();
    }

    /**
     * 当执行增删改操作的时候，需要根据返回值来判断操作成功还是失败
     *  返回值为boolean类型
     * @param flag
     * @return
     */
    public Result toResult(Boolean flag){
        return flag ? success() : error();
    }

    /**
     * 带数据的返回结果
     * @param data
     * @return
     */
    public Result toDataResult(Object data){
        return new Result(true, "查询数据成功", data);
    }

    /**
     *
     * @param data
     * @param message
     * @return
     */
    public Result toDataResult(Object data, String message){
        return new Result(true, message, data);
    }
}
