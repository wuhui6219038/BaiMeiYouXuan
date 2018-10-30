package com.baimeiyx.www.module.http.result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RevenceDetailResult extends BaseResult {

    /**
     * stateCode : 100
     * message : null
     * comment : null
     * data : {"data":{"1":"充值","2":"消费","3":"返利","4":"退款金币"},"list":{"limit":"1","startTime":"2018-9-30 00:00:00","endTime":"2018-10-31 23:59:59","page":"1","behaviorType":"","MAYI_POS_API_MSID":"1c719057a24741ccad10c39719de13d8","customerId":"cfcb5acc04a04f9185b5846d80af7b9a","list":[{"id":4742,"customerId":"cfcb5acc04a04f9185b5846d80af7b9a","behaviorType":4,"oaOrderId":null,"typeId":null,"beforeMoney":0,"afterMoney":0,"changeValue":6,"txType":1,"remark":"退款","status":1,"addTime":1540541015000,"subCustomerId":null,"disType":2,"orderItemId":1855,"distribution":null,"customerName":"NanShanJi"}]}}
     * page : null
     * ok : true
     */

    private DataBeanX data;
    private Object page;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }



    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }


    public static class DataBeanX {
        /**
         * data : {"1":"充值","2":"消费","3":"返利","4":"退款金币"}
         * list : {"limit":"1","startTime":"2018-9-30 00:00:00","endTime":"2018-10-31 23:59:59","page":"1","behaviorType":"","MAYI_POS_API_MSID":"1c719057a24741ccad10c39719de13d8","customerId":"cfcb5acc04a04f9185b5846d80af7b9a","list":[{"id":4742,"customerId":"cfcb5acc04a04f9185b5846d80af7b9a","behaviorType":4,"oaOrderId":null,"typeId":null,"beforeMoney":0,"afterMoney":0,"changeValue":6,"txType":1,"remark":"退款","status":1,"addTime":1540541015000,"subCustomerId":null,"disType":2,"orderItemId":1855,"distribution":null,"customerName":"NanShanJi"}]}
         */

        private DataBean data;
        private ListBeanX list;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public ListBeanX getList() {
            return list;
        }

        public void setList(ListBeanX list) {
            this.list = list;
        }

        public static class DataBean {
            /**
             * 1 : 充值
             * 2 : 消费
             * 3 : 返利
             * 4 : 退款金币
             */

            @SerializedName("1")
            private String _$1;
            @SerializedName("2")
            private String _$2;
            @SerializedName("3")
            private String _$3;
            @SerializedName("4")
            private String _$4;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }

            public String get_$2() {
                return _$2;
            }

            public void set_$2(String _$2) {
                this._$2 = _$2;
            }

            public String get_$3() {
                return _$3;
            }

            public void set_$3(String _$3) {
                this._$3 = _$3;
            }

            public String get_$4() {
                return _$4;
            }

            public void set_$4(String _$4) {
                this._$4 = _$4;
            }
        }

        public static class ListBeanX {
            /**
             * limit : 1
             * startTime : 2018-9-30 00:00:00
             * endTime : 2018-10-31 23:59:59
             * page : 1
             * behaviorType :
             * MAYI_POS_API_MSID : 1c719057a24741ccad10c39719de13d8
             * customerId : cfcb5acc04a04f9185b5846d80af7b9a
             * list : [{"id":4742,"customerId":"cfcb5acc04a04f9185b5846d80af7b9a","behaviorType":4,"oaOrderId":null,"typeId":null,"beforeMoney":0,"afterMoney":0,"changeValue":6,"txType":1,"remark":"退款","status":1,"addTime":1540541015000,"subCustomerId":null,"disType":2,"orderItemId":1855,"distribution":null,"customerName":"NanShanJi"}]
             */

            private String limit;
            private String startTime;
            private String endTime;
            private String page;
            private String behaviorType;
            private String MAYI_POS_API_MSID;
            private String customerId;
            private List<ListBean> list;

            public String getLimit() {
                return limit;
            }

            public void setLimit(String limit) {
                this.limit = limit;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getPage() {
                return page;
            }

            public void setPage(String page) {
                this.page = page;
            }

            public String getBehaviorType() {
                return behaviorType;
            }

            public void setBehaviorType(String behaviorType) {
                this.behaviorType = behaviorType;
            }

            public String getMAYI_POS_API_MSID() {
                return MAYI_POS_API_MSID;
            }

            public void setMAYI_POS_API_MSID(String MAYI_POS_API_MSID) {
                this.MAYI_POS_API_MSID = MAYI_POS_API_MSID;
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

            public static class ListBean {
                /**
                 * id : 4742
                 * customerId : cfcb5acc04a04f9185b5846d80af7b9a
                 * behaviorType : 4
                 * oaOrderId : null
                 * typeId : null
                 * beforeMoney : 0
                 * afterMoney : 0
                 * changeValue : 6
                 * txType : 1
                 * remark : 退款
                 * status : 1
                 * addTime : 1540541015000
                 * subCustomerId : null
                 * disType : 2
                 * orderItemId : 1855
                 * distribution : null
                 * customerName : NanShanJi
                 */

                private int id;
                private String customerId;
                private int behaviorType;
                private Object oaOrderId;
                private Object typeId;
                private int beforeMoney;
                private int afterMoney;
                private int changeValue;
                private int txType;
                private String remark;
                private int status;
                private long addTime;
                private Object subCustomerId;
                private int disType;
                private int orderItemId;
                private Object distribution;
                private String customerName;

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

                public int getBehaviorType() {
                    return behaviorType;
                }

                public void setBehaviorType(int behaviorType) {
                    this.behaviorType = behaviorType;
                }

                public Object getOaOrderId() {
                    return oaOrderId;
                }

                public void setOaOrderId(Object oaOrderId) {
                    this.oaOrderId = oaOrderId;
                }

                public Object getTypeId() {
                    return typeId;
                }

                public void setTypeId(Object typeId) {
                    this.typeId = typeId;
                }

                public int getBeforeMoney() {
                    return beforeMoney;
                }

                public void setBeforeMoney(int beforeMoney) {
                    this.beforeMoney = beforeMoney;
                }

                public int getAfterMoney() {
                    return afterMoney;
                }

                public void setAfterMoney(int afterMoney) {
                    this.afterMoney = afterMoney;
                }

                public int getChangeValue() {
                    return changeValue;
                }

                public void setChangeValue(int changeValue) {
                    this.changeValue = changeValue;
                }

                public int getTxType() {
                    return txType;
                }

                public void setTxType(int txType) {
                    this.txType = txType;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public long getAddTime() {
                    return addTime;
                }

                public void setAddTime(long addTime) {
                    this.addTime = addTime;
                }

                public Object getSubCustomerId() {
                    return subCustomerId;
                }

                public void setSubCustomerId(Object subCustomerId) {
                    this.subCustomerId = subCustomerId;
                }

                public int getDisType() {
                    return disType;
                }

                public void setDisType(int disType) {
                    this.disType = disType;
                }

                public int getOrderItemId() {
                    return orderItemId;
                }

                public void setOrderItemId(int orderItemId) {
                    this.orderItemId = orderItemId;
                }

                public Object getDistribution() {
                    return distribution;
                }

                public void setDistribution(Object distribution) {
                    this.distribution = distribution;
                }

                public String getCustomerName() {
                    return customerName;
                }

                public void setCustomerName(String customerName) {
                    this.customerName = customerName;
                }
            }
        }
    }
}
