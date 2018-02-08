package ru.home.saperov;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name="repData", eager = true)
@SessionScoped
public class RepData {
    private ArrayList<String> repStr = new ArrayList<String>();
    private ArrayList<ArrayList<String>> repListStr = new ArrayList<ArrayList<String>>();

    private List<List> tableData; // =simulated database.
    private List columnHeaders;

    public RepData(){
        loadTableData();
    }

    private void loadTableData() {
        // Set column headers.
//columnHeaders = new String[]{“ID”, “Name”, “Age”}; // =alternative if the columns are known upfront.
        columnHeaders = new ArrayList();
        columnHeaders.add("ID");
        columnHeaders.add("Name");
        columnHeaders.add("Age");

// Set table data.
        tableData = new ArrayList();
        tableData.add(Arrays.asList(new String[]{"88653", "Polline", "1"}));
        tableData.add(Arrays.asList(new String[]{"15934", "Helmut", "5"}));
        tableData.add(Arrays.asList(new String[]{"83521", "Monique", "4"}));
        tableData.add(Arrays.asList(new String[]{"54984", "Hans", "19"}));
        tableData.add(Arrays.asList(new String[]{"75558", "Frederick", "43"}));
    }

    public List<List> getTableData() {
        return tableData;
    }

    public List getColumnHeaders() {
        return columnHeaders;
    }

    public ArrayList<ArrayList<String>> getRepListStr() {
        repListStr.add(getRepStr());
        repListStr.add(getRepStr());
        return repListStr;
    }

    public void setRepListStr(ArrayList<ArrayList<String>> repListStr) {
        this.repListStr = repListStr;
    }

    public ArrayList<String> getRepStr() {
        repStr.add("one");
        repStr.add("two");
        repStr.add("three");

        return repStr;
    }

    public void setRepStr(ArrayList<String> repStr) {
        this.repStr = repStr;
    }


    /*<h:form>
           <c:forEach items="#{repData.repStr}"  var="item">
                <h:outputText value="#{item}" />
           </c:forEach>
       </h:form>*/
}
