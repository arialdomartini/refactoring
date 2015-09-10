package it.bebox.refactoring.sproutmethod;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BadTransactionGate {
    private TransactionBundle transactionBundle;

    public void postEntries(List entries) {
        List entriesToAdd = new LinkedList();
        for (Iterator it = entries.iterator(); it.hasNext(); ) {
            Entry entry = (Entry) it.next();
            if(! transactionBundle.getListManager().hasEntry(entry))
            {
                entry.postDate();
                entriesToAdd.add(entry);
            }
        }
        transactionBundle.getListManager().add(entriesToAdd);
    }
}
