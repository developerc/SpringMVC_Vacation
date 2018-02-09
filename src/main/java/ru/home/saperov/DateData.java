package ru.home.saperov;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name="dateData", eager = true)
@SessionScoped
public class DateData {
    private List<List> tableData; // =simulated database.
    private List columnHeaders;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    DateTimeFormatter dtf_dm = DateTimeFormatter.ofPattern("dd MMM");
    LocalDateTime localDT;
    String dt;  //дата начала периода
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
        String [] arrPers = new String[62];
        for (int k=0; k<4; k++) {
            for (int i = 0; i < 31; i++) {
                arrPers[i] = String.valueOf(i) + o ;
            }
            tableData.add(Arrays.asList(arrPers));
        }
    }

    public List<List> getTableData() {
        return tableData;
    }

    public List getColumnHeaders() {
        return columnHeaders;
    }
}
