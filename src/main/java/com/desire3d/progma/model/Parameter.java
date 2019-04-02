package com.desire3d.progma.model;

import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable = "true")
@EmbeddedOnly
@FetchGroup(name = "Parameter",members = { 
                                         @Persistent(name = "position"), 
                                         @Persistent(name = "value"), 
                                         @Persistent(name = "dynamic") 
                                        })
public class Parameter {
    
    private  int position;

    private  String value;

    private  boolean dynamic;

    public Parameter(){

    }

    public Parameter(int position, String value) {
        this.position = position;
        this.dynamic = value.toString().equalsIgnoreCase("?");
        if(!this.dynamic)
            this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public boolean isDynamic(){
        return this.dynamic;
    }

    @Override
    public String toString() {
        return "Postion ["+position+"] Value ["+value+"] Dynamic ["+dynamic+"]";
    }
 
    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @param dynamic the dynamic to set
     */
    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }
}