package com.abideveloprs.smartmarket.debug.ormquery;

import com.abideveloprs.smartmarket.debug.orm.productORM;
import com.orm.query.Condition;
import com.orm.query.Select;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class productQuery {
    public boolean productQueryInput(int input)
    {
        Select Query          = Select.from(productORM.class).where(Condition.prop("idMaster").eq(input));
        long count            = Query.count();

        if(count==0)
            return true;
            //insert
        else
            return false;
        //update
    }
}
