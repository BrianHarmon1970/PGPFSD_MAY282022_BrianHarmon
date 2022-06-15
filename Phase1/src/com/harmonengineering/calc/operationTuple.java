package com.harmonengineering.calc;
class  operationTuple
{
    Double m_dOperand;
    String m_strOperator;
    public enum OPTYPE { MULTIPLY, DIVIDE, SUBTRACT, ADD }   ;
    OPTYPE m_OPTYPE ;
    public operationTuple(String optor, Double opand)
    {
        Set( optor , opand ) ;
    }
    public void Set( String optor, Double opand )
    {
        m_dOperand = opand ;
        m_strOperator = optor ;
        switch ( optor.charAt(0))
        {
        case '+': m_OPTYPE = OPTYPE.ADD ; break ;
        case '-': m_OPTYPE = OPTYPE.SUBTRACT ; break ;
        case '/': m_OPTYPE = OPTYPE.DIVIDE ; break ;
        case '*': m_OPTYPE = OPTYPE.MULTIPLY ; break ;
        }
    }
    public OPTYPE getOptype( ) { return m_OPTYPE ; }
    public String getOperator() { return m_strOperator ; }
    public Double getOperand( ) { return m_dOperand ; }
}