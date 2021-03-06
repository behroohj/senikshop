package com.abideveloprs.smartmarket.debug.ormquery;

import com.orm.query.Condition;
import com.orm.query.Select;
import com.abideveloprs.smartmarket.debug.orm.buyrangeORM;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class buyRangeQuery {
    public boolean buyRangeQueryInput(int input)
    {
        Select Query         = Select.from(buyrangeORM.class).where(Condition.prop("idMaster").eq(input));
        long count            = Query.count();

        if(count==0)
            return true;
            //insert
        else
            return false;
        //update
    }
}
