package com.turnuvamvar.thesis.core.CodeAndPassword.entities.concretes;

import com.turnuvamvar.thesis.core.CodeAndPassword.entities.abstracts.AutoGenerateTeamCodeInfo;

public class Code extends AutoGenerateTeamCodeInfo {
    private String code;
    public Code(){
        this.setInfo(generateInfo());
    }
    @Override
    protected String generateInfo(){
        return code = "asdf1234";        // her defasında değişecek şekilde düzenlenmeli.
    }
}
