package ru.home.saperov;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean(name="repData", eager = true)
@SessionScoped
public class RepData {
    private ArrayList<String> repStr = new ArrayList<String>();
    private ArrayList<ArrayList<String>> repListStr = new ArrayList<ArrayList<String>>();

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
