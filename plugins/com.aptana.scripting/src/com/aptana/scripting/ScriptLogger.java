package com.aptana.scripting;

import java.util.ArrayList;
import java.util.List;

public class ScriptLogger
{
	private static ScriptLogger INSTANCE;
	
	private List<ScriptLogListener> _logListeners;
	
	/**
	 * logError
	 * 
	 * @param msg
	 * @param e
	 */
	public static void logError(String msg, Throwable e)
	{
		getInstance().fireLogErrorEvent(msg);
	}

	/**
	 * logInfo
	 * 
	 * @param string
	 */
	public static void logInfo(String msg)
	{
		getInstance().fireLogInfoEvent(msg);
	}

	/**
	 * logWarning
	 * 
	 * @param msg
	 */
	public static void logWarning(String msg)
	{
		getInstance().fireLogWarningEvent(msg);
	}

	/**
	 * trace
	 * 
	 * @param string
	 */
	public static void trace(String msg)
	{
		getInstance().fireTraceEvent(msg);
	}
	
	/**
	 * getInstance
	 * 
	 * @return
	 */
	public static ScriptLogger getInstance()
	{
		if (INSTANCE == null)
		{
			INSTANCE = new ScriptLogger();
		}
		
		return INSTANCE;
	}
	
	private ScriptLogger()
	{
	}
	
	/**
	 * addLogListener
	 * 
	 * @param listener
	 */
	public void addLogListener(ScriptLogListener listener)
	{
		if (listener != null)
		{
			if (this._logListeners == null)
			{
				this._logListeners = new ArrayList<ScriptLogListener>();
			}
			
			this._logListeners.add(listener);
		}
	}
	
	/**
	 * fireLogErrorEvent
	 * 
	 * @param error
	 */
	public void fireLogErrorEvent(String error)
	{
		if (this._logListeners != null)
		{
			for (ScriptLogListener listener : this._logListeners)
			{
				listener.logError(error);
			}
		}
	}
	
	/**
	 * fireLogInfoEvent
	 * 
	 * @param error
	 */
	public void fireLogInfoEvent(String info)
	{
		if (this._logListeners != null)
		{
			for (ScriptLogListener listener : this._logListeners)
			{
				listener.logInfo(info);
			}
		}
	}
	
	/**
	 * fireLogWarningEvent
	 * 
	 * @param error
	 */
	public void fireLogWarningEvent(String warning)
	{
		if (this._logListeners != null)
		{
			for (ScriptLogListener listener : this._logListeners)
			{
				listener.logWarning(warning);
			}
		}
	}
	
	/**
	 * fireTraceEvent
	 * 
	 * @param error
	 */
	public void fireTraceEvent(String message)
	{
		if (this._logListeners != null)
		{
			for (ScriptLogListener listener : this._logListeners)
			{
				listener.trace(message);
			}
		}
	}
	
	/**
	 * removeLogListener
	 * 
	 * @param listener
	 */
	public void removeLogListener(ScriptLogListener listener)
	{
		if (this._logListeners != null)
		{
			this._logListeners.remove(listener);
		}
	}
}
