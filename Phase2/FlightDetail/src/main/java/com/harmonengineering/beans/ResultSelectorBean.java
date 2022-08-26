package com.harmonengineering.beans;

import java.util.ArrayList;

public class ResultSelectorBean
{
    private int ndx , max, min , selected ;
    private boolean bInitialized ;
    private String SqlQueryText ;

    private ArrayList<FlightDetailBean> queryResult ;
    public ResultSelectorBean()
    {
        bInitialized = false ;
        queryResult = new ArrayList<FlightDetailBean>() ;
        min=0 ; ndx=0 ;
    }

    public int getNdx() { return ndx; }
    public int getMax() { return max; }
    public int getMin() { return min; }
    public int getSelected() { return selected; }
    public String getSqlQueryText() { return SqlQueryText;  }
    public ArrayList<FlightDetailBean> getQueryResult() { return queryResult; }

    public void setNdx(int ndx) { this.ndx = ndx; }
    public void setMax(int max) { this.max = max; }
    public void setMin(int min) { this.min = min; }
    public void setSelected(int selected) { this.selected = selected; }
    public void setSqlQueryText(String sqlQueryText) { SqlQueryText = sqlQueryText; }
    public void setQueryResult(ArrayList<FlightDetailBean> queryResult)
    { this.queryResult = queryResult; }


    public void Reset()
    {
        ndx = max = min = 0 ;
        queryResult.clear() ;
    }
    public void add( FlightDetailBean e ) { queryResult.add( e ) ; max = queryResult.size()-1 ; }
    public int size() { return queryResult.size() ; }
    public FlightDetailBean getRecord() { return queryResult.get( ndx ) ; }
    public void Initial( int max, int min, int ndx )
    {
        if ( !bInitialized )
        {
            this.max = max ;
            this.min = min ;
            this.ndx = ndx ;
            bInitialized = true ;
        }
    }
    public void unlockInitial() { bInitialized = false ; }
    public void setNavigate(String nav )
    {
        switch( nav )
        {
            case "nav-first": ndx =  min  ; break ;
            case "nav-prev":  ndx = ndx > min ? --ndx : min ; break ;
            case "nav-next":  ndx = ndx < max ? ++ndx : max ; break ;
            case "nav-last":  ndx = max ; break ;
            case "nav-select": selected = ndx ; break ;
        }
    }
}