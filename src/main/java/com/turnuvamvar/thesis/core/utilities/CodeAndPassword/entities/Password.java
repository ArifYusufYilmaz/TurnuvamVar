package com.turnuvamvar.thesis.core.utilities.CodeAndPassword.entities;

import com.turnuvamvar.thesis.core.utilities.CodeAndPassword.abstracts.AutoGenerateTeamCodeInfo;

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
