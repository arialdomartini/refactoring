package it.bebox.refactoring.sproutmethod;

import java.util.Iterator;
import java.util.List;

public class TransactionGate
{
    private TransactionBundle transactionBundle;

    public void postEntries(List entries) {
        for (Iterator it = entries.iterator(); it.hasNext(); ) {
            Entry entry = (Entry) it.next();
            entry.postDate();
        }
        transactionBundle.getListManager().add(entries);
    }
}


