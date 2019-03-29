package com.baimeiyx.www.service.model;

import java.util.List;

public class FoodsElementSortResult extends  BaseResult {

    /**
     * comment : null
     * data : null
     * page : [{"id":"10a213b305384b4da905c7bb99d055f7","mark":"copper","name":"铜","value":"copper","type":"2","parentId":"fcffebcfc298484599a1daa281c26710","sort":null,"remark":"","createId":null,"createTime":null,"updateId":null,"updateTime":null,"open":"true"}]
     */

    private List<PageBean> page;

    public List<PageBean> getPage() {
        return page;
    }

    public void setPage(List<PageBean> page) {
        this.page = page;
    }

    public static class PageBean {
        /**
         * id : 10a213b305384b4da905c7bb99d055f7
         * mark : copper
         * name : 铜
         * value : copper
         * type : 2
         * parentId : fcffebcfc298484599a1daa281c26710
         * sort : null
         * remark :
         * createId : null
         * createTime : null
         * updateId : null
         * updateTime : null
         * open : true
         */

        private String id;
        private String mark;
        private String name;
        private String value;
        private String type;
        private String parentId;
        private Object sort;
        private String remark;
        private Object createId;
        private Object createTime;
        private Object updateId;
        private Object updateTime;
        private String open;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public Object getSort() {
            return sort;
        }

        public void setSort(Object sort) {
            this.sort = sort;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Object getCreateId() {
            return createId;
        }

        public void setCreateId(Object createId) {
            this.createId = createId;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateId() {
            return updateId;
        }

        public void setUpdateId(Object updateId) {
            this.updateId = updateId;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }
    }
}
