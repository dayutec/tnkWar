package com.smalf.aService;


import java.util.Collection;
import java.util.Iterator;

/**
 * This class implements a threaded events launcher.
 */
public class BasicPlayerEventLauncher extends Thread
{
    private int code = -1;
    private int position = -1;
    private double value = 0.0;
    private Object description = null;
    private Collection listeners = null;
    private Object source = null;

    /**
     * Contructor.
     * @param code
     * @param position
     * @param value
     * @param description
     * @param listeners
     * @param source
     */
    public BasicPlayerEventLauncher(int code, int position, double value, Object description, Collection listeners, Object source)
    {
        super();
        this.code = code;
        this.position = position;
        this.value = value;
        this.description = description;
        this.listeners = listeners;
        this.source = source;
    }

    public void run()
    {
        if (listeners != null)
        {
            Iterator it = listeners.iterator();
            while (it.hasNext())
            {
                BasicPlayerListener bpl = (BasicPlayerListener) it.next();
                BasicPlayerEvent event = new BasicPlayerEvent(source, code, position, value, description);
                bpl.stateUpdated(event);
            }
        }
    }
}
