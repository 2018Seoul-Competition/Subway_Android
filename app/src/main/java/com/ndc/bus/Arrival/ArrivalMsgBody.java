package com.ndc.bus.Arrival;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "msgBody", strict = false)
public class ArrivalMsgBody {

    //@ElementList(name = "itemList", required=false)
    @ElementList(entry = "itemList", inline = true, required = false)
    private List<ArrivalItemList> arrivalItemList;

    public List<ArrivalItemList> getArrivalItemList() {
        return arrivalItemList;
    }

    public void setArrivalItemList(List<ArrivalItemList> arrivalItemList) {
        this.arrivalItemList = arrivalItemList;
    }

}