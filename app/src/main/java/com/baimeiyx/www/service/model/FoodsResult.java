package com.baimeiyx.www.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodsResult extends BaseResult {

    /**
     * comment : null
     * data : null
     * page : {"totalCount":20,"pageSize":1,"totalPage":20,"currPage":1,"list":[{"id":78,"keywords":"鱼虾海鲜","typeName":"鱼虾海鲜","description":"鱼虾海鲜","cion":"https://obs-7bff.obs.cn-north-1.myhwclouds.com:443/9E4D433CFE90AFD9FA94DB1709577DA1.jpg","addTime":null,"addUser":"","updateTime":1551777388000,"updateUser":"026a564bbfd84861ac4b65393644beef","sort":20}]}
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
         * totalCount : 20
         * pageSize : 1
         * totalPage : 20
         * currPage : 1
         * list : [{"id":78,"keywords":"鱼虾海鲜","typeName":"鱼虾海鲜","description":"鱼虾海鲜","cion":"https://obs-7bff.obs.cn-north-1.myhwclouds.com:443/9E4D433CFE90AFD9FA94DB1709577DA1.jpg","addTime":null,"addUser":"","updateTime":1551777388000,"updateUser":"026a564bbfd84861ac4b65393644beef","sort":20}]
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
             * id : 78
             * keywords : 鱼虾海鲜
             * typeName : 鱼虾海鲜
             * description : 鱼虾海鲜
             * cion : https://obs-7bff.obs.cn-north-1.myhwclouds.com:443/9E4D433CFE90AFD9FA94DB1709577DA1.jpg
             * addTime : null
             * addUser :
             * updateTime : 1551777388000
             * updateUser : 026a564bbfd84861ac4b65393644beef
             * sort : 20
             */

            private int id;
            private String keywords;
            private String typeName;
            private String description;
            private String cion;
            private Object addTime;
            private String addUser;
            private long updateTime;
            private String updateUser;
            private int sort;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCion() {
                return cion;
            }

            public void setCion(String cion) {
                this.cion = cion;
            }

            public Object getAddTime() {
                return addTime;
            }

            public void setAddTime(Object addTime) {
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

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }
        }
    }
}
