package ru.home.saperov;

import com.sun.faces.facelets.tag.jsf.core.ConvertDateTimeHandler;
import org.primefaces.event.SelectEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
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
    private List<String> tableRow; //строка таблицы
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
    private String console;
    private List<String> items = new ArrayList<>();
    private String selectedItem;
    private String elemListOneMenu;
    private String firstElemListOneMenu;
    private final int CNT_DAY_YEAR = 61;

    public void setElemListOneMenu(String elemListOneMenu) {
        this.elemListOneMenu = elemListOneMenu;
    }

    public String getElemListOneMenu() {
        return elemListOneMenu;
    }
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
        columnHeaders.add("Ф.И.О.");
        for (int i=0; i<CNT_DAY_YEAR; i++){
            columnHeaders.add(dtf_dm.format(localDT));
            localDT=localDT.plusDays(1);
        }
        /*tableRow = new ArrayList<>();
        tableRow2 = new ArrayList<>();*/

        /*tableRow.add("Сотрудник1");
        tableData.add(tableRow);

        tableRow2.add( "Сотрудник2");
        tableData.add(tableRow2);*/
        /*arrPers[0] = "Сотрудник1";
        tableData.add(Arrays.asList(arrPers));
        arrPers[0] = "Сотрудник2";
        tableData.add(Arrays.asList(arrPers));
        tableData.add(Arrays.asList(new String[]{"p", "p", "p"}));
        tableData.add(Arrays.asList(new String[]{"o", "o", "o"}));
        tableData.add(Arrays.asList(new String[]{"н", "н", "н"}));*/

        //for (int k=0; k<4; k++) {
            /*for (int i = 0; i < 31; i++) {
                //arrPers[i] = String.valueOf(i) + o ;
                arrPers[i] = "P";
            }*/
        //}
        items.add("1Сотрудник");
        items.add("2Сотрудник");
        items.add("3Сотрудник");
        items.add("4Сотрудник");
        firstElemListOneMenu = getFirstItemEmployee();
        tableData = new ArrayList();
        for (int i=0; i<items.size(); i++){
            tableRow = new ArrayList<>();
            tableRow.add(items.get(i));
            for (int k=0; k<(CNT_DAY_YEAR - 1); k++){
                tableRow.add("");
            }
            tableData.add(tableRow);
        }
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
        /*for (int i = 0; i<=(numDayFromBegYear4 - numDayFromBegYear3); i++){
            arrPers[numDayFromBegYear3 + i] = "O";
        }*/
        /*arrPers[0]="Саперов А.В.";
        tableData.add(Arrays.asList(arrPers));*/
        /*for (String employee : items){
            arrPers[0] = employee;
            tableData.add(Arrays.asList(arrPers));
        }*/
        for (List<String> empl : tableData){
            if (empl.get(0).equals(selectedItem)  && (numDayFromBegYear4 != 0) && (numDayFromBegYear3 != 0) && (numDayFromBegYear4 > numDayFromBegYear3)){  //если это выбранный сотрудник проставляем ему дни отпуска
                //empl.set(1, "O");
                for (int i = 0; i<=(numDayFromBegYear4 - numDayFromBegYear3); i++){
                    //arrPers[numDayFromBegYear3 + i] = "O";
                    empl.set(numDayFromBegYear3 + i, "O");
                }
            }
        }
        System.out.println("getSelectedItem:" + selectedItem);
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

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public void buttonAction(ActionEvent actionEvent){
        items.add(getElemListOneMenu());
        tableRow = new ArrayList<>();
        tableRow.add(getElemListOneMenu());
        for (int k=0; k<(CNT_DAY_YEAR - 1); k++){
            tableRow.add("");
        }
        tableData.add(tableRow);
        System.out.println("buttonAction pressed" );
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public List<String> getItems() {
        return items;
    }

    public String getFirstItemEmployee(){
        int countEmployee=items.size();
        if (countEmployee>0){
            return items.get(0);
        } else return "no employee";
    }

    public void subjectSelectionChanged(AjaxBehaviorEvent event){
        System.out.println("selectOneMenu event:" + event.getSource().toString());
    }
    /*<p:commandButton value="Submit"  actionListener="#{dateData.clickComButton}" icon="ui-icon-check" >*/
}
