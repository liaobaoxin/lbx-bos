package com.lbx.utils;

import java.util.List;

/**
 * @Author: lbx
 * @date 2018/3/19 16:19
 */
public class ExpressJson {


    /**
     * com : yuantong
     * ischeck : 1
     * condition : F00
     * data : [{"ftime":"2018-03-13 18:42:27","context":"【广东省梅州市梅县公司】已签收","location":"","time":"2018-03-13 18:42:27"},{"ftime":"2018-03-13 12:58:05","context":"【广东省梅州市梅县公司】派件中","location":"","time":"2018-03-13 12:58:05"},{"ftime":"2018-03-13 09:09:13","context":"【广东省梅州市梅县公司】已收入","location":"","time":"2018-03-13 09:09:13"},{"ftime":"2018-03-12 23:57:51","context":"【揭阳转运中心公司】已发出","location":"","time":"2018-03-12 23:57:51"},{"ftime":"2018-03-12 22:57:17","context":"【揭阳转运中心公司】已收入","location":"","time":"2018-03-12 22:57:17"},{"ftime":"2018-03-11 21:17:36","context":"【杭州转运中心公司】已发出","location":"","time":"2018-03-11 21:17:36"},{"ftime":"2018-03-11 21:15:15","context":"【杭州转运中心公司】已收入","location":"","time":"2018-03-11 21:15:15"},{"ftime":"2018-03-11 18:27:13","context":"【浙江省杭州市萧山区新街分公司公司】已发出","location":"","time":"2018-03-11 18:27:13"},{"ftime":"2018-03-10 21:51:40","context":"【浙江省杭州市萧山区新街分公司公司】已打包","location":"","time":"2018-03-10 21:51:40"},{"ftime":"2018-03-10 21:19:26","context":"【浙江省杭州市萧山区新街分公司公司】已收件","location":"","time":"2018-03-10 21:19:26"},{"ftime":"2018-03-10 20:40:02","context":"【浙江省杭州市萧山区新街分公司公司】已收件","location":"","time":"2018-03-10 20:40:02"}]
     * nu : 888606810744830700
     * state : 3
     * message : ok
     * status : 200
     */
    private String com;
    private String ischeck;
    private String condition;
    private List<DataEntity> data;
    private String nu;
    private String state;
    private String message;
    private String status;

    public void setCom(String com) {
        this.com = com;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCom() {
        return com;
    }

    public String getIscheck() {
        return ischeck;
    }

    public String getCondition() {
        return condition;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public String getNu() {
        return nu;
    }

    public String getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public static  class DataEntity {
        /**
         * ftime : 2018-03-13 18:42:27
         * context : 【广东省梅州市梅县公司】已签收
         * location :
         * time : 2018-03-13 18:42:27
         */
        private String context;
        private String time;


        public void setContext(String context) {
            this.context = context;
        }


        public void setTime(String time) {
            this.time = time;
        }


        public String getContext() {
            return context;
        }


        public String getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "context='" + context + '\'' +
                    ", time='" + time + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "expressJson{" +
                "com='" + com + '\'' +
                ", ischeck='" + ischeck + '\'' +
                ", condition='" + condition + '\'' +
                ", data=" + data +
                ", nu='" + nu + '\'' +
                ", state='" + state + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
