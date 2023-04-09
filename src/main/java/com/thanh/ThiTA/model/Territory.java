package com.thanh.ThiTA.model;

public class Territory {
    private int territoryId;
    private String territoryDescription;
    private int regionId;
    public Territory() {
    }
    public int getTerritoryId() {
        return territoryId;
    }
    public void setTerritoryId(int territoryId) {
        this.territoryId = territoryId;
    }
    public String getTerritoryDescription() {
        return territoryDescription;
    }
    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }
    public int getRegionId() {
        return regionId;
    }
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}
