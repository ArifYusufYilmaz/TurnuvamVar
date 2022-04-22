package com.turnuvamvar.thesis.core.utilities.CodeAndPassword.abstracts;

public abstract class AutoGenerateTeamCodeInfo {
    private String info;

    protected void setInfo(String info){
        this.info = info;
    }
    public String getInfo(){
        return this.info;
    }
    protected String generateInfo(){
        return "12abc123";
    }
}
