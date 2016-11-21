package com.shirazapp.senikshop.ormquery;

import com.orm.query.Condition;
import com.orm.query.Select;
import com.shirazapp.senikshop.orm.aboutUs;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class aboutUsQuery {
    public boolean aboutUsQueryInput(int input)
    {
       Select  Query         = Select.from(aboutUs.class).where(Condition.prop("idMaster").eq(input));
       long count            = Query.count();

        if(count==0)
            return true;
        //insert
        else
            return false;
        //update
    }
}
