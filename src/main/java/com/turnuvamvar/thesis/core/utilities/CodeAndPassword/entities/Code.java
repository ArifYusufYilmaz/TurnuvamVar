package com.turnuvamvar.thesis.core.utilities.CodeAndPassword.entities;

import com.turnuvamvar.thesis.core.utilities.CodeAndPassword.abstracts.AutoGenerateTeamCodeInfo;

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
