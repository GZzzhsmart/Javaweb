package com.gs.mapping;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Trade {
    private Integer id;
    private BigDecimal spent;
    private Date tradeTime;
    private Integer playerId;

    private Player player;

    private List<TradeItem> tradeItemList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSpent() {
        return spent;
    }

    public void setSpent(BigDecimal spent) {
        this.spent = spent;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<TradeItem> getTradeItemList() {
        return tradeItemList;
    }

    public void setTradeItemList(List<TradeItem> tradeItemList) {
        this.tradeItemList = tradeItemList;
    }
}
