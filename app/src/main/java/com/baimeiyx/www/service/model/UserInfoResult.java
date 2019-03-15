package com.baimeiyx.www.service.model;

public class UserInfoResult extends BaseResult {
    /**
     * stateCode : 100
     * message : null
     * comment : null
     * data : {"id":"cfcb5acc04a04f9185b5846d80af7b9a","orgCode":"01","customerName":"NanShanJi","qq":"","password":"88888888","phone":"15281870818","birth":null,"wx":"","phone2":"","phone3":"","sex":1,"remark":"","photo":"https://wx.qlogo.cn/mmopen/vi_32/RbDkiaYEibaIbCdog7gAudSibV5eeZNiaKibUibYloZj6Suk5lAzkw6WjWdYdsferTS8QdKHeyiadbibcXH2Y2pfIBA7gg/132","addressP":"","address":"","addressC":null,"customerBusinessType":1,"customerType":1,"customerSource":1,"customerLevel":1,"invitationCode":"6rnASY18","customerId":"10f8ef8adf324226aaca66a87929135c","createId":"026a564bbfd84861ac4b65393644beef","createTime":1540447979403,"isTrack":2,"isHelp":2,"updateTime":1540468223200,"emergContact":null,"emergPhone":null,"myDeclaration":"s身上睡","openId":null,"weixinName":"we'ji'ro'w'y危机融无语","unionId":"oxrHj1HzpiDAsy8HwAPqI23GzYZc","pNumberOpenId":null,"smallProgramOpenid":"o4bvL4uNuxayG8E0c6FxGwpsBMF8","freezingAmount":null,"cashBalance":null,"availableAmount":null,"sumChangeValue":null,"behaviorType":null,"txType":null,"recordStatus":null,"disType":null,"totalDistributionCash":null,"oldPassword":null,"smsCode":null}
     * page : null
     * ok : true
     */

    private DataBean data;
    private DataBean page;

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public DataBean getPage() {
        return page;
    }

    public void setPage(DataBean page) {
        this.page = page;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : cfcb5acc04a04f9185b5846d80af7b9a
         * orgCode : 01
         * customerName : NanShanJi
         * qq :
         * password : 88888888
         * phone : 15281870818
         * birth : null
         * wx :
         * phone2 :
         * phone3 :
         * sex : 1
         * remark :
         * photo : https://wx.qlogo.cn/mmopen/vi_32/RbDkiaYEibaIbCdog7gAudSibV5eeZNiaKibUibYloZj6Suk5lAzkw6WjWdYdsferTS8QdKHeyiadbibcXH2Y2pfIBA7gg/132
         * addressP :
         * address :
         * addressC : null
         * customerBusinessType : 1
         * customerType : 1
         * customerSource : 1
         * customerLevel : 1
         * invitationCode : 6rnASY18
         * customerId : 10f8ef8adf324226aaca66a87929135c
         * createId : 026a564bbfd84861ac4b65393644beef
         * createTime : 1540447979403
         * isTrack : 2
         * isHelp : 2
         * updateTime : 1540468223200
         * emergContact : null
         * emergPhone : null
         * myDeclaration : s身上睡
         * openId : null
         * weixinName : we'ji'ro'w'y危机融无语
         * unionId : oxrHj1HzpiDAsy8HwAPqI23GzYZc
         * pNumberOpenId : null
         * smallProgramOpenid : o4bvL4uNuxayG8E0c6FxGwpsBMF8
         * freezingAmount : null
         * cashBalance : null
         * availableAmount : null
         * sumChangeValue : null
         * behaviorType : null
         * txType : null
         * recordStatus : null
         * disType : null
         * totalDistributionCash : null
         * oldPassword : null
         * smsCode : null
         */

        private String id;
        private String orgCode;
        private String customerName;
        private String qq;
        private String password;
        private String phone;
        private Object birth;
        private String wx;
        private String phone2;
        private String phone3;
        private int sex;
        private String remark;
        private String photo;
        private String addressP;
        private String address;
        private Object addressC;
        private int customerBusinessType;
        private int customerType;
        private int customerSource;
        private int customerLevel;
        private String invitationCode;
        private String customerId;
        private String createId;
        private long createTime;
        private int isTrack;
        private int isHelp;
        private long updateTime;
        private Object emergContact;
        private Object emergPhone;
        private String myDeclaration;
        private Object openId;
        private String weixinName;
        private String unionId;
        private Object pNumberOpenId;
        private String smallProgramOpenid;
        private double freezingAmount;
        private double cashBalance;
        private double availableAmount;
        private double sumChangeValue;
        private Object behaviorType;
        private Object txType;
        private Object recordStatus;
        private Object disType;
        private Object totalDistributionCash;
        private Object oldPassword;
        private Object smsCode;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrgCode() {
            return orgCode;
        }

        public void setOrgCode(String orgCode) {
            this.orgCode = orgCode;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getBirth() {
            return birth;
        }

        public void setBirth(Object birth) {
            this.birth = birth;
        }

        public String getWx() {
            return wx;
        }

        public void setWx(String wx) {
            this.wx = wx;
        }

        public String getPhone2() {
            return phone2;
        }

        public void setPhone2(String phone2) {
            this.phone2 = phone2;
        }

        public String getPhone3() {
            return phone3;
        }

        public void setPhone3(String phone3) {
            this.phone3 = phone3;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getAddressP() {
            return addressP;
        }

        public void setAddressP(String addressP) {
            this.addressP = addressP;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Object getAddressC() {
            return addressC;
        }

        public void setAddressC(Object addressC) {
            this.addressC = addressC;
        }

        public int getCustomerBusinessType() {
            return customerBusinessType;
        }

        public void setCustomerBusinessType(int customerBusinessType) {
            this.customerBusinessType = customerBusinessType;
        }

        public int getCustomerType() {
            return customerType;
        }

        public void setCustomerType(int customerType) {
            this.customerType = customerType;
        }

        public int getCustomerSource() {
            return customerSource;
        }

        public void setCustomerSource(int customerSource) {
            this.customerSource = customerSource;
        }

        public int getCustomerLevel() {
            return customerLevel;
        }

        public void setCustomerLevel(int customerLevel) {
            this.customerLevel = customerLevel;
        }

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getCreateId() {
            return createId;
        }

        public void setCreateId(String createId) {
            this.createId = createId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getIsTrack() {
            return isTrack;
        }

        public void setIsTrack(int isTrack) {
            this.isTrack = isTrack;
        }

        public int getIsHelp() {
            return isHelp;
        }

        public void setIsHelp(int isHelp) {
            this.isHelp = isHelp;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public Object getEmergContact() {
            return emergContact;
        }

        public void setEmergContact(Object emergContact) {
            this.emergContact = emergContact;
        }

        public Object getEmergPhone() {
            return emergPhone;
        }

        public void setEmergPhone(Object emergPhone) {
            this.emergPhone = emergPhone;
        }

        public String getMyDeclaration() {
            return myDeclaration;
        }

        public void setMyDeclaration(String myDeclaration) {
            this.myDeclaration = myDeclaration;
        }

        public Object getOpenId() {
            return openId;
        }

        public void setOpenId(Object openId) {
            this.openId = openId;
        }

        public String getWeixinName() {
            return weixinName;
        }

        public void setWeixinName(String weixinName) {
            this.weixinName = weixinName;
        }

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }

        public Object getPNumberOpenId() {
            return pNumberOpenId;
        }

        public void setPNumberOpenId(Object pNumberOpenId) {
            this.pNumberOpenId = pNumberOpenId;
        }

        public String getSmallProgramOpenid() {
            return smallProgramOpenid;
        }

        public void setSmallProgramOpenid(String smallProgramOpenid) {
            this.smallProgramOpenid = smallProgramOpenid;
        }

        public Object getFreezingAmount() {
            return freezingAmount;
        }

        public void setFreezingAmount(double freezingAmount) {
            this.freezingAmount = freezingAmount;
        }

        public double getCashBalance() {
            return cashBalance;
        }

        public void setCashBalance(double cashBalance) {
            this.cashBalance = cashBalance;
        }

        public double getAvailableAmount() {
            return availableAmount;
        }

        public void setAvailableAmount(double availableAmount) {
            this.availableAmount = availableAmount;
        }

        public double getSumChangeValue() {
            return sumChangeValue;
        }

        public void setSumChangeValue(double sumChangeValue) {
            this.sumChangeValue = sumChangeValue;
        }

        public Object getBehaviorType() {
            return behaviorType;
        }

        public void setBehaviorType(Object behaviorType) {
            this.behaviorType = behaviorType;
        }

        public Object getTxType() {
            return txType;
        }

        public void setTxType(Object txType) {
            this.txType = txType;
        }

        public Object getRecordStatus() {
            return recordStatus;
        }

        public void setRecordStatus(Object recordStatus) {
            this.recordStatus = recordStatus;
        }

        public Object getDisType() {
            return disType;
        }

        public void setDisType(Object disType) {
            this.disType = disType;
        }

        public Object getTotalDistributionCash() {
            return totalDistributionCash;
        }

        public void setTotalDistributionCash(Object totalDistributionCash) {
            this.totalDistributionCash = totalDistributionCash;
        }

        public Object getOldPassword() {
            return oldPassword;
        }

        public void setOldPassword(Object oldPassword) {
            this.oldPassword = oldPassword;
        }

        public Object getSmsCode() {
            return smsCode;
        }

        public void setSmsCode(Object smsCode) {
            this.smsCode = smsCode;
        }
    }
}
