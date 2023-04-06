package com.qq.ssm.domain;

import com.qq.ssm.utils.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * 订单信息
 */
public class Orders {

    private String id; //无意义、主键uuid
    private String orderNum;  //订单编号
    private Date orderTime;  //下单时间
    private String orderTimeStr;  //下单时间格式化
    private int orderStatus;  //订单状态(0 未支付 1 已支付)
    private int peopleCount;  //出行人数
    private Product product;  //关联产品
    private List<Traveller> travellers;  //关联旅客
    private Member member;  //关联会员(联系人)
    private Integer payType;  //支付方式(0 支付宝 1 微信 2其它)
    private String payTypeStr;  //支付方式格式化
    private String orderDesc;  //订单描述(其它信息)

    public Orders() {
    }

    public Orders(String id, String orderNum, Date orderTime, String orderTimeStr, int orderStatus, int peopleCount, Product product, List<Traveller> travellers, Member member, Integer payType, String payTypeStr, String orderDesc) {
        this.id = id;
        this.orderNum = orderNum;
        this.orderTime = orderTime;
        this.orderTimeStr = orderTimeStr;
        this.orderStatus = orderStatus;
        this.peopleCount = peopleCount;
        this.product = product;
        this.travellers = travellers;
        this.member = member;
        this.payType = payType;
        this.payTypeStr = payTypeStr;
        this.orderDesc = orderDesc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime != null) {
            orderTimeStr = DateUtils.date2String(orderTime, "yyyy-MM-dd");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        switch (payType) {
            case 0: {
                payTypeStr = "支付宝";
                break;
            }
            case 1: {
                payTypeStr = "微信";
                break;
            }
            case 2: {
                payTypeStr = "其他";
                break;
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", peopleCount=" + peopleCount +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }
}
