package com.baimeiyx.www.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodsDetailResult extends  BaseResult {

    /**
     * comment : null
     * data : null
     * page : {"totalCount":10,"pageSize":1,"totalPage":10,"currPage":1,"list":[{"id":1373,"foodCategoryId":78,"foodName":"基围虾","foodImg":"https://s.boohee.cn/house/new_food/big/aabefd4f35e34f478bcfd930a77b9fb5.jpg","heatQuantity":101,"nutrientContent":"低热量,高蛋白,,低脂肪,,,","proteinProportion":"","fatProportion":"","carbohydrateProportion":"","thanContent":"","comment":"高蛋白虾类，钾和钙含量较高，但同时含有较多胆固醇和钠，不宜食用过多。","isDelete":1,"addUser":"","addTime":null,"updateTime":null,"updateUser":"","fats":"1.4","carbohydrates":"3.9","proteins":"18.2","dynamicImg":"","typeName":null,"keywords":null,"remark":"千卡","nutrientElement":"101","remarks":null,"mark":null,"specificationsUnit":null,"type":null,"protein":null,"carbohydrate":null,"fat":null,"sysCodeId":null,"name":null,"value":null,"specifications":null,"quantityHeat":null,"spec":null,"nutrientList":null}]}
     */

    private PageBean page;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public static class PageBean {
        /**
         * totalCount : 10
         * pageSize : 1
         * totalPage : 10
         * currPage : 1
         * list : [{"id":1373,"foodCategoryId":78,"foodName":"基围虾","foodImg":"https://s.boohee.cn/house/new_food/big/aabefd4f35e34f478bcfd930a77b9fb5.jpg","heatQuantity":101,"nutrientContent":"低热量,高蛋白,,低脂肪,,,","proteinProportion":"","fatProportion":"","carbohydrateProportion":"","thanContent":"","comment":"高蛋白虾类，钾和钙含量较高，但同时含有较多胆固醇和钠，不宜食用过多。","isDelete":1,"addUser":"","addTime":null,"updateTime":null,"updateUser":"","fats":"1.4","carbohydrates":"3.9","proteins":"18.2","dynamicImg":"","typeName":null,"keywords":null,"remark":"千卡","nutrientElement":"101","remarks":null,"mark":null,"specificationsUnit":null,"type":null,"protein":null,"carbohydrate":null,"fat":null,"sysCodeId":null,"name":null,"value":null,"specifications":null,"quantityHeat":null,"spec":null,"nutrientList":null}]
         */

        private int totalCount;
        private int pageSize;
        private int totalPage;
        private int currPage;
        private List<ListBean> list;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getCurrPage() {
            return currPage;
        }

        public void setCurrPage(int currPage) {
            this.currPage = currPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
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
             * remark : 千卡
             * nutrientElement : 101
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
             * spec : null
             * nutrientList : null
             */

            private int id;
            private int foodCategoryId;
            private String foodName;
            private String foodImg;
            private int heatQuantity;
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
            private String remark;
            private String nutrientElement;
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
            private Object spec;
            private Object nutrientList;

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

            public int getHeatQuantity() {
                return heatQuantity;
            }

            public void setHeatQuantity(int heatQuantity) {
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

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getNutrientElement() {
                return nutrientElement;
            }

            public void setNutrientElement(String nutrientElement) {
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

            public Object getSpec() {
                return spec;
            }

            public void setSpec(Object spec) {
                this.spec = spec;
            }

            public Object getNutrientList() {
                return nutrientList;
            }

            public void setNutrientList(Object nutrientList) {
                this.nutrientList = nutrientList;
            }
        }
    }
}
