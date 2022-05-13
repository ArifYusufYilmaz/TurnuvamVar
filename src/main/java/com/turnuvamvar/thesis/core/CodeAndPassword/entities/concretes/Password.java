package com.turnuvamvar.thesis.core.CodeAndPassword.entities.concretes;

import com.turnuvamvar.thesis.core.CodeAndPassword.entities.abstracts.AutoGenerateTeamCodeInfo;

public class Password extends AutoGenerateTeamCodeInfo {
    private String password;
    public Password(){
        this.setInfo(generateInfo());
    }
   @Override
    protected String generateInfo() {
        return this.password = "12345asd";      // her defasında değişecek şekilde düzenlenmeli.
   }
}
