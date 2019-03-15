package com.baimeiyx.www.service.model;

import java.util.List;

public class CustomWeightLogResult extends BaseResult {


    /**
     * message : null
     * comment : null
     * data : {"MAYI_POS_API_MSID":"cefe657466cb4ecd98c374a40a0447ae","page":"1","limit":"1","list":[{"id":65,"customerId":"13dfa5aed7544866ac99120a1efc7b84","customerW":47.1,"fat":0,"water":0,"bones":0,"calorie":0,"createTime":1540973630000,"param":""}]}
     * page : null
     */


    private DataBean data;



    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * MAYI_POS_API_MSID : cefe657466cb4ecd98c374a40a0447ae
         * page : 1
         * limit : 1
         * list : [{"id":65,"customerId":"13dfa5aed7544866ac99120a1efc7b84","customerW":47.1,"fat":0,"water":0,"bones":0,"calorie":0,"createTime":1540973630000,"param":""}]
         */

        private String MAYI_POS_API_MSID;
        private String page;
        private String limit;
        private List<ListBean> list;

        public String getMAYI_POS_API_MSID() {
            return MAYI_POS_API_MSID;
        }

        public void setMAYI_POS_API_MSID(String MAYI_POS_API_MSID) {
            this.MAYI_POS_API_MSID = MAYI_POS_API_MSID;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 65
             * customerId : 13dfa5aed7544866ac99120a1efc7b84
             * customerW : 47.1
             * fat : 0
             * water : 0
             * bones : 0
             * calorie : 0
             * createTime : 1540973630000
             * param :
             */

            private int id;
            private String customerId;
            private double customerW;
            private int fat;
            private int water;
            private int bones;
            private int calorie;
            private long createTime;
            private String param;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public double getCustomerW() {
                return customerW;
            }

            public void setCustomerW(double customerW) {
                this.customerW = customerW;
            }

            public int getFat() {
                return fat;
            }

            public void setFat(int fat) {
                this.fat = fat;
            }

            public int getWater() {
                return water;
            }

            public void setWater(int water) {
                this.water = water;
            }

            public int getBones() {
                return bones;
            }

            public void setBones(int bones) {
                this.bones = bones;
            }

            public int getCalorie() {
                return calorie;
            }

            public void setCalorie(int calorie) {
                this.calorie = calorie;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getParam() {
                return param;
            }

            public void setParam(String param) {
                this.param = param;
            }
        }
    }
}
