package com.lbx.utils;

import java.util.List;

/**
 * @Author: lbx
 * @date 2018/3/21 8:10
 */
public class AutoComJson {

    /**
     * comCode :
     * num : 483970944762
     * auto : [{"comCode":"zhongtong","id":"","noCount":1548,"noPre":"483970","startTime":""}]
     */

    private String comCode;
    private String num;
    private List<AutoBean> auto;

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public List<AutoBean> getAuto() {
        return auto;
    }

    public void setAuto(List<AutoBean> auto) {
        this.auto = auto;
    }

    public static class AutoBean {
        /**
         * comCode : zhongtong
         * id :
         * noCount : 1548
         * noPre : 483970
         * startTime :
         */

        private String comCode;
        private String id;
        private int noCount;
        private String noPre;
        private String startTime;

        public String getComCode() {
            return comCode;
        }

        public void setComCode(String comCode) {
            this.comCode = comCode;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getNoCount() {
            return noCount;
        }

        public void setNoCount(int noCount) {
            this.noCount = noCount;
        }

        public String getNoPre() {
            return noPre;
        }

        public void setNoPre(String noPre) {
            this.noPre = noPre;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }
    }
}
