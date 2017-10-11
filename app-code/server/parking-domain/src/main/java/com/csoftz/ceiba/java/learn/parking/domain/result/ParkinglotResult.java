/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTRESULT.JAVA                                       */
/* Description:   REST Controller result domain object.                       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.11/2017                                                 */
/* Last Modified: Oct.11/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.11/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.domain.result;

/**
 * REST Controller result domain object.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.11/2017
 * @since 1.8 (JDK), Oct.11/2017
 */
public class ParkinglotResult {

	private int resultCode;
	private String msg;
	private Object data;

	/**
	 * Constructor with parameters.
	 * 
	 * @param resultCode
	 * @param msg
	 * @param data
	 */
	public ParkinglotResult(int resultCode, String msg, Object data) {
		super();
		this.resultCode = resultCode;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * @return the resultCode
	 */
	public int getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode
	 *            the resultCode to set
	 */
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
