package com.cbs.springcourse.rest.models;

import javax.persistence.*;

@Entity
@Table(name = "ValCursy")
public class ValCursy {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ccy")
    private String ccy;

    @Column(name = "bccy")
    private String bccy;

    @Column(name = "buy")
    private String buy;

    @Column(name = "sale")
    private String sale;

    public ValCursy() {

    }

    public ValCursy(String ccy, String bccy, String buy, String sale) {
        this.ccy = ccy;
        this.bccy = bccy;
        this.buy = buy;
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getBccy() {
        return bccy;
    }

    public void setBccy(String bccy) {
        this.bccy = bccy;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

}
