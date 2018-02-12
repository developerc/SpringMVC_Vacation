package ru.home.saperov;

import com.sun.faces.facelets.tag.jsf.core.ConvertDateTimeHandler;
import org.primefaces.event.SelectEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

@ManagedBean(name="dateData", eager = true)
@SessionScoped
public class DateData {
    private List<List> tableData; // =simulated database.
    private List columnHeaders;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    DateTimeFormatter dtf_dm = DateTimeFormatter.ofPattern("dd MMM");
    LocalDateTime localDT;
    String dt;  //дата начала периода
    private Date date3;
    private Date date4;
    String [] arrPers = new String[62];
    private int numDayFromBegYear3 = 0;
    private int numDayFromBegYear4 = 0;
   // LocalDateTime now = LocalDateTime.now(); //текущая дата

public DateData(){
    loadTableData();
}

    private void loadTableData() {
// Set column headers.
        columnHeaders = new ArrayList();
        dt = "2018-01-01 00:00";
        localDT = LocalDateTime.parse(dt, dtf);
        /*localDT = LocalDateTime.parse(dt, dtf);
        System.out.println(localDT);
        columnHeaders.add(dtf_dm.format(localDT));
        localDT=localDT.plusDays(1);
        columnHeaders.add(dtf_dm.format(localDT));
        localDT=localDT.plusDays(1);
        columnHeaders.add(dtf_dm.format(localDT));*/
        for (int i=0; i<62; i++){
            columnHeaders.add(dtf_dm.format(localDT));
            localDT=localDT.plusDays(1);
        }

        tableData = new ArrayList();
        /*tableData.add(Arrays.asList(new String[]{"p", "p", "p"}));
        tableData.add(Arrays.asList(new String[]{"o", "o", "o"}));
        tableData.add(Arrays.asList(new String[]{"н", "н", "н"}));*/
        String o = "o";
//        String [] arrPers = new String[62];
        //for (int k=0; k<4; k++) {
            for (int i = 0; i < 31; i++) {
                //arrPers[i] = String.valueOf(i) + o ;
                arrPers[i] = "P";
            }
            tableData.add(Arrays.asList(arrPers));
        //}
    }

    public List<List> getTableData() {
        return tableData;
    }

    public List getColumnHeaders() {
        return columnHeaders;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public Date getDate4() {
        return date4;
    }

    public void setDate4(Date date4) {
        this.date4 = date4;
    }

    public void onDate3Select(SelectEvent event) {
        /*date calendar selected:Thu Feb 01 00:00:00 MSK 2018*/
        //event.getObject();
        /*int numMonth = 0;
        DateTimeFormatter dtfcalc = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss 'MSK' yyyy");
        String dateStr=event.getObject().toString();
        String dt3 = event.getObject().toString();
        //localDT = LocalDateTime.parse(dt, dtfcalc);
        //localDT = LocalDateTime.
        String[] arrDate = dt3.split(" ");

        //localDT = (LocalDateTime) event.getObject();
        //dt = dtf_dm.format(localDT);
        //LocalDate ld = LocalDate.of(Integer.parseInt(arrDate[5]), Month.valueOf(arrDate[1].toUpperCase()).getValue(), Integer.parseInt(arrDate[2]));
        System.out.println(Integer.parseInt(arrDate[5]));
        try {
            Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(arrDate[1]);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            numMonth = cal.get(Calendar.MONTH);
            numMonth++;
            System.out.println(numMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(Integer.parseInt(arrDate[2]));
        LocalDate ld = LocalDate.of(Integer.parseInt(arrDate[5]), numMonth, Integer.parseInt(arrDate[2]));
        System.out.println("номер дня с начала года:" + ld.getDayOfYear());
        System.out.println("date3 calendar selected:" + arrDate[5] + "-" + arrDate[1] + "-" + arrDate[2]);*/
        //находим номер дня с начала года
        numDayFromBegYear3 = getNumDayFromBegYear(event);
        System.out.println("номер дня с начала года начало периода:" + numDayFromBegYear3);
    }

    public void onDate4Select(SelectEvent event){
        /*String dt4 = event.getObject().toString();
        String[] arrDate = dt4.split(" ");
        System.out.println("date4 calendar selected:" + arrDate[5] + "-" + arrDate[1] + "-" + arrDate[2]);*/
        numDayFromBegYear4 = getNumDayFromBegYear(event);
        System.out.println("номер дня с начала года конец периода:" + numDayFromBegYear4);
    }

    public void clickComButton(){
        /*arrPers[0]="O";
        arrPers[14]="O";
        tableData.add(Arrays.asList(arrPers));*/
        for (int i = 0; i<=(numDayFromBegYear4 - numDayFromBegYear3); i++){
            arrPers[numDayFromBegYear3 + i-1] = "O";
        }
        System.out.println("Начало отпуска:"+date3+"Конец отпуска:"+date4);
    }

    private int getNumDayFromBegYear(SelectEvent event){
        int ndfby = 0;
        int numMonth = 0;
        String dt3 = event.getObject().toString();
        String[] arrDate = dt3.split(" ");
        try {
            Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(arrDate[1]);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            numMonth = cal.get(Calendar.MONTH);
            numMonth++;
            LocalDate ld = LocalDate.of(Integer.parseInt(arrDate[5]), numMonth, Integer.parseInt(arrDate[2]));
            ndfby = ld.getDayOfYear();
           // System.out.println(numMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    if (ndfby>0){
            return ndfby;
        } else {
        return 0;
    }
    }
    /*<p:commandButton value="Submit"  actionListener="#{dateData.clickComButton}" icon="ui-icon-check" >*/
}
