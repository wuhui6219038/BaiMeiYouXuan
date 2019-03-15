package com.baimeiyx.www.service.model;

public class LoginResult extends BaseResult {

    /**
     * stateCode : 100
     * message : null
     * comment : null
     * data : {"loginUser":{"id":"32abfa9cc2664745bc673966181b539c","orgCode":"019511","customerName":"菏泽马西博","qq":null,"password":null,"phone":"18661523345","birth":900518400000,"wx":"I0MissNa","phone2":"","phone3":"","sex":2,"remark":"","photo":"http://thirdwx.qlogo.cn/mmopen/vi_32/JZNb38BMSw8JzEMic3upas4k2BbkRAWPg6HGPAvO8H0g4mbDyoOwsseCm2DHYgIX5lsys1o4VuSBichDib0yQIqrw/132","addressP":"山东","address":"开发区国贸中心","addressC":"菏泽","customerBusinessType":null,"customerType":4,"customerSource":3,"customerLevel":2,"invitationCode":"CcThbcmv","customerId":"32abfa9cc2664745bc673966181b539c","createId":"95810c325e964ba896ed9084c973c5c0","createTime":1536734698169,"isTrack":2,"isHelp":2,"updateTime":1539249225044,"emergContact":null,"emergPhone":null,"myDeclaration":null,"openId":null,"weixinName":"晞博","unionId":"oxrHj1HcTunnjZNCjXkAC4gb6VQc","pNumberOpenId":"oRzs81h9dVYD4fBMhwPbg1BX0GM8","smallProgramOpenid":null,"freezingAmount":null,"cashBalance":null,"availableAmount":null,"sumChangeValue":null,"behaviorType":null,"txType":null,"recordStatus":null,"disType":null,"totalDistributionCash":null,"oldPassword":null,"smsCode":null},"sessionId":"5b78850c45374edb9a2839bdb35e65b6"}
     * page : null
     * ok : true
     */

    private DataBean data;
    private DataBean page;
    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public DataBean getPage() {
        return page;
    }

    public void setPage(DataBean page) {
        this.page = page;
    }


    public static class DataBean {
        /**
         * loginUser : {"id":"32abfa9cc2664745bc673966181b539c","orgCode":"019511","customerName":"菏泽马西博","qq":null,"password":null,"phone":"18661523345","birth":900518400000,"wx":"I0MissNa","phone2":"","phone3":"","sex":2,"remark":"","photo":"http://thirdwx.qlogo.cn/mmopen/vi_32/JZNb38BMSw8JzEMic3upas4k2BbkRAWPg6HGPAvO8H0g4mbDyoOwsseCm2DHYgIX5lsys1o4VuSBichDib0yQIqrw/132","addressP":"山东","address":"开发区国贸中心","addressC":"菏泽","customerBusinessType":null,"customerType":4,"customerSource":3,"customerLevel":2,"invitationCode":"CcThbcmv","customerId":"32abfa9cc2664745bc673966181b539c","createId":"95810c325e964ba896ed9084c973c5c0","createTime":1536734698169,"isTrack":2,"isHelp":2,"updateTime":1539249225044,"emergContact":null,"emergPhone":null,"myDeclaration":null,"openId":null,"weixinName":"晞博","unionId":"oxrHj1HcTunnjZNCjXkAC4gb6VQc","pNumberOpenId":"oRzs81h9dVYD4fBMhwPbg1BX0GM8","smallProgramOpenid":null,"freezingAmount":null,"cashBalance":null,"availableAmount":null,"sumChangeValue":null,"behaviorType":null,"txType":null,"recordStatus":null,"disType":null,"totalDistributionCash":null,"oldPassword":null,"smsCode":null}
         * sessionId : 5b78850c45374edb9a2839bdb35e65b6
         */

        private LoginUserBean loginUser;
        private String sessionId;

        public LoginUserBean getLoginUser() {
            return loginUser;
        }

        public void setLoginUser(LoginUserBean loginUser) {
            this.loginUser = loginUser;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public static class LoginUserBean {
            /**
             * id : 32abfa9cc2664745bc673966181b539c
             * orgCode : 019511
             * customerName : 菏泽马西博
             * qq : null
             * password : null
             * phone : 18661523345
             * birth : 900518400000
             * wx : I0MissNa
             * phone2 :
             * phone3 :
             * sex : 2
             * remark :
             * photo : http://thirdwx.qlogo.cn/mmopen/vi_32/JZNb38BMSw8JzEMic3upas4k2BbkRAWPg6HGPAvO8H0g4mbDyoOwsseCm2DHYgIX5lsys1o4VuSBichDib0yQIqrw/132
             * addressP : 山东
             * address : 开发区国贸中心
             * addressC : 菏泽
             * customerBusinessType : null
             * customerType : 4
             * customerSource : 3
             * customerLevel : 2
             * invitationCode : CcThbcmv
             * customerId : 32abfa9cc2664745bc673966181b539c
             * createId : 95810c325e964ba896ed9084c973c5c0
             * createTime : 1536734698169
             * isTrack : 2
             * isHelp : 2
             * updateTime : 1539249225044
             * emergContact : null
             * emergPhone : null
             * myDeclaration : null
             * openId : null
             * weixinName : 晞博
             * unionId : oxrHj1HcTunnjZNCjXkAC4gb6VQc
             * pNumberOpenId : oRzs81h9dVYD4fBMhwPbg1BX0GM8
             * smallProgramOpenid : null
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
            private Object qq;
            private Object password;
            private String phone;
            private long birth;
            private String wx;
            private String phone2;
            private String phone3;
            private int sex;
            private String remark;
            private String photo;
            private String addressP;
            private String address;
            private String addressC;
            private Object customerBusinessType;
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
            private String emergContact;
            private Object emergPhone;
            private String myDeclaration;
            private Object openId;
            private String weixinName;
            private String unionId;
            private String pNumberOpenId;
            private Object smallProgramOpenid;
            private Object freezingAmount;
            private Object cashBalance;
            private Object availableAmount;
            private Object sumChangeValue;
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

            public Object getQq() {
                return qq;
            }

            public void setQq(Object qq) {
                this.qq = qq;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public long getBirth() {
                return birth;
            }

            public void setBirth(long birth) {
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

            public String getAddressC() {
                return addressC;
            }

            public void setAddressC(String addressC) {
                this.addressC = addressC;
            }

            public Object getCustomerBusinessType() {
                return customerBusinessType;
            }

            public void setCustomerBusinessType(Object customerBusinessType) {
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

            public void setEmergContact(String emergContact) {
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

            public String getPNumberOpenId() {
                return pNumberOpenId;
            }

            public void setPNumberOpenId(String pNumberOpenId) {
                this.pNumberOpenId = pNumberOpenId;
            }

            public Object getSmallProgramOpenid() {
                return smallProgramOpenid;
            }

            public void setSmallProgramOpenid(Object smallProgramOpenid) {
                this.smallProgramOpenid = smallProgramOpenid;
            }

            public Object getFreezingAmount() {
                return freezingAmount;
            }

            public void setFreezingAmount(Object freezingAmount) {
                this.freezingAmount = freezingAmount;
            }

            public Object getCashBalance() {
                return cashBalance;
            }

            public void setCashBalance(Object cashBalance) {
                this.cashBalance = cashBalance;
            }

            public Object getAvailableAmount() {
                return availableAmount;
            }

            public void setAvailableAmount(Object availableAmount) {
                this.availableAmount = availableAmount;
            }

            public Object getSumChangeValue() {
                return sumChangeValue;
            }

            public void setSumChangeValue(Object sumChangeValue) {
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

    @Override
    public String toString() {
        return this.stateCode + "  " + this.message;
    }
}
