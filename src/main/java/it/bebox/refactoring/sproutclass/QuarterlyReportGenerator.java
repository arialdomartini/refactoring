package it.bebox.refactoring.sproutclass;

import java.util.Date;

public class QuarterlyReportGenerator {
    private Date _beginDate;
    private Date _endDate;

    private QuarterlyReportGenerator() throws HardToInstanciateInATestException {
        throw new HardToInstanciateInATestException();
    }


    String generate()
    {
        ACollection results = new Database().queryResults(_beginDate, _endDate);
        String pageText = "";
        pageText += "<html><head><title>" +
        "Quarterly Report" +
        "</title></head><body><table>";

        if (results.size() != 0) {
            for (Department it = results.begin(); it != results.end(); ) {
                pageText += "<tr>";
                pageText += "<td>" + it.department + "</td>";
                pageText += "<td>" + it.manager + "</td>";
                String buffer = String.format("<td>$%d</td>", it.netProfit / 100);
                pageText += new String(buffer);
                buffer = buffer + String.format("<td>$%d</td>", it.operatingExpense / 100);
                pageText += buffer;
                pageText += "</tr>";
            }
        } else {
            pageText += "No results for this period";
        }
        pageText += "</table>";
        pageText += "</body>";
        pageText += "</html>";
        return pageText;
    }

}
