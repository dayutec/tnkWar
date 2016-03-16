package com.smalf.aService;



import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * This class implements custom exception for basicplayer.
 */
public class BasicPlayerException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String GAINCONTROLNOTSUPPORTED = "Gain control not supported";
    public static final String PANCONTROLNOTSUPPORTED = "Pan control not supported";
    public static final String WAITERROR = "Wait error";
    public static final String CANNOTINITLINE = "Cannot init line";
    public static final String SKIPNOTSUPPORTED = "Skip not supported";
    private Throwable cause = null;

    public BasicPlayerException()
    {
        super();
    }

    public BasicPlayerException(String msg)
    {
        super(msg);
    }

    public BasicPlayerException(Throwable cause)
    {
        super();
        this.cause = cause;
    }

    public BasicPlayerException(String msg, Throwable cause)
    {
        super(msg);
        this.cause = cause;
    }

    public Throwable getCause()
    {
        return cause;
    }

    /**
     * Returns the detail message string of this throwable. If it was
     * created with a null message, returns the following:
     * (cause==null ? null : cause.toString()).
     */
    public String getMessage()
    {
        if (super.getMessage() != null)
        {
            return super.getMessage();
        }
        else if (cause != null)
        {
            return cause.toString();
        }
        else
        {
            return null;
        }
    }

    public void printStackTrace()
    {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream out)
    {
        synchronized (out)
        {
            PrintWriter pw = new PrintWriter(out, false);
            printStackTrace(pw);
            pw.flush();
        }
    }

    public void printStackTrace(PrintWriter out)
    {
        if (cause != null) cause.printStackTrace(out);
    }
}
