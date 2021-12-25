package com.flightapp.models;

import java.util.Date;


public class SearchFlight {
private Date fltDate;
private String fromLoc;
private String toLoc;
private boolean roundTrip;
public Date getFltDate() {
	return fltDate;
}
public void setFltDate(Date fltDate) {
	this.fltDate = fltDate;
}
public String getFromLoc() {
	return fromLoc;
}
public void setFromLoc(String fromLoc) {
	this.fromLoc = fromLoc;
}
public String getToLoc() {
	return toLoc;
}
public void setToLoc(String toLoc) {
	this.toLoc = toLoc;
}
public boolean isRoundTrip() {
	return roundTrip;
}
public void setRoundTrip(boolean roundTrip) {
	this.roundTrip = roundTrip;
}
@Override
public String toString() {
	return "SearchFlight [fltDate=" + fltDate + ", fromLoc=" + fromLoc + ", toLoc=" + toLoc + ", roundTrip=" + roundTrip
			+ "]";
}

}
