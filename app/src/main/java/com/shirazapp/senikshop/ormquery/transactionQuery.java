package com.shirazapp.senikshop.ormquery;

import com.orm.query.Condition;
import com.orm.query.Select;
import com.shirazapp.senikshop.orm.transaction;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class transactionQuery {
    public boolean transactionQueryInput(int input)
    {
        Select Query          = Select.from(transaction.class).where(Condition.prop("idMaster").eq(input));
        long count            = Query.count();

        if(count==0)
            return true;
            //insert
        else
            return false;
        //update
    }
}
