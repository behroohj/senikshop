package com.shirazapp.senikshop.ormquery;

import com.orm.query.Condition;
import com.orm.query.Select;
import com.shirazapp.senikshop.orm.contactUs;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class contactUsQuery {
    public boolean contactUsQueryInput(int input)
    {
        Select Query          = Select.from(contactUs.class).where(Condition.prop("idMaster").eq(input));
        long count            = Query.count();

        if(count==0)
            return true;
            //insert
        else
            return false;
        //update
    }
}
