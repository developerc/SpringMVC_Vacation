package ru.home.saperov;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean(name="sheData", eager = true)
@SessionScoped
public class SheData implements Serializable {
    private static final long serialVersionUID = 1L;
    private String jan1,jan2,jan3,jan4,jan5,jan6,jan7,jan8,jan9,jan10,jan11,jan12,jan13,jan14,jan15,jan16,jan17,jan18,jan19,jan20;
    private String jan21,jan22,jan23,jan24,jan25,jan26,jan27,jan28,jan29,jan30,jan31;
    private ArrayList<Sheduler> holyday = new ArrayList<Sheduler>(Arrays.asList(
            new Sheduler("","","","","","","","","","","","","","","","","","","","","","","","","","o","o","o","o","o","o"),
            new Sheduler("","","","","","","","","","","","","","","","","o","o","o","o","o","o","o","o","","","","","","","")
    ));

    public ArrayList<Sheduler> getHolyday() {
        return holyday;
    }

    public void setHolyday(ArrayList<Sheduler> holyday) {
        this.holyday = holyday;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getJan1() {
        return jan1;
    }

    public void setJan1(String jan1) {
        this.jan1 = jan1;
    }

    public String getJan2() {
        return jan2;
    }

    public void setJan2(String jan2) {
        this.jan2 = jan2;
    }

    public String getJan3() {
        return jan3;
    }

    public void setJan3(String jan3) {
        this.jan3 = jan3;
    }

    public String getJan4() {
        return jan4;
    }

    public void setJan4(String jan4) {
        this.jan4 = jan4;
    }

    public String getJan5() {
        return jan5;
    }

    public void setJan5(String jan5) {
        this.jan5 = jan5;
    }

    public String getJan6() {
        return jan6;
    }

    public void setJan6(String jan6) {
        this.jan6 = jan6;
    }

    public String getJan7() {
        return jan7;
    }

    public void setJan7(String jan7) {
        this.jan7 = jan7;
    }

    public String getJan8() {
        return jan8;
    }

    public void setJan8(String jan8) {
        this.jan8 = jan8;
    }

    public String getJan9() {
        return jan9;
    }

    public void setJan9(String jan9) {
        this.jan9 = jan9;
    }

    public String getJan10() {
        return jan10;
    }

    public void setJan10(String jan10) {
        this.jan10 = jan10;
    }

    public String getJan11() {
        return jan11;
    }

    public void setJan11(String jan11) {
        this.jan11 = jan11;
    }

    public String getJan12() {
        return jan12;
    }

    public void setJan12(String jan12) {
        this.jan12 = jan12;
    }

    public String getJan13() {
        return jan13;
    }

    public void setJan13(String jan13) {
        this.jan13 = jan13;
    }

    public String getJan14() {
        return jan14;
    }

    public void setJan14(String jan14) {
        this.jan14 = jan14;
    }

    public String getJan15() {
        return jan15;
    }

    public void setJan15(String jan15) {
        this.jan15 = jan15;
    }

    public String getJan16() {
        return jan16;
    }

    public void setJan16(String jan16) {
        this.jan16 = jan16;
    }

    public String getJan17() {
        return jan17;
    }

    public void setJan17(String jan17) {
        this.jan17 = jan17;
    }

    public String getJan18() {
        return jan18;
    }

    public void setJan18(String jan18) {
        this.jan18 = jan18;
    }

    public String getJan19() {
        return jan19;
    }

    public void setJan19(String jan19) {
        this.jan19 = jan19;
    }

    public String getJan20() {
        return jan20;
    }

    public void setJan20(String jan20) {
        this.jan20 = jan20;
    }

    public String getJan21() {
        return jan21;
    }

    public void setJan21(String jan21) {
        this.jan21 = jan21;
    }

    public String getJan22() {
        return jan22;
    }

    public void setJan22(String jan22) {
        this.jan22 = jan22;
    }

    public String getJan23() {
        return jan23;
    }

    public void setJan23(String jan23) {
        this.jan23 = jan23;
    }

    public String getJan24() {
        return jan24;
    }

    public void setJan24(String jan24) {
        this.jan24 = jan24;
    }

    public String getJan25() {
        return jan25;
    }

    public void setJan25(String jan25) {
        this.jan25 = jan25;
    }

    public String getJan26() {
        return jan26;
    }

    public void setJan26(String jan26) {
        this.jan26 = jan26;
    }

    public String getJan27() {
        return jan27;
    }

    public void setJan27(String jan27) {
        this.jan27 = jan27;
    }

    public String getJan28() {
        return jan28;
    }

    public void setJan28(String jan28) {
        this.jan28 = jan28;
    }

    public String getJan29() {
        return jan29;
    }

    public void setJan29(String jan29) {
        this.jan29 = jan29;
    }

    public String getJan30() {
        return jan30;
    }

    public void setJan30(String jan30) {
        this.jan30 = jan30;
    }

    public String getJan31() {
        return jan31;
    }

    public void setJan31(String jan31) {
        this.jan31 = jan31;
    }


}
