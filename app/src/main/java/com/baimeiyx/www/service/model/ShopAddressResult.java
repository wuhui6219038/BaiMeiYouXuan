package com.baimeiyx.www.service.model;

import java.io.Serializable;
import java.util.List;

public class ShopAddressResult extends BaseResult {

    /**
     * message : null
     * comment : null
     * data : {"MAYI_POS_API_MSID":"9317063a762f4c92b886938c3f13d41c","limit":"2","page":"1","statusA":"","customerId":"13dfa5aed7544866ac99120a1efc7b84","list":[{"id":273,"customerId":"13dfa5aed7544866ac99120a1efc7b84","consignee":"胡涛涛","provinceId":12374,"cityId":12729,"areaId":12730,"streetId":0,"address":"自己人不要发货","mobile":"15281870818","isDefault":"1","addTime":1540797220000,"addUser":"NanShanJi","updateTime":1541211998000,"updateUser":"NanShanJi","isDelete":1},{"id":304,"customerId":"13dfa5aed7544866ac99120a1efc7b84","consignee":"test","provinceId":1,"cityId":2,"areaId":3,"streetId":0,"address":"111","mobile":"13555555555","isDefault":"2","addTime":1541397907000,"addUser":"NanShanJi","updateTime":1541397907000,"updateUser":null,"isDelete":1}]}
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
         * MAYI_POS_API_MSID : 9317063a762f4c92b886938c3f13d41c
         * limit : 2
         * page : 1
         * statusA :
         * customerId : 13dfa5aed7544866ac99120a1efc7b84
         * list : [{"id":273,"customerId":"13dfa5aed7544866ac99120a1efc7b84","consignee":"胡涛涛","provinceId":12374,"cityId":12729,"areaId":12730,"streetId":0,"address":"自己人不要发货","mobile":"15281870818","isDefault":"1","addTime":1540797220000,"addUser":"NanShanJi","updateTime":1541211998000,"updateUser":"NanShanJi","isDelete":1},{"id":304,"customerId":"13dfa5aed7544866ac99120a1efc7b84","consignee":"test","provinceId":1,"cityId":2,"areaId":3,"streetId":0,"address":"111","mobile":"13555555555","isDefault":"2","addTime":1541397907000,"addUser":"NanShanJi","updateTime":1541397907000,"updateUser":null,"isDelete":1}]
         */

        private String MAYI_POS_API_MSID;
        private String limit;
        private String page;
        private String statusA;
        private String customerId;
        private List<ListBean> list;

        public String getMAYI_POS_API_MSID() {
            return MAYI_POS_API_MSID;
        }

        public void setMAYI_POS_API_MSID(String MAYI_POS_API_MSID) {
            this.MAYI_POS_API_MSID = MAYI_POS_API_MSID;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getStatusA() {
            return statusA;
        }

        public void setStatusA(String statusA) {
            this.statusA = statusA;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * id : 273
             * customerId : 13dfa5aed7544866ac99120a1efc7b84
             * consignee : 胡涛涛
             * provinceId : 12374
             * cityId : 12729
             * areaId : 12730
             * streetId : 0
             * address : 自己人不要发货
             * mobile : 15281870818
             * isDefault : 1
             * addTime : 1540797220000
             * addUser : NanShanJi
             * updateTime : 1541211998000
             * updateUser : NanShanJi
             * isDelete : 1
             */

            private int id;
            private String customerId;
            private String consignee;
            private int provinceId;
            private int cityId;
            private int areaId;
            private int streetId;
            private String address;
            private String mobile;
            private String isDefault;
            private long addTime;
            private String addUser;
            private long updateTime;
            private String updateUser;
            private int isDelete;

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

            public String getConsignee() {
                return consignee;
            }

            public void setConsignee(String consignee) {
                this.consignee = consignee;
            }

            public int getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(int provinceId) {
                this.provinceId = provinceId;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public int getAreaId() {
                return areaId;
            }

            public void setAreaId(int areaId) {
                this.areaId = areaId;
            }

            public int getStreetId() {
                return streetId;
            }

            public void setStreetId(int streetId) {
                this.streetId = streetId;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(String isDefault) {
                this.isDefault = isDefault;
            }

            public long getAddTime() {
                return addTime;
            }

            public void setAddTime(long addTime) {
                this.addTime = addTime;
            }

            public String getAddUser() {
                return addUser;
            }

            public void setAddUser(String addUser) {
                this.addUser = addUser;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }
        }
    }
}
