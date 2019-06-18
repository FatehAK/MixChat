package com.socket;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class Message implements Serializable{
    
    private static final long serialVersionUID = 1L;
    public String type, sender, content, recipient;
    public DateFormat dd = new SimpleDateFormat("hh:mm a");
    public String fd;
    
    public Message(String type, String sender, String content, String recipient, String fd){
        fd=dd.format(new Date());
        this.type = type; this.sender = sender; this.content = content; this.recipient = recipient;this.fd=fd;
    }
    
    @Override
    public String toString(){
        return "{type='"+type+"', sender='"+sender+"', content='"+content+"', recipient='"+recipient+"', date='"+fd+"'}";
    }
}
