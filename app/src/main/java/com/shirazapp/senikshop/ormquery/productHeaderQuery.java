package com.shirazapp.senikshop.ormquery;

import com.orm.query.Condition;
import com.orm.query.Select;
import com.shirazapp.senikshop.orm.pheader;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class productHeaderQuery {
    public boolean productHeaderQueryInput(int input)
    {
        Select Query          = Select.from(pheader.class).where(Condition.prop("idapp").eq(input));
        long count            = Query.count();

        if(count==0)
            return true;
            //insert
        else
            return false;
        //update
    }
}
