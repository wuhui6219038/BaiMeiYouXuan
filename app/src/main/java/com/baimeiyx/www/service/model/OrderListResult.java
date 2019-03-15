package com.baimeiyx.www.service.model;

import java.util.List;

public class OrderListResult extends BaseResult {

    /**
     * message : null
     * comment : null
     * data : {"MAYI_POS_API_MSID":"9317063a762f4c92b886938c3f13d41c","limit":"2","page":"1","statusA":"1","customerId":"13dfa5aed7544866ac99120a1efc7b84","status":"1","payStatus":"1","list":[{"id":1001490,"orderNo":"u83q20181105094456970","shopId":null,"customerId":"13dfa5aed7544866ac99120a1efc7b84","customerName":"NanShanJi","tReceivingInfoId":null,"defrayId":null,"defrayName":null,"paymentType":null,"paymentId":null,"paymentName":null,"freightAmount":0,"amount":160,"gold":0,"payAmount":160,"pointAmount":null,"pointUse":null,"couponId":null,"couponAmount":null,"isDelete":null,"status":1,"payStatus":1,"confirmStatus":null,"shippingStatus":1,"totalQty":1,"totalQtyRefunded":0,"totalQtyShipped":0,"refundPayAmount":null,"refundGlod":null,"ordDesc":null,"source":1,"accountRemark":null,"addTime":1541382297000,"payTime":null,"shippingTime":null,"signTime":null,"remark":null,"isSendMessage":null,"promotion":null,"regionName":null,"provinceId":null,"cityId":null,"areaId":null,"address":"自己人不要发货","rowTotal":null,"provinceName":"安徽省","cityName":"马鞍山市","areaName":"花山区","mobile":"15281870818","consignee":"胡涛涛","goodsName":"擦地拖地智能扫地机器人家用全自动擦地拖地机器人一体机洗地机--测试商品，拍下不予发货~","qty":"1","qtyRefunded":"0","qtyShipped":"0","salePrice":160,"dealPrice":null,"attrValues":null,"productImage":null,"skuImage":null,"orderItemShippingStatus":1,"orderItemSignStatus":null,"skuId":0,"itemId":2260,"isDistribution":null,"distribution":null,"orderItemId":2120,"supCustomerId":null,"customerName2":null,"tuikuanStatus":null,"carrierName":null,"carrierNumber":null,"orderCount":null,"sumOrderPrice":null,"totalAmount":null,"tOrderCount":null,"sumTOrderAmount":null,"commonStatus":null,"allTorderCount":null,"notPayCount":null,"oRderItemSignStatus":1,"totalRefund":null,"valueName":null},{"id":1001489,"orderNo":"JixL20181105094218335","shopId":null,"customerId":"13dfa5aed7544866ac99120a1efc7b84","customerName":"NanShanJi","tReceivingInfoId":null,"defrayId":null,"defrayName":null,"paymentType":null,"paymentId":null,"paymentName":null,"freightAmount":0,"amount":160,"gold":0,"payAmount":160,"pointAmount":null,"pointUse":null,"couponId":null,"couponAmount":null,"isDelete":null,"status":1,"payStatus":1,"confirmStatus":null,"shippingStatus":1,"totalQty":1,"totalQtyRefunded":0,"totalQtyShipped":0,"refundPayAmount":null,"refundGlod":null,"ordDesc":null,"source":1,"accountRemark":null,"addTime":1541382138000,"payTime":null,"shippingTime":null,"signTime":null,"remark":null,"isSendMessage":null,"promotion":null,"regionName":null,"provinceId":null,"cityId":null,"areaId":null,"address":"自己人不要发货","rowTotal":null,"provinceName":"安徽省","cityName":"马鞍山市","areaName":"花山区","mobile":"15281870818","consignee":"胡涛涛","goodsName":"擦地拖地智能扫地机器人家用全自动擦地拖地机器人一体机洗地机--测试商品，拍下不予发货~","qty":"1","qtyRefunded":"0","qtyShipped":"0","salePrice":160,"dealPrice":null,"attrValues":null,"productImage":null,"skuImage":null,"orderItemShippingStatus":1,"orderItemSignStatus":null,"skuId":0,"itemId":2260,"isDistribution":null,"distribution":null,"orderItemId":2119,"supCustomerId":null,"customerName2":null,"tuikuanStatus":null,"carrierName":null,"carrierNumber":null,"orderCount":null,"sumOrderPrice":null,"totalAmount":null,"tOrderCount":null,"sumTOrderAmount":null,"commonStatus":null,"allTorderCount":null,"notPayCount":null,"oRderItemSignStatus":1,"totalRefund":null,"valueName":null}]}
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
         * statusA : 1
         * customerId : 13dfa5aed7544866ac99120a1efc7b84
         * status : 1
         * payStatus : 1
         * list : [{"id":1001490,"orderNo":"u83q20181105094456970","shopId":null,"customerId":"13dfa5aed7544866ac99120a1efc7b84","customerName":"NanShanJi","tReceivingInfoId":null,"defrayId":null,"defrayName":null,"paymentType":null,"paymentId":null,"paymentName":null,"freightAmount":0,"amount":160,"gold":0,"payAmount":160,"pointAmount":null,"pointUse":null,"couponId":null,"couponAmount":null,"isDelete":null,"status":1,"payStatus":1,"confirmStatus":null,"shippingStatus":1,"totalQty":1,"totalQtyRefunded":0,"totalQtyShipped":0,"refundPayAmount":null,"refundGlod":null,"ordDesc":null,"source":1,"accountRemark":null,"addTime":1541382297000,"payTime":null,"shippingTime":null,"signTime":null,"remark":null,"isSendMessage":null,"promotion":null,"regionName":null,"provinceId":null,"cityId":null,"areaId":null,"address":"自己人不要发货","rowTotal":null,"provinceName":"安徽省","cityName":"马鞍山市","areaName":"花山区","mobile":"15281870818","consignee":"胡涛涛","goodsName":"擦地拖地智能扫地机器人家用全自动擦地拖地机器人一体机洗地机--测试商品，拍下不予发货~","qty":"1","qtyRefunded":"0","qtyShipped":"0","salePrice":160,"dealPrice":null,"attrValues":null,"productImage":null,"skuImage":null,"orderItemShippingStatus":1,"orderItemSignStatus":null,"skuId":0,"itemId":2260,"isDistribution":null,"distribution":null,"orderItemId":2120,"supCustomerId":null,"customerName2":null,"tuikuanStatus":null,"carrierName":null,"carrierNumber":null,"orderCount":null,"sumOrderPrice":null,"totalAmount":null,"tOrderCount":null,"sumTOrderAmount":null,"commonStatus":null,"allTorderCount":null,"notPayCount":null,"oRderItemSignStatus":1,"totalRefund":null,"valueName":null},{"id":1001489,"orderNo":"JixL20181105094218335","shopId":null,"customerId":"13dfa5aed7544866ac99120a1efc7b84","customerName":"NanShanJi","tReceivingInfoId":null,"defrayId":null,"defrayName":null,"paymentType":null,"paymentId":null,"paymentName":null,"freightAmount":0,"amount":160,"gold":0,"payAmount":160,"pointAmount":null,"pointUse":null,"couponId":null,"couponAmount":null,"isDelete":null,"status":1,"payStatus":1,"confirmStatus":null,"shippingStatus":1,"totalQty":1,"totalQtyRefunded":0,"totalQtyShipped":0,"refundPayAmount":null,"refundGlod":null,"ordDesc":null,"source":1,"accountRemark":null,"addTime":1541382138000,"payTime":null,"shippingTime":null,"signTime":null,"remark":null,"isSendMessage":null,"promotion":null,"regionName":null,"provinceId":null,"cityId":null,"areaId":null,"address":"自己人不要发货","rowTotal":null,"provinceName":"安徽省","cityName":"马鞍山市","areaName":"花山区","mobile":"15281870818","consignee":"胡涛涛","goodsName":"擦地拖地智能扫地机器人家用全自动擦地拖地机器人一体机洗地机--测试商品，拍下不予发货~","qty":"1","qtyRefunded":"0","qtyShipped":"0","salePrice":160,"dealPrice":null,"attrValues":null,"productImage":null,"skuImage":null,"orderItemShippingStatus":1,"orderItemSignStatus":null,"skuId":0,"itemId":2260,"isDistribution":null,"distribution":null,"orderItemId":2119,"supCustomerId":null,"customerName2":null,"tuikuanStatus":null,"carrierName":null,"carrierNumber":null,"orderCount":null,"sumOrderPrice":null,"totalAmount":null,"tOrderCount":null,"sumTOrderAmount":null,"commonStatus":null,"allTorderCount":null,"notPayCount":null,"oRderItemSignStatus":1,"totalRefund":null,"valueName":null}]
         */

        private String MAYI_POS_API_MSID;
        private String limit;
        private String page;
        private String statusA;
        private String customerId;
        private String status;
        private String payStatus;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(String payStatus) {
            this.payStatus = payStatus;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1001490
             * orderNo : u83q20181105094456970
             * shopId : null
             * customerId : 13dfa5aed7544866ac99120a1efc7b84
             * customerName : NanShanJi
             * tReceivingInfoId : null
             * defrayId : null
             * defrayName : null
             * paymentType : null
             * paymentId : null
             * paymentName : null
             * freightAmount : 0
             * amount : 160
             * gold : 0
             * payAmount : 160
             * pointAmount : null
             * pointUse : null
             * couponId : null
             * couponAmount : null
             * isDelete : null
             * status : 1
             * payStatus : 1
             * confirmStatus : null
             * shippingStatus : 1
             * totalQty : 1
             * totalQtyRefunded : 0
             * totalQtyShipped : 0
             * refundPayAmount : null
             * refundGlod : null
             * ordDesc : null
             * source : 1
             * accountRemark : null
             * addTime : 1541382297000
             * payTime : null
             * shippingTime : null
             * signTime : null
             * remark : null
             * isSendMessage : null
             * promotion : null
             * regionName : null
             * provinceId : null
             * cityId : null
             * areaId : null
             * address : 自己人不要发货
             * rowTotal : null
             * provinceName : 安徽省
             * cityName : 马鞍山市
             * areaName : 花山区
             * mobile : 15281870818
             * consignee : 胡涛涛
             * goodsName : 擦地拖地智能扫地机器人家用全自动擦地拖地机器人一体机洗地机--测试商品，拍下不予发货~
             * qty : 1
             * qtyRefunded : 0
             * qtyShipped : 0
             * salePrice : 160
             * dealPrice : null
             * attrValues : null
             * productImage : null
             * skuImage : null
             * orderItemShippingStatus : 1
             * orderItemSignStatus : null
             * skuId : 0
             * itemId : 2260
             * isDistribution : null
             * distribution : null
             * orderItemId : 2120
             * supCustomerId : null
             * customerName2 : null
             * tuikuanStatus : null
             * carrierName : null
             * carrierNumber : null
             * orderCount : null
             * sumOrderPrice : null
             * totalAmount : null
             * tOrderCount : null
             * sumTOrderAmount : null
             * commonStatus : null
             * allTorderCount : null
             * notPayCount : null
             * oRderItemSignStatus : 1
             * totalRefund : null
             * valueName : null
             */

            private int id;
            private String orderNo;
            private Object shopId;
            private String customerId;
            private String customerName;
            private Object tReceivingInfoId;
            private Object defrayId;
            private Object defrayName;
            private Object paymentType;
            private Object paymentId;
            private Object paymentName;
            private int freightAmount;
            private int amount;
            private int gold;
            private int payAmount;
            private Object pointAmount;
            private Object pointUse;
            private Object couponId;
            private Object couponAmount;
            private Object isDelete;
            private int status;
            private int payStatus;
            private Object confirmStatus;
            private int shippingStatus;
            private int totalQty;
            private int totalQtyRefunded;
            private int totalQtyShipped;
            private Object refundPayAmount;
            private Object refundGlod;
            private Object ordDesc;
            private int source;
            private Object accountRemark;
            private long addTime;
            private Object payTime;
            private Object shippingTime;
            private Object signTime;
            private Object remark;
            private Object isSendMessage;
            private Object promotion;
            private Object regionName;
            private Object provinceId;
            private Object cityId;
            private Object areaId;
            private String address;
            private Object rowTotal;
            private String provinceName;
            private String cityName;
            private String areaName;
            private String mobile;
            private String consignee;
            private String goodsName;
            private String qty;
            private String qtyRefunded;
            private String qtyShipped;
            private int salePrice;
            private Object dealPrice;
            private Object attrValues;
            private Object productImage;
            private Object skuImage;
            private int orderItemShippingStatus;
            private Object orderItemSignStatus;
            private int skuId;
            private int itemId;
            private Object isDistribution;
            private Object distribution;
            private int orderItemId;
            private Object supCustomerId;
            private Object customerName2;
            private Object tuikuanStatus;
            private Object carrierName;
            private Object carrierNumber;
            private Object orderCount;
            private Object sumOrderPrice;
            private Object totalAmount;
            private Object tOrderCount;
            private Object sumTOrderAmount;
            private Object commonStatus;
            private Object allTorderCount;
            private Object notPayCount;
            private int oRderItemSignStatus;
            private Object totalRefund;
            private Object valueName;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public Object getShopId() {
                return shopId;
            }

            public void setShopId(Object shopId) {
                this.shopId = shopId;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public Object getTReceivingInfoId() {
                return tReceivingInfoId;
            }

            public void setTReceivingInfoId(Object tReceivingInfoId) {
                this.tReceivingInfoId = tReceivingInfoId;
            }

            public Object getDefrayId() {
                return defrayId;
            }

            public void setDefrayId(Object defrayId) {
                this.defrayId = defrayId;
            }

            public Object getDefrayName() {
                return defrayName;
            }

            public void setDefrayName(Object defrayName) {
                this.defrayName = defrayName;
            }

            public Object getPaymentType() {
                return paymentType;
            }

            public void setPaymentType(Object paymentType) {
                this.paymentType = paymentType;
            }

            public Object getPaymentId() {
                return paymentId;
            }

            public void setPaymentId(Object paymentId) {
                this.paymentId = paymentId;
            }

            public Object getPaymentName() {
                return paymentName;
            }

            public void setPaymentName(Object paymentName) {
                this.paymentName = paymentName;
            }

            public int getFreightAmount() {
                return freightAmount;
            }

            public void setFreightAmount(int freightAmount) {
                this.freightAmount = freightAmount;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public int getGold() {
                return gold;
            }

            public void setGold(int gold) {
                this.gold = gold;
            }

            public int getPayAmount() {
                return payAmount;
            }

            public void setPayAmount(int payAmount) {
                this.payAmount = payAmount;
            }

            public Object getPointAmount() {
                return pointAmount;
            }

            public void setPointAmount(Object pointAmount) {
                this.pointAmount = pointAmount;
            }

            public Object getPointUse() {
                return pointUse;
            }

            public void setPointUse(Object pointUse) {
                this.pointUse = pointUse;
            }

            public Object getCouponId() {
                return couponId;
            }

            public void setCouponId(Object couponId) {
                this.couponId = couponId;
            }

            public Object getCouponAmount() {
                return couponAmount;
            }

            public void setCouponAmount(Object couponAmount) {
                this.couponAmount = couponAmount;
            }

            public Object getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(Object isDelete) {
                this.isDelete = isDelete;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getPayStatus() {
                return payStatus;
            }

            public void setPayStatus(int payStatus) {
                this.payStatus = payStatus;
            }

            public Object getConfirmStatus() {
                return confirmStatus;
            }

            public void setConfirmStatus(Object confirmStatus) {
                this.confirmStatus = confirmStatus;
            }

            public int getShippingStatus() {
                return shippingStatus;
            }

            public void setShippingStatus(int shippingStatus) {
                this.shippingStatus = shippingStatus;
            }

            public int getTotalQty() {
                return totalQty;
            }

            public void setTotalQty(int totalQty) {
                this.totalQty = totalQty;
            }

            public int getTotalQtyRefunded() {
                return totalQtyRefunded;
            }

            public void setTotalQtyRefunded(int totalQtyRefunded) {
                this.totalQtyRefunded = totalQtyRefunded;
            }

            public int getTotalQtyShipped() {
                return totalQtyShipped;
            }

            public void setTotalQtyShipped(int totalQtyShipped) {
                this.totalQtyShipped = totalQtyShipped;
            }

            public Object getRefundPayAmount() {
                return refundPayAmount;
            }

            public void setRefundPayAmount(Object refundPayAmount) {
                this.refundPayAmount = refundPayAmount;
            }

            public Object getRefundGlod() {
                return refundGlod;
            }

            public void setRefundGlod(Object refundGlod) {
                this.refundGlod = refundGlod;
            }

            public Object getOrdDesc() {
                return ordDesc;
            }

            public void setOrdDesc(Object ordDesc) {
                this.ordDesc = ordDesc;
            }

            public int getSource() {
                return source;
            }

            public void setSource(int source) {
                this.source = source;
            }

            public Object getAccountRemark() {
                return accountRemark;
            }

            public void setAccountRemark(Object accountRemark) {
                this.accountRemark = accountRemark;
            }

            public long getAddTime() {
                return addTime;
            }

            public void setAddTime(long addTime) {
                this.addTime = addTime;
            }

            public Object getPayTime() {
                return payTime;
            }

            public void setPayTime(Object payTime) {
                this.payTime = payTime;
            }

            public Object getShippingTime() {
                return shippingTime;
            }

            public void setShippingTime(Object shippingTime) {
                this.shippingTime = shippingTime;
            }

            public Object getSignTime() {
                return signTime;
            }

            public void setSignTime(Object signTime) {
                this.signTime = signTime;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getIsSendMessage() {
                return isSendMessage;
            }

            public void setIsSendMessage(Object isSendMessage) {
                this.isSendMessage = isSendMessage;
            }

            public Object getPromotion() {
                return promotion;
            }

            public void setPromotion(Object promotion) {
                this.promotion = promotion;
            }

            public Object getRegionName() {
                return regionName;
            }

            public void setRegionName(Object regionName) {
                this.regionName = regionName;
            }

            public Object getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(Object provinceId) {
                this.provinceId = provinceId;
            }

            public Object getCityId() {
                return cityId;
            }

            public void setCityId(Object cityId) {
                this.cityId = cityId;
            }

            public Object getAreaId() {
                return areaId;
            }

            public void setAreaId(Object areaId) {
                this.areaId = areaId;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public Object getRowTotal() {
                return rowTotal;
            }

            public void setRowTotal(Object rowTotal) {
                this.rowTotal = rowTotal;
            }

            public String getProvinceName() {
                return provinceName;
            }

            public void setProvinceName(String provinceName) {
                this.provinceName = provinceName;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getConsignee() {
                return consignee;
            }

            public void setConsignee(String consignee) {
                this.consignee = consignee;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public String getQty() {
                return qty;
            }

            public void setQty(String qty) {
                this.qty = qty;
            }

            public String getQtyRefunded() {
                return qtyRefunded;
            }

            public void setQtyRefunded(String qtyRefunded) {
                this.qtyRefunded = qtyRefunded;
            }

            public String getQtyShipped() {
                return qtyShipped;
            }

            public void setQtyShipped(String qtyShipped) {
                this.qtyShipped = qtyShipped;
            }

            public int getSalePrice() {
                return salePrice;
            }

            public void setSalePrice(int salePrice) {
                this.salePrice = salePrice;
            }

            public Object getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(Object dealPrice) {
                this.dealPrice = dealPrice;
            }

            public Object getAttrValues() {
                return attrValues;
            }

            public void setAttrValues(Object attrValues) {
                this.attrValues = attrValues;
            }

            public Object getProductImage() {
                return productImage;
            }

            public void setProductImage(Object productImage) {
                this.productImage = productImage;
            }

            public Object getSkuImage() {
                return skuImage;
            }

            public void setSkuImage(Object skuImage) {
                this.skuImage = skuImage;
            }

            public int getOrderItemShippingStatus() {
                return orderItemShippingStatus;
            }

            public void setOrderItemShippingStatus(int orderItemShippingStatus) {
                this.orderItemShippingStatus = orderItemShippingStatus;
            }

            public Object getOrderItemSignStatus() {
                return orderItemSignStatus;
            }

            public void setOrderItemSignStatus(Object orderItemSignStatus) {
                this.orderItemSignStatus = orderItemSignStatus;
            }

            public int getSkuId() {
                return skuId;
            }

            public void setSkuId(int skuId) {
                this.skuId = skuId;
            }

            public int getItemId() {
                return itemId;
            }

            public void setItemId(int itemId) {
                this.itemId = itemId;
            }

            public Object getIsDistribution() {
                return isDistribution;
            }

            public void setIsDistribution(Object isDistribution) {
                this.isDistribution = isDistribution;
            }

            public Object getDistribution() {
                return distribution;
            }

            public void setDistribution(Object distribution) {
                this.distribution = distribution;
            }

            public int getOrderItemId() {
                return orderItemId;
            }

            public void setOrderItemId(int orderItemId) {
                this.orderItemId = orderItemId;
            }

            public Object getSupCustomerId() {
                return supCustomerId;
            }

            public void setSupCustomerId(Object supCustomerId) {
                this.supCustomerId = supCustomerId;
            }

            public Object getCustomerName2() {
                return customerName2;
            }

            public void setCustomerName2(Object customerName2) {
                this.customerName2 = customerName2;
            }

            public Object getTuikuanStatus() {
                return tuikuanStatus;
            }

            public void setTuikuanStatus(Object tuikuanStatus) {
                this.tuikuanStatus = tuikuanStatus;
            }

            public Object getCarrierName() {
                return carrierName;
            }

            public void setCarrierName(Object carrierName) {
                this.carrierName = carrierName;
            }

            public Object getCarrierNumber() {
                return carrierNumber;
            }

            public void setCarrierNumber(Object carrierNumber) {
                this.carrierNumber = carrierNumber;
            }

            public Object getOrderCount() {
                return orderCount;
            }

            public void setOrderCount(Object orderCount) {
                this.orderCount = orderCount;
            }

            public Object getSumOrderPrice() {
                return sumOrderPrice;
            }

            public void setSumOrderPrice(Object sumOrderPrice) {
                this.sumOrderPrice = sumOrderPrice;
            }

            public Object getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(Object totalAmount) {
                this.totalAmount = totalAmount;
            }

            public Object getTOrderCount() {
                return tOrderCount;
            }

            public void setTOrderCount(Object tOrderCount) {
                this.tOrderCount = tOrderCount;
            }

            public Object getSumTOrderAmount() {
                return sumTOrderAmount;
            }

            public void setSumTOrderAmount(Object sumTOrderAmount) {
                this.sumTOrderAmount = sumTOrderAmount;
            }

            public Object getCommonStatus() {
                return commonStatus;
            }

            public void setCommonStatus(Object commonStatus) {
                this.commonStatus = commonStatus;
            }

            public Object getAllTorderCount() {
                return allTorderCount;
            }

            public void setAllTorderCount(Object allTorderCount) {
                this.allTorderCount = allTorderCount;
            }

            public Object getNotPayCount() {
                return notPayCount;
            }

            public void setNotPayCount(Object notPayCount) {
                this.notPayCount = notPayCount;
            }

            public int getORderItemSignStatus() {
                return oRderItemSignStatus;
            }

            public void setORderItemSignStatus(int oRderItemSignStatus) {
                this.oRderItemSignStatus = oRderItemSignStatus;
            }

            public Object getTotalRefund() {
                return totalRefund;
            }

            public void setTotalRefund(Object totalRefund) {
                this.totalRefund = totalRefund;
            }

            public Object getValueName() {
                return valueName;
            }

            public void setValueName(Object valueName) {
                this.valueName = valueName;
            }
        }
    }
}
