/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSP;

import java.sql.Date;

/**
 *
 * @author mzhao
 */
public class RevisionControl {
    private int revisionid;

    
    private String description;
    private String scope;
    private String controlvolume;
    private String systemmodels;

    RevisionControl(int aInt, String string, String string0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
   public void setRevisionId(int revisionid){
       this.revisionid = revisionid;
   }
   public void setDescription(String description){
       this.description = description;
   }
   public void setScope(String scope){
       this.scope = scope;
   }
   public void setControlVolume(String controlvolume){
       this.controlvolume = controlvolume;
   }
   public void setSystemModels(String systemmodels){
       this.systemmodels = systemmodels;
   }

}

