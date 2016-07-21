package com.action.showme;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

public class Exec extends ActionSupport {
    private static final long serialVersionUID = 1L;
    
    private String step;
    private String name;
    private String birth;
    private Map<String, Integer> mapDateSetting = new TreeMap<String, Integer>();
    
    public Exec() {
        mapDateSetting.put("minYear", 1970);
        mapDateSetting.put("minMonth", 1);
        mapDateSetting.put("minDay", 1);
    }
    
    public void setStep(String _step) {
        step = _step;
    }
    
    public String getStep() {
        return step;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String _name) {
        name = _name;
    }
    
    public String getBirth() {
        return birth;
    }
    
    public void setBirth(String _birth) {
        birth = _birth;
    }
    
    @Override
    public void validate() {
        System.out.println("Validate Step:" + step);
        System.out.println("Validate start");
        System.out.println("Validate name:" + name);
        System.out.println("Validate birth:" + birth);
        
        if (name != null) {
            addFieldError("name", "illegal");
        } 
        
        Calendar minDate = Calendar.getInstance();
        Calendar nowDate = Calendar.getInstance();
        
        minDate.set(mapDateSetting.get("minYear"), mapDateSetting.get("minMonth"), mapDateSetting.get("minDay"));
        
        //if (birth == null
        //    || birth.after(minDate.getTime())
        //    || birth.before(nowDate.getTime())) {
        //    addFieldError("birth", "illegal");
        //}
        
        System.out.println("Validate end");
    }

    @Override
    public String execute() throws Exception {
        System.out.println("Execute()");
        return ActionSupport.SUCCESS;
    }
}
