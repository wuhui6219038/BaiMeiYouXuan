package com.baimeiyx.www.service.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FoodElementDetailResult extends BaseResult {
    /**
     * message : null
     * comment : null
     * data : null
     * page : {"id":1373,"foodCategoryId":78,"foodName":"基围虾","foodImg":"https://s.boohee.cn/house/new_food/big/aabefd4f35e34f478bcfd930a77b9fb5.jpg","heatQuantity":101,"nutrientContent":"低热量,高蛋白,,低脂肪,,,","proteinProportion":"","fatProportion":"","carbohydrateProportion":"","thanContent":"","comment":"高蛋白虾类，钾和钙含量较高，但同时含有较多胆固醇和钠，不宜食用过多。","isDelete":1,"addUser":"","addTime":null,"updateTime":null,"updateUser":"","fats":"1.4","carbohydrates":"3.9","proteins":"18.2","dynamicImg":"","typeName":null,"keywords":null,"remark":null,"nutrientElement":null,"remarks":null,"mark":null,"specificationsUnit":null,"type":null,"protein":null,"carbohydrate":null,"fat":null,"sysCodeId":null,"name":null,"value":null,"specifications":null,"quantityHeat":null,"spec":[{"id":501,"specifications":"1.0","specificationsUnit":"只","tbFoodId":1373,"protein":"0","carbohydrate":"0","fat":"0","quantityHeat":15,"remark":""}],"nutrientList":[{"id":59178,"sysCodeId":"996e500452f643c9912b458a1cc6869b","nutrientElement":"101.0","remarks":"","tbFoodId":1373,"name":"卡路里","unit":""},{"id":59179,"sysCodeId":"e4ee5d5ce78e4f2880116dfc3ff185e1","nutrientElement":"39.7","remarks":"","tbFoodId":1373,"name":"硒","unit":""},{"id":59174,"sysCodeId":"1b85037ba5724d3f90eba35a596c27eb","nutrientElement":"139.0","remarks":"","tbFoodId":1373,"name":"磷","unit":""},{"id":59177,"sysCodeId":"174489fa88b9481cbb5bb7a04a174a86","nutrientElement":"3.9","remarks":"","tbFoodId":1373,"name":"糖类","unit":""},{"id":59168,"sysCodeId":"f847ca3763cb417e9a142aa63bb74af0","nutrientElement":"","remarks":"","tbFoodId":1373,"name":"维他命B","unit":""},{"id":59169,"sysCodeId":"88b755db2cbf48c6bc139602e932e123","nutrientElement":"","remarks":"","tbFoodId":1373,"name":"维他命C","unit":""},{"id":59183,"sysCodeId":"b7d0924dd70f45f2921046bad7ecb628","nutrientElement":"0.1","remarks":"","tbFoodId":1373,"name":"维生素B","unit":""},{"id":59182,"sysCodeId":"b1b965de98304076a802528faf653cb0","nutrientElement":"0.0","remarks":"","tbFoodId":1373,"name":"维生素B1","unit":""},{"id":59172,"sysCodeId":"bde67e73267541c183ff156e5de91ceb","nutrientElement":"2.9","remarks":"","tbFoodId":1373,"name":"维生素B3","unit":""},{"id":59170,"sysCodeId":"57b8b65f12e94189ac9e18e60d55eb28","nutrientElement":"1.7","remarks":"","tbFoodId":1373,"name":"维生素E","unit":""},{"id":59184,"sysCodeId":"f8bbe4c33aa94db99881548c600073bf","nutrientElement":"181.0","remarks":"","tbFoodId":1373,"name":"胆固醇","unit":""},{"id":59171,"sysCodeId":"cc37aa277caa4c3485846b4e1117f91a","nutrientElement":"","remarks":"","tbFoodId":1373,"name":"胡萝卜素","unit":""},{"id":59181,"sysCodeId":"c59dbb8fe2974f2a804bffab563857e2","nutrientElement":"1.4","remarks":"","tbFoodId":1373,"name":"脂肪","unit":""},{"id":59166,"sysCodeId":"7272e7246de7477bbdcddbac33a9c462","nutrientElement":"","remarks":"","tbFoodId":1373,"name":"膳食纤维","unit":""},{"id":59180,"sysCodeId":"72c199476e9d4f9db5551561421352d5","nutrientElement":"18.2","remarks":"","tbFoodId":1373,"name":"蛋白质","unit":""},{"id":59167,"sysCodeId":"4787fdfc61a04e7eb60f5508ab237de3","nutrientElement":"83.0","remarks":"","tbFoodId":1373,"name":"钙","unit":""},{"id":59187,"sysCodeId":"47045c03583a49849eb1e0b5fd606b37","nutrientElement":"172.0","remarks":"","tbFoodId":1373,"name":"钠","unit":""},{"id":59175,"sysCodeId":"ce474090c81c456b9d36293e792d8260","nutrientElement":"250.0","remarks":"","tbFoodId":1373,"name":"钾","unit":""},{"id":59185,"sysCodeId":"ed55618999b946e8a85d7ca4e82b5ab3","nutrientElement":"2.0","remarks":"","tbFoodId":1373,"name":"铁","unit":""},{"id":59186,"sysCodeId":"10a213b305384b4da905c7bb99d055f7","nutrientElement":"0.5","remarks":"","tbFoodId":1373,"name":"铜","unit":""},{"id":59188,"sysCodeId":"4f93251c46434be294138af8551fc199","nutrientElement":"1.2","remarks":"","tbFoodId":1373,"name":"锌","unit":""},{"id":59176,"sysCodeId":"3b6e65fc765d473eb6887a3a6f000855","nutrientElement":"0.1","remarks":"","tbFoodId":1373,"name":"锰","unit":""},{"id":59173,"sysCodeId":"e994fdca53bc4b2d9c086e31516f3eb7","nutrientElement":"45.0","remarks":"","tbFoodId":1373,"name":"镁","unit":""}]}
     */

    private PageBean page;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public static class PageBean implements Serializable {
        /**
         * id : 1373
         * foodCategoryId : 78
         * foodName : 基围虾
         * foodImg : https://s.boohee.cn/house/new_food/big/aabefd4f35e34f478bcfd930a77b9fb5.jpg
         * heatQuantity : 101
         * nutrientContent : 低热量,高蛋白,,低脂肪,,,
         * proteinProportion :
         * fatProportion :
         * carbohydrateProportion :
         * thanContent :
         * comment : 高蛋白虾类，钾和钙含量较高，但同时含有较多胆固醇和钠，不宜食用过多。
         * isDelete : 1
         * addUser :
         * addTime : null
         * updateTime : null
         * updateUser :
         * fats : 1.4
         * carbohydrates : 3.9
         * proteins : 18.2
         * dynamicImg :
         * typeName : null
         * keywords : null
         * remark : null
         * nutrientElement : null
         * remarks : null
         * mark : null
         * specificationsUnit : null
         * type : null
         * protein : null
         * carbohydrate : null
         * fat : null
         * sysCodeId : null
         * name : null
         * value : null
         * specifications : null
         * quantityHeat : null
         * spec : [{"id":501,"specifications":"1.0","specificationsUnit":"只","tbFoodId":1373,"protein":"0","carbohydrate":"0","fat":"0","quantityHeat":15,"remark":""}]
         * nutrientList : [{"id":59178,"sysCodeId":"996e500452f643c9912b458a1cc6869b","nutrientElement":"101.0","remarks":"","tbFoodId":1373,"name":"卡路里","unit":""},{"id":59179,"sysCodeId":"e4ee5d5ce78e4f2880116dfc3ff185e1","nutrientElement":"39.7","remarks":"","tbFoodId":1373,"name":"硒","unit":""},{"id":59174,"sysCodeId":"1b85037ba5724d3f90eba35a596c27eb","nutrientElement":"139.0","remarks":"","tbFoodId":1373,"name":"磷","unit":""},{"id":59177,"sysCodeId":"174489fa88b9481cbb5bb7a04a174a86","nutrientElement":"3.9","remarks":"","tbFoodId":1373,"name":"糖类","unit":""},{"id":59168,"sysCodeId":"f847ca3763cb417e9a142aa63bb74af0","nutrientElement":"","remarks":"","tbFoodId":1373,"name":"维他命B","unit":""},{"id":59169,"sysCodeId":"88b755db2cbf48c6bc139602e932e123","nutrientElement":"","remarks":"","tbFoodId":1373,"name":"维他命C","unit":""},{"id":59183,"sysCodeId":"b7d0924dd70f45f2921046bad7ecb628","nutrientElement":"0.1","remarks":"","tbFoodId":1373,"name":"维生素B","unit":""},{"id":59182,"sysCodeId":"b1b965de98304076a802528faf653cb0","nutrientElement":"0.0","remarks":"","tbFoodId":1373,"name":"维生素B1","unit":""},{"id":59172,"sysCodeId":"bde67e73267541c183ff156e5de91ceb","nutrientElement":"2.9","remarks":"","tbFoodId":1373,"name":"维生素B3","unit":""},{"id":59170,"sysCodeId":"57b8b65f12e94189ac9e18e60d55eb28","nutrientElement":"1.7","remarks":"","tbFoodId":1373,"name":"维生素E","unit":""},{"id":59184,"sysCodeId":"f8bbe4c33aa94db99881548c600073bf","nutrientElement":"181.0","remarks":"","tbFoodId":1373,"name":"胆固醇","unit":""},{"id":59171,"sysCodeId":"cc37aa277caa4c3485846b4e1117f91a","nutrientElement":"","remarks":"","tbFoodId":1373,"name":"胡萝卜素","unit":""},{"id":59181,"sysCodeId":"c59dbb8fe2974f2a804bffab563857e2","nutrientElement":"1.4","remarks":"","tbFoodId":1373,"name":"脂肪","unit":""},{"id":59166,"sysCodeId":"7272e7246de7477bbdcddbac33a9c462","nutrientElement":"","remarks":"","tbFoodId":1373,"name":"膳食纤维","unit":""},{"id":59180,"sysCodeId":"72c199476e9d4f9db5551561421352d5","nutrientElement":"18.2","remarks":"","tbFoodId":1373,"name":"蛋白质","unit":""},{"id":59167,"sysCodeId":"4787fdfc61a04e7eb60f5508ab237de3","nutrientElement":"83.0","remarks":"","tbFoodId":1373,"name":"钙","unit":""},{"id":59187,"sysCodeId":"47045c03583a49849eb1e0b5fd606b37","nutrientElement":"172.0","remarks":"","tbFoodId":1373,"name":"钠","unit":""},{"id":59175,"sysCodeId":"ce474090c81c456b9d36293e792d8260","nutrientElement":"250.0","remarks":"","tbFoodId":1373,"name":"钾","unit":""},{"id":59185,"sysCodeId":"ed55618999b946e8a85d7ca4e82b5ab3","nutrientElement":"2.0","remarks":"","tbFoodId":1373,"name":"铁","unit":""},{"id":59186,"sysCodeId":"10a213b305384b4da905c7bb99d055f7","nutrientElement":"0.5","remarks":"","tbFoodId":1373,"name":"铜","unit":""},{"id":59188,"sysCodeId":"4f93251c46434be294138af8551fc199","nutrientElement":"1.2","remarks":"","tbFoodId":1373,"name":"锌","unit":""},{"id":59176,"sysCodeId":"3b6e65fc765d473eb6887a3a6f000855","nutrientElement":"0.1","remarks":"","tbFoodId":1373,"name":"锰","unit":""},{"id":59173,"sysCodeId":"e994fdca53bc4b2d9c086e31516f3eb7","nutrientElement":"45.0","remarks":"","tbFoodId":1373,"name":"镁","unit":""}]
         */

        private int id;
        private int foodCategoryId;
        private String foodName;
        private String foodImg;
        private String heatQuantity;
        private String nutrientContent;
        private String proteinProportion;
        private String fatProportion;
        private String carbohydrateProportion;
        private String thanContent;
        @SerializedName("comment")
        private String commentX;
        private int isDelete;
        private String addUser;
        private Object addTime;
        private Object updateTime;
        private String updateUser;
        private String fats;
        private String carbohydrates;
        private String proteins;
        private String dynamicImg;
        private Object typeName;
        private Object keywords;
        private Object remark;
        private Object nutrientElement;
        private Object remarks;
        private Object mark;
        private Object specificationsUnit;
        private Object type;
        private Object protein;
        private Object carbohydrate;
        private Object fat;
        private Object sysCodeId;
        private Object name;
        private Object value;
        private Object specifications;
        private Object quantityHeat;
        private List<SpecBean> spec;
        private List<NutrientListBean> nutrientList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFoodCategoryId() {
            return foodCategoryId;
        }

        public void setFoodCategoryId(int foodCategoryId) {
            this.foodCategoryId = foodCategoryId;
        }

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public String getFoodImg() {
            return foodImg;
        }

        public void setFoodImg(String foodImg) {
            this.foodImg = foodImg;
        }

        public String getHeatQuantity() {
            return heatQuantity;
        }

        public void setHeatQuantity(String heatQuantity) {
            this.heatQuantity = heatQuantity;
        }

        public String getNutrientContent() {
            return nutrientContent;
        }

        public void setNutrientContent(String nutrientContent) {
            this.nutrientContent = nutrientContent;
        }

        public String getProteinProportion() {
            return proteinProportion;
        }

        public void setProteinProportion(String proteinProportion) {
            this.proteinProportion = proteinProportion;
        }

        public String getFatProportion() {
            return fatProportion;
        }

        public void setFatProportion(String fatProportion) {
            this.fatProportion = fatProportion;
        }

        public String getCarbohydrateProportion() {
            return carbohydrateProportion;
        }

        public void setCarbohydrateProportion(String carbohydrateProportion) {
            this.carbohydrateProportion = carbohydrateProportion;
        }

        public String getThanContent() {
            return thanContent;
        }

        public void setThanContent(String thanContent) {
            this.thanContent = thanContent;
        }

        public String getCommentX() {
            return commentX;
        }

        public void setCommentX(String commentX) {
            this.commentX = commentX;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public String getAddUser() {
            return addUser;
        }

        public void setAddUser(String addUser) {
            this.addUser = addUser;
        }

        public Object getAddTime() {
            return addTime;
        }

        public void setAddTime(Object addTime) {
            this.addTime = addTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateUser() {
            return updateUser;
        }

        public void setUpdateUser(String updateUser) {
            this.updateUser = updateUser;
        }

        public String getFats() {
            return fats;
        }

        public void setFats(String fats) {
            this.fats = fats;
        }

        public String getCarbohydrates() {
            return carbohydrates;
        }

        public void setCarbohydrates(String carbohydrates) {
            this.carbohydrates = carbohydrates;
        }

        public String getProteins() {
            return proteins;
        }

        public void setProteins(String proteins) {
            this.proteins = proteins;
        }

        public String getDynamicImg() {
            return dynamicImg;
        }

        public void setDynamicImg(String dynamicImg) {
            this.dynamicImg = dynamicImg;
        }

        public Object getTypeName() {
            return typeName;
        }

        public void setTypeName(Object typeName) {
            this.typeName = typeName;
        }

        public Object getKeywords() {
            return keywords;
        }

        public void setKeywords(Object keywords) {
            this.keywords = keywords;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getNutrientElement() {
            return nutrientElement;
        }

        public void setNutrientElement(Object nutrientElement) {
            this.nutrientElement = nutrientElement;
        }

        public Object getRemarks() {
            return remarks;
        }

        public void setRemarks(Object remarks) {
            this.remarks = remarks;
        }

        public Object getMark() {
            return mark;
        }

        public void setMark(Object mark) {
            this.mark = mark;
        }

        public Object getSpecificationsUnit() {
            return specificationsUnit;
        }

        public void setSpecificationsUnit(Object specificationsUnit) {
            this.specificationsUnit = specificationsUnit;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Object getProtein() {
            return protein;
        }

        public void setProtein(Object protein) {
            this.protein = protein;
        }

        public Object getCarbohydrate() {
            return carbohydrate;
        }

        public void setCarbohydrate(Object carbohydrate) {
            this.carbohydrate = carbohydrate;
        }

        public Object getFat() {
            return fat;
        }

        public void setFat(Object fat) {
            this.fat = fat;
        }

        public Object getSysCodeId() {
            return sysCodeId;
        }

        public void setSysCodeId(Object sysCodeId) {
            this.sysCodeId = sysCodeId;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getSpecifications() {
            return specifications;
        }

        public void setSpecifications(Object specifications) {
            this.specifications = specifications;
        }

        public Object getQuantityHeat() {
            return quantityHeat;
        }

        public void setQuantityHeat(Object quantityHeat) {
            this.quantityHeat = quantityHeat;
        }

        public List<SpecBean> getSpec() {
            return spec;
        }

        public void setSpec(List<SpecBean> spec) {
            this.spec = spec;
        }

        public List<NutrientListBean> getNutrientList() {
            return nutrientList;
        }

        public void setNutrientList(List<NutrientListBean> nutrientList) {
            this.nutrientList = nutrientList;
        }

        public static class SpecBean {
            /**
             * id : 501
             * specifications : 1.0
             * specificationsUnit : 只
             * tbFoodId : 1373
             * protein : 0
             * carbohydrate : 0
             * fat : 0
             * quantityHeat : 15
             * remark :
             */

            private int id;
            private String specifications;
            private String specificationsUnit;
            private int tbFoodId;
            private String protein;
            private String carbohydrate;
            private String fat;
            private int quantityHeat;
            private String remark;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSpecifications() {
                return specifications;
            }

            public void setSpecifications(String specifications) {
                this.specifications = specifications;
            }

            public String getSpecificationsUnit() {
                return specificationsUnit;
            }

            public void setSpecificationsUnit(String specificationsUnit) {
                this.specificationsUnit = specificationsUnit;
            }

            public int getTbFoodId() {
                return tbFoodId;
            }

            public void setTbFoodId(int tbFoodId) {
                this.tbFoodId = tbFoodId;
            }

            public String getProtein() {
                return protein;
            }

            public void setProtein(String protein) {
                this.protein = protein;
            }

            public String getCarbohydrate() {
                return carbohydrate;
            }

            public void setCarbohydrate(String carbohydrate) {
                this.carbohydrate = carbohydrate;
            }

            public String getFat() {
                return fat;
            }

            public void setFat(String fat) {
                this.fat = fat;
            }

            public int getQuantityHeat() {
                return quantityHeat;
            }

            public void setQuantityHeat(int quantityHeat) {
                this.quantityHeat = quantityHeat;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }
        }

        public static class NutrientListBean implements Serializable {
            /**
             * id : 59178
             * sysCodeId : 996e500452f643c9912b458a1cc6869b
             * nutrientElement : 101.0
             * remarks :
             * tbFoodId : 1373
             * name : 卡路里
             * unit :
             */

            private int id;
            private String sysCodeId;
            private String nutrientElement;
            private String remarks;
            private int tbFoodId;
            private String name;
            private String unit;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSysCodeId() {
                return sysCodeId;
            }

            public void setSysCodeId(String sysCodeId) {
                this.sysCodeId = sysCodeId;
            }

            public String getNutrientElement() {
                return nutrientElement;
            }

            public void setNutrientElement(String nutrientElement) {
                this.nutrientElement = nutrientElement;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public int getTbFoodId() {
                return tbFoodId;
            }

            public void setTbFoodId(int tbFoodId) {
                this.tbFoodId = tbFoodId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }
        }
    }
}
