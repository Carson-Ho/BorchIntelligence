package com.example.carson_ho.borchintelligence;

import java.util.List;

/**
 * Created by Carson_Ho on 16/6/28.
 */
public class CommodityImfor  {
    private List<Data> data ;
    private boolean fail;
    private int total;

    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }
    public void setFail(boolean fail){
        this.fail = fail;
    }
    public boolean getFail(){
        return this.fail;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return this.total;
    }


    static class Data {

        private int machineID;

        private String picture;

        private int price;

        private String address;

        private int expressCost;

        private String name;

        private int lowerestWholesale;



        public void setMachineID(int machineID) {
            this.machineID = machineID;
        }

        public int getMachineID() {
            return this.machineID;
        }


        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getPicture() {
            return this.picture;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress() {
            return this.address;
        }

        public void setExpress_cost(int express_cost) {
            this.expressCost = express_cost;
        }

        public int getExpress_cost() {
            return expressCost;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setLowerest_wholesale(int lowerest_wholesale) {
            this.lowerestWholesale = lowerest_wholesale;
        }

        public int getLowerest_wholesale() {
            return this.lowerestWholesale;
        }
    }

}

