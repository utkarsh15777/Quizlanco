package com.utkarsh.quiz.models;

import java.util.ArrayList;


public class WrapperList {
	
	private ArrayList<SelectedAnswer> selA;
	
	
	public WrapperList() {
		super();
	}

	public WrapperList(ArrayList<SelectedAnswer> selA) {
		super();
		this.selA = selA;
	}

	public ArrayList<SelectedAnswer> getSelA() {
		return selA;
	}

	public void setSelA(ArrayList<SelectedAnswer> selA) {
		this.selA = selA;
	}
	
}
