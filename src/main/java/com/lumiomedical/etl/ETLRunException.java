package com.lumiomedical.etl;

/**
 * @author Pierre Lecerf (plecerf@lumiomedical.com)
 * Created on 2020/03/09
 */
public class ETLRunException extends ETLException
{
    /**
     *
     * @param message
     */
    public ETLRunException(String message)
    {
        super(message);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public ETLRunException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
