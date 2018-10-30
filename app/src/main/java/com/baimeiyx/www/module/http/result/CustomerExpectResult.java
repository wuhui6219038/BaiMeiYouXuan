package com.baimeiyx.www.module.http.result;

public class CustomerExpectResult extends BaseResult {

    /**
     * comment : null
     * data : {"MAYI_POS_API_MSID":"c7ac96be420d4ade916fe726926f24eb","data":{"id":61,"customerId":"13dfa5aed7544866ac99120a1efc7b84","initialWeight":28.2,"initialWeightTime":1540828800000,"newWeight":51.7,"newWeightTime":1540871853000,"targetWeight":48.5,"targetWeightTime":1540915200000,"createTime":1540865495000,"waistLine":150,"hipLine":90,"stature":190,"age":30}}
     * page : null
     */

    private DataBeanX data;
    private Object page;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public static class DataBeanX {
        /**
         * MAYI_POS_API_MSID : c7ac96be420d4ade916fe726926f24eb
         * data : {"id":61,"customerId":"13dfa5aed7544866ac99120a1efc7b84","initialWeight":28.2,"initialWeightTime":1540828800000,"newWeight":51.7,"newWeightTime":1540871853000,"targetWeight":48.5,"targetWeightTime":1540915200000,"createTime":1540865495000,"waistLine":150,"hipLine":90,"stature":190,"age":30}
         */

        private String MAYI_POS_API_MSID;
        private DataBean data;

        public String getMAYI_POS_API_MSID() {
            return MAYI_POS_API_MSID;
        }

        public void setMAYI_POS_API_MSID(String MAYI_POS_API_MSID) {
            this.MAYI_POS_API_MSID = MAYI_POS_API_MSID;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 61
             * customerId : 13dfa5aed7544866ac99120a1efc7b84
             * initialWeight : 28.2
             * initialWeightTime : 1540828800000
             * newWeight : 51.7
             * newWeightTime : 1540871853000
             * targetWeight : 48.5
             * targetWeightTime : 1540915200000
             * createTime : 1540865495000
             * waistLine : 150
             * hipLine : 90
             * stature : 190
             * age : 30
             */

            private int id;
            private String customerId;
            private double initialWeight;
            private long initialWeightTime;
            private double newWeight;
            private long newWeightTime;
            private double targetWeight;
            private long targetWeightTime;
            private long createTime;
            private int waistLine;
            private int hipLine;
            private int stature;
            private int age;

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

            public double getInitialWeight() {
                return initialWeight;
            }

            public void setInitialWeight(double initialWeight) {
                this.initialWeight = initialWeight;
            }

            public long getInitialWeightTime() {
                return initialWeightTime;
            }

            public void setInitialWeightTime(long initialWeightTime) {
                this.initialWeightTime = initialWeightTime;
            }

            public double getNewWeight() {
                return newWeight;
            }

            public void setNewWeight(double newWeight) {
                this.newWeight = newWeight;
            }

            public long getNewWeightTime() {
                return newWeightTime;
            }

            public void setNewWeightTime(long newWeightTime) {
                this.newWeightTime = newWeightTime;
            }

            public double getTargetWeight() {
                return targetWeight;
            }

            public void setTargetWeight(double targetWeight) {
                this.targetWeight = targetWeight;
            }

            public long getTargetWeightTime() {
                return targetWeightTime;
            }

            public void setTargetWeightTime(long targetWeightTime) {
                this.targetWeightTime = targetWeightTime;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getWaistLine() {
                return waistLine;
            }

            public void setWaistLine(int waistLine) {
                this.waistLine = waistLine;
            }

            public int getHipLine() {
                return hipLine;
            }

            public void setHipLine(int hipLine) {
                this.hipLine = hipLine;
            }

            public int getStature() {
                return stature;
            }

            public void setStature(int stature) {
                this.stature = stature;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }
    }
}
