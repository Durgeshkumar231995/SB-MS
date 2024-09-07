package com.trans.microservices.LimitsServices.bean;

public class LimitConfiguration {
int maximum;
int minimum;
LimitConfiguration() {}

public LimitConfiguration(int maximum, int minimum) {
	super();
	this.maximum = maximum;
	this.minimum = minimum;
}


public int getMaximum() {
	return maximum;
}


public void setMaximum(int maximum) {
	this.maximum = maximum;
}


public int getMinimum() {
	return minimum;
}


public void setMinimum(int minimum) {
	this.minimum = minimum;
}





}
