package com.mobile.academy.trainingspringdemo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eveniment implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private Date oraInceput;
    private Date oraFinal;
    private String date;

    public Eveniment(String evenimentInfo) {

        Pattern pattern = Pattern.compile("(.*?);(.*?);(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(([01]?\\d|2[0-3]):([0-5]?\\d));(([01]?\\d|2[0-3]):([0-5]?\\d))");
        Matcher matcher = pattern.matcher(evenimentInfo);

        if (matcher.find()) {
            this.title = matcher.group(1);
            this.description = matcher.group(2);
            this.date = matcher.group(3);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            try {
                oraInceput = formatter.parse(matcher.group(3) + " " + matcher.group(7));
                oraFinal = formatter.parse(matcher.group(3) + " " + matcher.group(10));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        } else {

        }
    }


    //String ideal: " Titlu eveniment|Description|Data(zz/ll/aaaa)|OraInceput(hh:mm)|OraFinal(hh:mm)"

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOraInceput() {
        return oraInceput;
    }

    public void setOraInceput(Date oraInceput) {
        this.oraInceput = oraInceput;
    }

    public Date getOraFinal() {
        return oraFinal;
    }

    public void setOraFinal(Date oraFinal) {
        this.oraFinal = oraFinal;
    }

    @Override
    public String toString() {
        return "Eveniment{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", oraInceput=" + oraInceput +
                ", oraFinal=" + oraFinal +
                '}';
    }

    public String extractDate(){

        return this.date;

    }

}
