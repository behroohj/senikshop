package com.abideveloprs.smartmarket.debug.ormquery;

import com.abideveloprs.smartmarket.debug.orm.pheaderORM;
import com.orm.query.Condition;
import com.orm.query.Select;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class productHeaderQuery {
    public boolean productHeaderQueryInput(int input)
    {
        Select Query          = Select.from(pheaderORM.class).where(Condition.prop("idapp").eq(input));
        long count            = Query.count();

        if(count==0)
            return true;
            //insert
        else
            return false;
        //update
    }
}
